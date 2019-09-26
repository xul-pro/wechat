package com.hoyatod.util.commom;

import java.io.IOException;

public class HTTPUtil {
	
	
	public static Token getToken() throws IOException {
		String doGetHttpRequest = OkhttpUtil.doGetHttpRequest(WeiXinSDK.TOKEN.replace("APPID", WeiXinSDK.APPID).replaceAll("APPSECRET", WeiXinSDK.APPSECRET));
		Token gsonToBean = GsonUtil.GsonToBean(doGetHttpRequest, Token.class);
		return gsonToBean;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(getToken());
	}
}
