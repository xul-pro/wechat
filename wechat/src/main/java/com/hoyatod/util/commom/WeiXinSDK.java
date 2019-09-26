package com.hoyatod.util.commom;

public class WeiXinSDK {
	
	//测试号   1.onNBmwjmuw6UiHMcMf0Ll72x-GDs  2.onNBmwuv2QzKRbY_6XGXP8yHTEPE
	public static final String APPID = "wxab573c02af878c77";
	public static final String APPSECRET = "719fa772aedff2b6a12b29fa40109d62";
	//个人账号 
//	public static final String APPID = "wxd1c3efed0803b3b9";
//	public static final String APPSECRET = "8a0f2cbeb766a3cbf1c805b6ffe6f8dc";
	public static final String MENU = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=TOKEN";
	public static final String TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	public static final String TEMPLATE = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
	public final static String TEMPLATE_NEWS_LIST = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN";//模板消息列表接口
	
	//网页授权
	public static final String AUTHORIZE = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxab573c02af878c77&redirect_uri=http://967f4cab.ngrok.io/index&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
	public static final String CODE = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	public static final String USERINFO = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

	//现金红包接口
	public static final String REDPACK = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
}
