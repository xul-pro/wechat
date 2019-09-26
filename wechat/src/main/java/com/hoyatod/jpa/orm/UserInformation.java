package com.hoyatod.jpa.orm;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author 作者 : xul
 * @date 创建时间：2018年3月21日 上午10:39:30
 * @version 1.0
 */
@Entity
@Table(name = "test")
public class UserInformation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String username;
	private String phone;
	private String email;
	private String wechat;
	private String hobby;
	private String investmentpreference;
	private boolean view;
	
	
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getInvestmentpreference() {
		return investmentpreference;
	}

	public void setInvestmentpreference(String investmentpreference) {
		this.investmentpreference = investmentpreference;
	}

	public boolean isView() {
		return view;
	}

	public void setView(boolean view) {
		this.view = view;
	}

}
