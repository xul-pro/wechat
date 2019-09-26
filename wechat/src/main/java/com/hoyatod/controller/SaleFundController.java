package com.hoyatod.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoyatod.util.WechatTools;

@Controller
public class SaleFundController {
	
	
	@RequestMapping(value = "/saleFund",method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Object saleFund() {
		try {
			String mess = WechatTools.httpGet();
			return mess;
		} catch (Exception e) {
			return null;
		}
		
	}
}
