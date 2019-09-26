package com.hoyatod.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoyatod.dto.WechatDataDTO;
import com.hoyatod.service.WxMpService;
import com.hoyatod.template.WechatTemplateMsgService;
import com.hoyatod.util.WechatUtil;
import com.hoyatod.util.commom.State;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;

@Controller
public class WechatController {
	
	private static Logger log = Logger.getLogger(WechatController.class);
	
	@Autowired
	private WxMpService wxService;
	
	@RequestMapping(value = "/wechat", method = { RequestMethod.GET, RequestMethod.POST })
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			StringBuffer sb = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
			String s = "";
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
			String xml = sb.toString();  //次即为接收到微信端发送过来的xml数据                          
			String result = "";
			
		    String echostr = request.getParameter("echostr");  //判断是否是微信接入激活验证，只有首次接入验证时才会收到echostr参数，此时需要把它直接返回
			if (echostr != null && echostr.length() > 1) {
				result = echostr;
			} else {
				System.out.println("********************接入成功******************");
				System.out.println("xm:" + xml);
//				result = WechatService.processWechatMag(xml); 图灵机器人
				WechatDataDTO qr_CodeXmlData = WechatUtil.QR_CodeXmlData(xml);
				if(qr_CodeXmlData != null) {
					
					System.out.println("WechatDataDTO:" + qr_CodeXmlData);
					String fromUserName = qr_CodeXmlData.getFromUserName();
					/*
					 * 存储信息
					 * */
					if(qr_CodeXmlData.getEvent() != null && !qr_CodeXmlData.getEvent().equals("")) {
						if(qr_CodeXmlData.getEvent().equalsIgnoreCase("scan") || qr_CodeXmlData.getEvent().equalsIgnoreCase("subscribe")) {
							State sendTemplateMsg = WechatTemplateMsgService.sendTemplateMsg(fromUserName);
							if(sendTemplateMsg.getErrmsg().equals("ok")) {
								result = WechatUtil.formatXmlAnswer(qr_CodeXmlData.getFromUserName(),qr_CodeXmlData.getToUserName(),sendTemplateMsg.getErrmsg());
							}
						}
					}else if (qr_CodeXmlData.getMsgType().equals("text")) {
						result = WechatUtil.formatXmlAnswer(qr_CodeXmlData.getFromUserName(),qr_CodeXmlData.getToUserName(),"欢迎关注我的公众号！");
					}
				}
			}
			
			OutputStream os = response.getOutputStream();
			os.write(result.getBytes("UTF-8"));
			os.flush();
			os.close();
		} catch (Exception e) {
			log.error("系统异常", e);
		}
	}
	
	@RequestMapping(value = "/check",method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String check(HttpServletRequest request) {
		try {
			//微信服务器get传递的参数
			String signature = request.getParameter("signature");
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");
			String echostr = request.getParameter("echostr");
			
			WxMpInMemoryConfigStorage wxMemory = new WxMpInMemoryConfigStorage();
			//注入token值
			wxMemory.setToken("weixin");
			wxService.setWxMpConfigStorage(wxMemory);
			
			boolean checkSignature = wxService.checkSignature(signature, timestamp, nonce);
			if(checkSignature) {
				return echostr;
			}
			return null;
		} catch (Exception e) {
			log.error("异常", e);
			return null;
		}
	}
}
































