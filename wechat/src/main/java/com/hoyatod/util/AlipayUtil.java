package com.hoyatod.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hoyatod.entity.OrderForm;

/**
 * 支付宝即时到帐相关工具类
 * 
 * @author AzZ、xul
 *
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class AlipayUtil {
	
	public static String getSign (OrderForm of) {  
        Map<String,Object> params = new HashMap<String, Object>();//创建Map对象  
        params.put("service", of.getService());               //接口名称  
        params.put("out_trade_no", of.getOut_trade_no());     //商户网站订单  
        params.put("seller_email", of.getSeller_email());     //卖家支付宝帐户  
        params.put("partner", of.getPartner());               //支付宝合作伙伴id (账户内提取)  
        params.put("subject", of.getSubject());               //商品名称  
        params.put("body", of.getBody());                     //商品描述，  
        params.put("price", of.getPrice());                   //总价  
        params.put("show_url", of.getShow_url());             //商品展示网址  
        params.put("quantity", of.getQuantity());             //数量  
        params.put("payment_type", of.getPayment_type());     //支付类型  
        params.put("discount", of.getDiscount());             //折扣  
        params.put("_input_charset", of.getInput_charset());  //编码  
        params.put("return_url", of.getReturn_url());         //支付完成后跳转返回的网址URL  
        return map2Sign(params, of.getKey());                 //返回签名  
    }
	
	 /**
	  * 通过Map对象和key获取签名  
	  * @param params
	  * @param privateKey
	  * @return String
	  */
    private static String map2Sign (Map params, String privateKey) {  
		List keys = new ArrayList(params.keySet());             //转换成List  
        Collections.sort(keys);                                 //排序  
        StringBuffer signBuffer = new StringBuffer();           //创建StringBuffer对象  
        for (int i = 0; i < keys.size(); i++) {                 //循环获取Map值  
            String key = (String) keys.get(i);                  //key值  
            String value = (String) params.get(key);            //Map中的value值  
            if (value == null || value.trim().length() == 0) {  //如果值为空则跳过  
                continue;  
            }  
            signBuffer.append((i == 0 ? "" : "&") + key + "=" + value); //向signBuffer中添加值    
        }  
        return MD5.encodeMD5(signBuffer.toString() + privateKey);       //返回加密后的数据  
    }
    
    /**
     * 通过key获取签名  
     * @param params
     * @param privateKey
     * @return String
     */
    public static String getReturnSign(Map params, String privateKey) {  
        List keys = new ArrayList(params.keySet());    //转换成List  
        Collections.sort(keys);                        //排序  
        StringBuffer signBuffer = new StringBuffer();  //创建StringBuffer对象  
        for (int i = 0; i < keys.size(); i++) {        //循环获取Map值  
            String key = (String) keys.get(i);         //获取key值  
            String value = (String) params.get(key);   //获取Map中的value值  
            if (key == null || key.equalsIgnoreCase("sign") || key.equalsIgnoreCase("sign_type")) { //过滤掉空的key值和名为sign、sign_type的值   
                continue;  
            }  
            signBuffer.append((i == 0 ? "" : "&") + key + "=" + value); //向signBuffer中添加值    
        }  
        return MD5.encodeMD5(signBuffer.toString() + privateKey);       //返回加密后的数据  
    }  
    
    /**
     * 	读取url
     * 
     * @param url
     * @return String 
     */
    public static String readUrl(String url){
    	try {
			URL u = new URL(url);                                              //通过字符串url创建URL对象  
			HttpURLConnection huc = (HttpURLConnection)u.openConnection();     //获取HttpURLConnection   
			InputStreamReader in = new InputStreamReader(huc.getInputStream());//从获取HttpURLConnection中读取输入流  
			BufferedReader br = new BufferedReader(in);                        //创建BufferedReader对象  
			return br.readLine().toString();                                    //返回输入流中数据  
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
    }
}
