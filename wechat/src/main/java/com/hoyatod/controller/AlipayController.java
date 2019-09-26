package com.hoyatod.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hoyatod.config.AlipayConfig;
import com.hoyatod.entity.OrderForm;
import com.hoyatod.util.AlipayUtil;
import com.hoyatod.util.Tools;


/**
 * 支付宝支付请求
 * 
 * @author AzZ、xul
 */
@Controller
public class AlipayController {
	
	private static Logger log = Logger.getLogger(AlipayController.class);
	
	@RequestMapping(value = "/pay.do",method = {RequestMethod.GET,RequestMethod.POST})
	public String alipay(String goodName,String price,HttpServletRequest request,Model model) {
		try {
			log.info("goodName:" + goodName + "price:" + price);
			if (!Tools.isNullOrEmpty(goodName) && !Tools.isNullOrEmpty(price)) {  
			    OrderForm order = new OrderForm();  
			    order.setSubject(goodName);                               //商品名  
			    order.setPrice(price);                                    //价格  
			    order.setOut_trade_no(UUID.randomUUID().toString());      //通过UUID生成订单号  
			    order.setBody(goodName);                                  //商品描述  
			    order.setPayment_type(AlipayConfig.PAYMENT_TYPE);         //支付类型  
			    order.setDiscount("0");                                   //折扣  
			    order.setQuantity("1");                                   //数量  
			    order.setPaygateway(AlipayConfig.PAY_INTERFACE);          //支付接口  
			    order.setInput_charset(AlipayConfig.CHARSET);             //字符集  
			    order.setSign_type(AlipayConfig.SIGN_TYPE);               //签名方式  
			    order.setService(AlipayConfig.INTERFACE_NAME);            //接口名称  
			    order.setReturn_url(AlipayConfig.RETURN_URL);             //支付完成后跳转返回的网址URL  
			    order.setKey(AlipayConfig.KEY);                          //交易安全校验码（key）  
			    order.setSeller_email(AlipayConfig.SELLER_EMAIL);        //卖家支付宝帐户  
			    order.setPartner(AlipayConfig.PARTNER);                  //合作者身份（partnerID）  
			    order.setSign(AlipayUtil.getSign(order));                 //签名  
			    model.addAttribute("order", order);
			    return "order";
			}
			return "error";
		} catch (Exception e) {
			log.error("pay error!", e);
			return null;
		}
	}
	@SuppressWarnings({"unchecked","rawtypes"})
	@RequestMapping(value = "/callback", method  = {RequestMethod.GET,RequestMethod.POST})
	public String Callback(HttpServletRequest request,HttpServletResponse response,Model model) {
		try {
			String partner = AlipayConfig.PARTNER;                        //partner合作伙伴id（必须填写）  
			String key = AlipayConfig.KEY;                                //partner 的对应交易安全校验码（必须填写）  
			String alipayNotifyURL = "http://notify.alipay.com/trade/notify_query.do?";  
			String notify_id = request.getParameter("notify_id");          //支付宝流水号  
			String sign = request.getParameter("sign");                    //签名  
			String info = "<p>交易失败!</p>";                                //返回信息 
			if (!Tools.isNullOrEmpty(notify_id) && !Tools.isNullOrEmpty(sign)) {  
			    alipayNotifyURL = alipayNotifyURL + "partner=" + partner + "¬ify_id=" + notify_id;  
			    String responseTxt = AlipayUtil.readUrl(alipayNotifyURL);  //返回的支付结果  
			    if ("true".equals(responseTxt)) {                          //支付结果为true交易成功  
					Map params = new HashMap();  
					Map requestParams = request.getParameterMap();         //获得POST 过来参数设置到新的params中  
			        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) { //遍历所有参数    
			            String name = (String) iter.next();                    //参数名 
			            String[] values = (String[]) requestParams.get(name);  //参数值  
			            String valueStr = "";  
			            for (int i = 0; i < values.length; i++) {              //遍历数组类型的参数
			                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";  
			            }  
			            params.put(name, valueStr);                            //重新放入Map中  
			        }  
			        String mysign = AlipayUtil.getReturnSign(params, key);     //计算签名
			        if (mysign.equals(sign)) {                                 //如果计算签名与返回的签名相同，则信息是真实的
			            info = "<p>交易成功,请等待商家发货!</p>";  
			        }  
			    }  
			}  
			model.addAttribute("info", info);
			return "buyReturn";
		} catch (Exception e) {
			return "error";
		}
	}

}
