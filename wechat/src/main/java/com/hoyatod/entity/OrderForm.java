package com.hoyatod.entity;

/**
 * 支付宝实体类
 * 
 * @author Anz、xul
 *
 */
public class OrderForm {

	// *******账户信息***********
	private String paygateway; // 支付接口
	private String service; // 接口名称
	private String sign_type; // 签名方式
	private String out_trade_no; // 商户网站订单
	private String input_charset; // 字符集
	private String partner; // 支付宝合作伙伴id (账户内提取)
	private String key; // 支付宝安全校验码(账户内提取)
	private String seller_email; // 卖家支付宝帐户
	
	// *******商品信息***********
	private String body; // 商品描述
	private String subject; // 商品名称
	private String price; // 订单总价
	private String quantity; // 数量
	private String show_url; // 商品展示网址
	private String payment_type; // 支付类型
	private String discount; // 折扣
	private String return_url; // 支付完成后跳转返回的网址URL
	private String sign; // 签名

	public String getPaygateway() {
		return paygateway;
	}

	public void setPaygateway(String paygateway) {
		this.paygateway = paygateway;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getInput_charset() {
		return input_charset;
	}

	public void setInput_charset(String input_charset) {
		this.input_charset = input_charset;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSeller_email() {
		return seller_email;
	}

	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getShow_url() {
		return show_url;
	}

	public void setShow_url(String show_url) {
		this.show_url = show_url;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getReturn_url() {
		return return_url;
	}

	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
