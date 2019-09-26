package com.hoyatod.dto;

public class RedPackDataDTO {

	private String nonce_str;// 随机字符串
	private String sign;// 签名
	private String mch_billno;// 商户订单号
	private String mch_id;// 商户号
	private String appid;// 公众账号appid
	private String send_name;// 商户名称
	private String openid;// 用户openid接受红包的用户
	private int total_amount;// 付款金额，单位分
	private int total_num;// 红包发放总人数 红包发放总人数
	private String wishing;// 红包祝福语感谢您参加猜灯谜活动，祝您元宵节快乐!
	private String client_ip;// 调用接口的机器Ip地址

	private String act_name; // 活动名称
	private String remark; // 备注信息
	private String scene_id; // 场景id 发放红包使用场景，红包金额大于200时必传
	private String risk_info;// 活动信息
	private String posttime;// 用户操作的时间戳
	private String mobile; // mobile:业务系统账号的手机号，国家代码-手机号。不需要+号
	private String deviceid;// deviceid :mac 地址或者设备唯一标识
	private String clientversion;// clientversion :用户操作的客户端版本
	private String urlencode;     // 把值为非空的信息用key=value进行拼接，再进行(posttime=xx& mobile =xx&deviceid=xx)
	private String consume_mch_id;  // 资金授权商户号 服务商替特约商户发放时使用

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getMch_billno() {
		return mch_billno;
	}

	public void setMch_billno(String mch_billno) {
		this.mch_billno = mch_billno;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getSend_name() {
		return send_name;
	}

	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public int getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}

	public int getTotal_num() {
		return total_num;
	}

	public void setTotal_num(int total_num) {
		this.total_num = total_num;
	}

	public String getWishing() {
		return wishing;
	}

	public void setWishing(String wishing) {
		this.wishing = wishing;
	}

	public String getClient_ip() {
		return client_ip;
	}

	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}

	public String getAct_name() {
		return act_name;
	}

	public void setAct_name(String act_name) {
		this.act_name = act_name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getScene_id() {
		return scene_id;
	}

	public void setScene_id(String scene_id) {
		this.scene_id = scene_id;
	}

	public String getRisk_info() {
		return risk_info;
	}

	public void setRisk_info(String risk_info) {
		this.risk_info = risk_info;
	}

	public String getPosttime() {
		return posttime;
	}

	public void setPosttime(String posttime) {
		this.posttime = posttime;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public String getClientversion() {
		return clientversion;
	}

	public void setClientversion(String clientversion) {
		this.clientversion = clientversion;
	}

	public String getUrlencode() {
		return urlencode;
	}

	public void setUrlencode(String urlencode) {
		this.urlencode = urlencode;
	}

	public String getConsume_mch_id() {
		return consume_mch_id;
	}

	public void setConsume_mch_id(String consume_mch_id) {
		this.consume_mch_id = consume_mch_id;
	}

}
