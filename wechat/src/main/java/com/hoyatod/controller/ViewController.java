package com.hoyatod.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoyatod.util.KeyWordFilter;


@Controller
public class ViewController {
	
	private static Logger log = Logger.getLogger(ViewController.class);
	
	@RequestMapping(value = "/word")
	public String index() {
		return "word";
	}
	
	@RequestMapping(value = "/keyWord")
	@ResponseBody
	public String keyWord(String word) {
		String doFilter;
		try {
			KeyWordFilter.initPattern();
			doFilter = KeyWordFilter.doFilter(word);
			return doFilter;
		} catch (Exception e) {
			log.error("异常..", e);
			return "异常....";
		}
		
	}
}
