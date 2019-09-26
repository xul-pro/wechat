package com.hoyatod.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoyatod.config.Constants;
import com.hoyatod.entity.ShareConfig;
import com.hoyatod.util.SignUtil;
import com.hoyatod.util.Tools;
import com.hoyatod.util.WechatTools;

@Controller
public class WechatShareController {
	
	private static Logger log = Logger.getLogger(WechatShareController.class);
	
	@RequestMapping(value = "/share",method = {RequestMethod.GET,RequestMethod.POST})
	public String share(HttpServletRequest request ,HttpServletResponse response,Model model) {
		try {
			ShareConfig config = new ShareConfig();
			config.setAppId(Constants.APPID);
			config.setUrl("http://0f4c9c34.ngrok.io/wechat/share"); // 当前连接
			config.setNonceStr(Tools.getRandomString(10));
			config.setTimestamp((new Date().getTime() + "").substring(0, 10));
			
			//System.out.println(SignUtil.signString(WechatTools.getTicket(), config.getUrl(), config.getNonceStr(), config.getTimestamp()));
			config.setSignature(SignUtil.signString(WechatTools.getTicket(),config.getUrl(),config.getNonceStr(), config.getTimestamp()));
			model.addAttribute("config", config);
			model.addAttribute("share_URL", ""); //分享链接
			return "index";
		} catch (Exception e) {
			log.error("分享异常", e);
			return null;
		}
	}   
	
	@RequestMapping(value = "/voice",method = {RequestMethod.GET,RequestMethod.POST})
	public String voice(HttpServletRequest request ,HttpServletResponse response,Model model) {
		try {
			ShareConfig config = new ShareConfig();
			config.setAppId(Constants.APPID);
			config.setUrl("http://0f4c9c34.ngrok.io/wechat/voice");  //当前连接
			config.setNonceStr(UUID.randomUUID().toString().replace("-", "").substring(0, 10)); 
			config.setTimestamp(""+(System.currentTimeMillis() / 1000));
			config.setSignature(SignUtil.signString(WechatTools.getTicket(),config.getUrl(),config.getNonceStr(), config.getTimestamp()));
			
			log.info("getNonceStr:"+config.getNonceStr());     
			log.info("getTimestamp:"+config.getTimestamp());
			
			model.addAttribute("config", config);
			
			model.addAttribute("share_URL", ""); //分享链接
			
			log.info("请求成功:"+config.getAppId());
			
			return "voice";
		} catch (Exception e) {
			log.error("系统异常", e);
			return null;
		}
	}
	
	@RequestMapping(value = "/smallUploadPictures",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String smallUploadPictures(HttpServletRequest request,HttpServletResponse response) {
		try {
			Map<String, Object> map = new HashMap<String,Object>();
			System.out.println("*************smallUploadPictures接口************************");
			String fileUpload = Tools.fileUpload(request, response);
			System.out.println("------调用文件上传success--------");
			if(fileUpload.equals("fail")){
				map.put("upload", false);
			}else if(fileUpload.equals("success")){ 
				map.put("upload", true);
			}
			return fileUpload;
		} catch (Exception e) {
			e.printStackTrace();
			return "FAIL";
		}
	}
  	
	@RequestMapping(value = "/{name}",method = RequestMethod.GET)
	public String test(@PathVariable String name) {
		System.out.println("name:" + name);
		return null;
	}
}




































