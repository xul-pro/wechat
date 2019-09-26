package com.hoyatod.wechat.menu.entity;

public class ComplexButton  extends Button{
	
	private Button[] sub_button;//子级菜单，因为一个一级菜单可以有多个二级菜单，所以这儿使用

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
	
}
