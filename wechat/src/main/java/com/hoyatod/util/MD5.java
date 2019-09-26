package com.hoyatod.util;

import java.security.MessageDigest;

import org.apache.log4j.Logger;

/**
 * 采用MD5加密
 * 
 * @author Anz、xul
 *
 */
public class MD5 {
	
	private static Logger log = Logger.getLogger(MD5.class);
	/***  
     * MD5加密 生成32位md5码 
     * @param 待加密字符串 
     * @return 返回32位md5码 
     */  
	public static String encodeMD5(String inStr){
		MessageDigest md5 = null;  
        try {  
            md5 = MessageDigest.getInstance("MD5");  
        } catch (Exception e) {
        	log.error("调取异常", e);
            return null;  
        }  
        try {
			byte[] byteArray = inStr.getBytes("UTF-8");  
			byte[] md5Bytes = md5.digest(byteArray);  
			StringBuffer hexValue = new StringBuffer();  
			for (int i = 0; i < md5Bytes.length; i++) {  
			    int val = ((int) md5Bytes[i]) & 0xff;  
			    if (val < 16) {  
			        hexValue.append("0");  
			    }  
			    hexValue.append(Integer.toHexString(val));  
			}  
			return hexValue.toString();
		} catch (Exception e) {
			log.error("加密异常", e);
			return null;  
		}  
	}

}
