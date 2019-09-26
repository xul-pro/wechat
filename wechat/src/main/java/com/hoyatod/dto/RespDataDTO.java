package com.hoyatod.dto;

public class RespDataDTO {
	
	private String ticket;
	private String QR_url;
	private Integer expire_seconds;
	
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getQR_url() {
		return QR_url;
	}
	public void setQR_url(String qR_url) {
		QR_url = qR_url;
	}
	public Integer getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(Integer expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
	
	
	
	
}
