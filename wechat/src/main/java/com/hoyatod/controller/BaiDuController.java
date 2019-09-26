package com.hoyatod.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hoyatod.util.OkhttpUtil;

@Controller
public class BaiDuController {

	@RequestMapping(value = "/baiDuTJ")
	public String baiduTJ(String startTime, String endTime) throws JsonProcessingException {
		String url = "https://api.baidu.com/json/tongji/v1/ReportService/getData";

		Map<String, String> header = new LinkedHashMap<String, String>();
		header.put("username", "chlscc"); // 賬戶
		header.put("password", "chlsc1987122"); // 密碼
		header.put("token", "d45d8d9e6965ad4c283e0cafd335ce07"); // token
		header.put("account_type", "1"); // 固定參數

		Map<String, String> body = new LinkedHashMap<String, String>();
		body.put("siteId", "10781839"); // 动态参数 站点id
		body.put("method", "trend/time/a"); // 配置参数
		body.put("start_date", "20171205"); // 开始时间
		body.put("end_date", "20171205"); // 结束时间
		body.put("metrics", "pv_count,visitor_count");// ip_count,bounce_ratio,avg_visit_time 获取数据量

		Map<String, Object> params = new LinkedHashMap<String, Object>();
		params.put("header", header);
		params.put("body", body);

		ObjectMapper json = new ObjectMapper();
		String param = json.writeValueAsString(params);

		String doPostHttpRequest = OkhttpUtil.doPostHttpRequest(url, param); // http post请求

		return "";
	}
}
