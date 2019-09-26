package com.hoyatod.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.hoyatod.dto.WechatDataDTO;
import com.hoyatod.entity.Articles;
import com.hoyatod.entity.Music;
import com.hoyatod.entity.Voice;
import com.hoyatod.entity.WechatData;

/** 
 * TODO 解析接收到的微信xml，返回消息对象 
 * @author xul 
 * 
 */  
public class WechatUtil {
	
	private static Logger log = Logger.getLogger(WechatUtil.class);
		
	/**
	 * 具体业务处理
	 * 
	 * @param xml
	 * @return WechatData
	 */
	 public static WechatData resolveXmlData(String xml) {
		 WechatData msg = null;  
	        try {  
	            if (xml.length() <= 0 || xml == null) {  
	                return null;  
	            }
	            Document document = DocumentHelper.parseText(xml); // 将字符串转化为XML文档对象  
	            Element root = document.getRootElement();  // 获得文档的根节点
	            Iterator<?> iter = root.elementIterator();  //遍历根节点下所有子节点  
	              
	            msg = new WechatData(); 
	            
	            //利用反射机制，调用set方法   获取该实体的元类型
	            Class<?> c = Class.forName("com.hoyatod.entity.WechatData");  
	            msg = (WechatData)c.newInstance();                                           //创建实体对象  
	              
	            while(iter.hasNext()){  
	                Element ele = (Element)iter.next(); 
	                Field field = c.getDeclaredField(ele.getName());                           //获取set方法中的参数字段（实体类的属性）  
	                Method method = c.getDeclaredMethod("set"+ele.getName(), field.getType()); //获取set方法，field.getType())获取它的参数数据类型    
	                method.invoke(msg, ele.getText());                                         //调用set方法  
	            }
	            return msg;  
	        } catch (Exception e) {  
	            log.error("格式异常", e);
	            return null;
	        }  
	 }
	 
	 	/**
		 * 具体业务处理 处理xml 信息
		 * 
		 * @param xml
		 * @return UserConcernAndNeglectDTO
		 */
		 public static WechatDataDTO QR_CodeXmlData(String xml) {
			 WechatDataDTO msg = null;  
		        try {  
		            if (xml.length() <= 0 || xml == null) {  
		                return null;  
		            }
		            Document document = DocumentHelper.parseText(xml); // 将字符串转化为XML文档对象  
		            Element root = document.getRootElement();  // 获得文档的根节点
		            Iterator<?> iter = root.elementIterator();  //遍历根节点下所有子节点  
		              
		            msg = new WechatDataDTO(); 
		            
		            //利用反射机制，调用set方法   获取该实体的元类型
		            Class<?> c = Class.forName("com.hoyatod.dto.WechatDataDTO");  
		            msg = (WechatDataDTO)c.newInstance();                                           //创建实体对象  
		              
		            while(iter.hasNext()){  
		                Element ele = (Element)iter.next(); 
		                Field field = c.getDeclaredField(ele.getName());                           //获取set方法中的参数字段（实体类的属性）  
		                Method method = c.getDeclaredMethod("set"+ele.getName(), field.getType()); //获取set方法，field.getType())获取它的参数数据类型    
		                method.invoke(msg, ele.getText());                                         //调用set方法  
		            }
		            return msg;  
		        } catch (Exception e) {  
		            log.error("格式异常", e);
		            return null;
		        }  
		 }
	 
	/**
	 * 发送文本信息
	 * 
	 * @param to
	 * @param from
	 * @param content
	 * @return String
	 */
	public static String formatXmlAnswer(String to, String from, String content) {
		try {
			StringBuffer sb = new StringBuffer();
			Date date = new Date();
			sb.append("<xml><ToUserName><![CDATA[");
			sb.append(to);
			sb.append("]]></ToUserName><FromUserName><![CDATA[");
			sb.append(from);
			sb.append("]]></FromUserName><CreateTime>");
			sb.append(date.getTime());
			sb.append("</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[");
			sb.append(content);
			sb.append("]]></Content><FuncFlag>0</FuncFlag></xml>");
			return sb.toString();
		} catch (Exception e) {
			log.error("转换失败", e);
			return null;
		}
	}
	
	/**
	 * 发送图文消息
	 * 
	 * @param to
	 * @param from
	 * @param articles对象
	 * @return
	 */
	public static String formatXmlImgeText(String to, String from, Articles articles) {
		try {
			StringBuffer sb = new StringBuffer();
			Date date = new Date();
			sb.append("<xml><ToUserName><![CDATA[");
			sb.append(to);
			sb.append("]]></ToUserName><FromUserName><![CDATA[");
			sb.append(from);
			sb.append("]]></FromUserName><CreateTime>");
			sb.append(date.getTime());
			sb.append("</CreateTime><MsgType><![CDATA[news]]></MsgType><ArticleCount><![CDATA[");
			sb.append(articles.getItemList().size());
			sb.append("]]></ArticleCount><Articles>");                                                                                                                                                                                                                                                                                                                                                       
			for (int i = 0; i < articles.getItemList().size(); i++) {
				sb.append("<item><Title><![CDATA[");
				sb.append(articles.getItemList().get(i).getTitle());
				sb.append("]]></Title><Description><![CDATA[");
				sb.append(articles.getItemList().get(i).getDescription());
				sb.append("]]></Description><PicUrl><![CDATA[");
				sb.append(articles.getItemList().get(i).getPicUrl());
				sb.append("]]></PicUrl><Url><![CDATA[");
				sb.append(articles.getItemList().get(i).getUrl());
				sb.append("]]</Url></item>");
			}
			sb.append("</Articles><FuncFlag>0</FuncFlag></xml>");
			return sb.toString();
		} catch (Exception e) {
			log.error("转换失败", e);
			return null;
		}
	}
	
	/**
	 * 发送语音消息
	 * 
	 * @param to
	 * @param from
	 * @param voice
	 * @return String
	 */
	
	public static String formatXmlVoice(String to, String from, Voice voice) {
		try {
			StringBuffer sb = new StringBuffer();
			Date date = new Date();
			sb.append("<xml><ToUserName><![CDATA[");
			sb.append(to);
			sb.append("]]></ToUserName><FromUserName><![CDATA[");
			sb.append(from);
			sb.append("]]></FromUserName><CreateTime>");
			sb.append(date.getTime());
			sb.append("</CreateTime><MsgType><![CDATA[voice]]></MsgType><Voice>");
			sb.append("<MediaId><![CDATA[");
			sb.append(voice.getMediaId());
			sb.append("]]></MediaId></Voice></xml>");
			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 发送音乐消息
	 * 
	 * @param to
	 * @param from
	 * @param music  
	 * @return String
	 */
	public static String formatXmlMusic(String to, String from, Music music) {
		try {
			StringBuffer sb = new StringBuffer();
			Date date = new Date();
			sb.append("<xml><ToUserName><![CDATA[");
			sb.append(to);
			sb.append("]]></ToUserName><FromUserName><![CDATA[");
			sb.append(from);
			sb.append("]]></FromUserName><CreateTime>");
			sb.append(date.getTime());
			sb.append("</CreateTime><MsgType><![CDATA[music]]></MsgType><Music>");
			sb.append("<Title><![CDATA[");
			sb.append(music.getTitle());
			sb.append("]]></Title><Description><![CDATA[");
			sb.append(music.getDescription());
			sb.append("]]></Description><MusicUrl><![CDATA[");
			sb.append(music.getMusicUrl());
			sb.append("]]></MusicUrl><HQMusicUrl><![CDATA[");
			sb.append(music.getHQMusicUrl());
			sb.append("]]></HQMusicUrl></Music></xml>");
			return sb.toString();
		} catch (Exception e) {
			log.error("系统异常",e);
			return null;
		}
		
	}
}
