package com.hoyatod.template;

import java.util.Map;

public class WechatTemplateMsg {

	private String touser; // 接收者openid
	private String template_id; // 模板ID
	private String url; // 模板跳转链接
	private Map<String, Keyword> data; // data数据

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, Keyword> getData() {
		return data;
	}

	public void setData(Map<String, Keyword> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "WechatTemplateMsg [touser=" + touser + ", template_id=" + template_id + ", url=" + url + ", data="
				+ data + ", getTouser()=" + getTouser() + ", getTemplate_id()=" + getTemplate_id() + ", getUrl()="
				+ getUrl() + ", getData()=" + getData() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
