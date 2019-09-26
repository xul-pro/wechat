package com.hoyatod.config;

public class QR_Code {
	
	/**
	 *  http请求方式: POST
	 *	URL: https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKENPOST数据格式：json
	 *	POST数据例子：
	 *	1.{"action_name": "QR_LIMIT_SCENE", "action_info": {"scene": {"scene_id": 123}}}
	 *	或者也可以使用以下POST数据创建字符串形式的二维码参数：
	 *	2.{"action_name": "QR_LIMIT_STR_SCENE", "action_info": {"scene": {"scene_str": "123"}}}
	 */
	
	
	public final static String QR_SCENE = "QR_SCENE";  // 临时二维码  
	public final static String QR_LIMIT_SCENE = "QR_LIMIT_SCENE";  // 永久二维码  （整型）
	public final static String QR_LIMIT_STR_SCENE = "QR_LIMIT_STR_SCENE";   // 永久二维码 (字符串)  
	public final static String create_ticket_path = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";  // 创建二维码  
	
	public static void main(String[] args) {
		System.out.println("access_token".toUpperCase());
	}
}
