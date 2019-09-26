package com.hoyatod.config;

public class AlipayConfig {
    public static final String PAY_INTERFACE = "https://www.alipay.com/cooperate/gateway.do?";//支付接口 
    public static final String INTERFACE_NAME ="create_partner_trade_by_buyer";// "trade_create_by_buyer";//	接口名称  
    public static final String SIGN_TYPE = "MD5";//签名方式
    public static final String CHARSET = "UTF-8"; //字符集 
    public static final String PARTNER = "";//	支付宝合作伙伴id (账户内提取)
    public static final String KEY = "";//	支付宝安全校验码(账户内提取)
    public static final String SELLER_EMAIL = "";//	卖家支付宝账户
    public static final String PAYMENT_TYPE = "1";//	卖家支付宝账户
    public static final String RETURN_URL = "";  //	支付完成后跳转返回的网址URL  
}
