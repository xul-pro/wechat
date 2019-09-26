package com.hoyatod.wechat;

import org.apache.log4j.Logger;

import com.hoyatod.api.TulingApiInterface;
import com.hoyatod.config.WechatConfig;
import com.hoyatod.entity.WechatData;
import com.hoyatod.util.WechatUtil;


/**
 *  消息智能回复服务
 * 
 * @author Silencn
 */
public class WechatService {
	
	private static Logger log = Logger.getLogger(WechatService.class);
	
	
	/**
	 * 图灵智能机器人只能回复
	 * 
	 * @param xml
	 * @return String
	 */
    public static String processWechatMag(String xml){  
		try {
			WechatData wechatData = WechatUtil.resolveXmlData(xml);  
			String result = "";  
			if(WechatConfig.RESP_MESSAGE_TYPE_TEXT.endsWith(wechatData.getMsgType())){  
			    result = TulingApiInterface.getTulingResult(wechatData.getContent());
			}  
			result = WechatUtil.formatXmlAnswer(wechatData.getFromUserName(), wechatData.getToUserName(), result);  
			return result;
		} catch (Exception e) {
			log.error("返回出错", e);
			return null;
		}  
    } 
}
