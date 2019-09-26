package com.hoyatod.config;

public class WechatSDK {
	
	public final static String OAUTH_TOKEN_URL =    //H5通过code获取token
			"https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=APPSECRET&code=CODE&grant_type=authorization_code";
	
	public final static String TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	public final static String TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	
	public final static String USERINFO_URL =    //http：GET如果网页授权作用域为snsapi_userinfo,开发者可以通过access_token和openid拉取用户信息。
			"https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	public final static String APPLET_OAUTH_USERINFO_URL = //小程序搜权获取用户基本信息
			"https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=APPSECRET&js_code=CODE&grant_type=authorization_code";
	public final static String WECHAT_ORDER_URL = //微信支付统一下单接口
			"https://api.mch.weixin.qq.com/pay/unifiedorder";
	public final static String APPLET_OAUTH_TOKEN_URL = //小程序授权获取TOKEN
			"https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	public final static String APPLET_CODE = //小程序获取二维码接口
			"https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token=ACCESS_TOKEN";
	public final static String APPLET_TEMPLATE_NEWS = //小程序发送模板接口
			"https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN";
	public final static String TEMPLATE_NEWS_LIST = //模板消息列表接口
			"https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN";
	
	
	/**
	 * 微信统一下单接口
	 */
	public final static String ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	
	public final static String APPID = "" ; // appId
	public final static String SECRET = "" ; // 密匙
	
	public final static String MCH_ID = "1238627002";//微信支付分配的商户号
	public final static String API_KEY = "WIRAdZ6FFe0cq2oiETis3ICIFlrpcbE9";// 商户API密钥 自行去商户平台设置
}
