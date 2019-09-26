package com.hoyatod.template;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hoyatod.util.OkhttpUtil;
import com.hoyatod.util.commom.GsonUtil;
import com.hoyatod.util.commom.HTTPUtil;
import com.hoyatod.util.commom.State;
import com.hoyatod.util.commom.TemplateMsgList;
import com.hoyatod.util.commom.WeiXinSDK;


@Service(value = "WechatTemplateMsgService")
public class WechatTemplateMsgService {
	
	public static State sendTemplateMsg(WechatTemplateMsg wechatTemplateMsg) throws IOException {
//		System.out.println(GsonUtil.GsonString(wechatTemplateMsg)); 
		System.out.println(JSON.toJSONString(wechatTemplateMsg));
		String doPostHttpRequest = OkhttpUtil.doPostHttpRequest(WeiXinSDK.TEMPLATE.replace("ACCESS_TOKEN", HTTPUtil.getToken().getAccess_token()), JSON.toJSONString(wechatTemplateMsg));
		State gsonToBean = GsonUtil.GsonToBean(doPostHttpRequest, State.class);
		return gsonToBean;
		
	}
	
	public static TemplateMsgList getTemplateMsgList() throws IOException {
		String doPostHttpRequest = OkhttpUtil.doGetHttpRequest(WeiXinSDK.TEMPLATE_NEWS_LIST.replace("ACCESS_TOKEN", HTTPUtil.getToken().getAccess_token()));
		JSONArray jsonArray = JSON.parseObject(doPostHttpRequest).getJSONArray("template_list");
		TemplateMsgList gsonToBean = null;
		if(jsonArray != null) {
			for (int i = 0; i < jsonArray.size(); i++) {
				Object object = jsonArray.get(i);
				System.out.println("转换:"+JSON.toJavaObject(JSON.parseObject(object.toString()), TemplateMsgList.class));
				
				gsonToBean = GsonUtil.GsonToBean(object.toString(), TemplateMsgList.class);
			}
		}
		return gsonToBean;
		
	}
	
	public static State sendTemplateMsg(String openid) throws IOException {
		WechatTemplateMsg wechatTemplateMsg = new WechatTemplateMsg();  
        wechatTemplateMsg.setTemplate_id("g2qPDMnsao_9FF5EIdy2Yv-jWgzFf-iOwPEn-EzSIsA");    
        wechatTemplateMsg.setTouser(openid); //openid需要 
        wechatTemplateMsg.setUrl("http://music.163.com/#/song?id=27867140");
        Map<String, Keyword> data = new HashMap<String,Keyword>();
        Keyword key = new Keyword();
        key.setValue("徐良");
        key.setColor("#228B22");
        data.put("User",key);
        
        Keyword key1 = new Keyword();
        key1.setValue("2019年2月27日");
        key1.setColor("#8B0000");
        data.put("Date",key1);
        
        Keyword key2 = new Keyword();
        key2.setValue("个人公众号测试！");
        key2.setColor("#808000");
        data.put("Info",key2);
        
        
        wechatTemplateMsg.setData(data);
        State sendTemplateMsg = sendTemplateMsg(wechatTemplateMsg);
		return sendTemplateMsg;
		
	}
	public static void main(String[] args) throws IOException {
		
		WechatTemplateMsg wechatTemplateMsg = new WechatTemplateMsg();  
        wechatTemplateMsg.setTemplate_id("g2qPDMnsao_9FF5EIdy2Yv-jWgzFf-iOwPEn-EzSIsA");    
        wechatTemplateMsg.setTouser("onNBmwsWiUDGqOqPjNBodtlslSIs"); //openid需要 
        wechatTemplateMsg.setUrl("http://music.163.com/#/song?id=27867140");
        Map<String, Keyword> data = new HashMap<String,Keyword>();
        Keyword key = new Keyword();
        key.setValue("username");
        key.setColor("#228B22");
        data.put("User",key);
        
        Keyword key1 = new Keyword();
        key1.setValue("2019年6月19日");
        key1.setColor("#8B0000");
        data.put("Date",key1);
        
        Keyword key2 = new Keyword();
        key2.setValue("欢迎加入公众号！");
        key2.setColor("#808000");
        data.put("Info",key2);
        
        
        wechatTemplateMsg.setData(data);
        State sendTemplateMsg = sendTemplateMsg(wechatTemplateMsg);
        System.out.println(sendTemplateMsg.getErrmsg());
		
//		System.out.println(getTemplateMsgList());
	}
}
