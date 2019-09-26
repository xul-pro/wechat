package baidu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hoyatod.entity.baidu.Flow;
import com.hoyatod.entity.baidu.SiteList;
import com.hoyatod.util.OkhttpUtil;

public class BaiDuTest {
	
	
	/**
	 * 1.获取当前用户下的站点和子目录列表以及对应参数信息，不包括权限站点和汇总网站。
	 * https://api.baidu.com/json/tongji/v1/ReportService/getSiteList
	 * 
	 * 2.根据站点ID获取站点报告数据。
	 * https://api.baidu.com/json/tongji/v1/ReportService/getData
	 * 
	 * token = d45d8d9e6965ad4c283e0cafd335ce07
	 * @throws IOException 
	 * @throws JsonProcessingException  http://top100.xinmeikuang.com/bdtj.html
	 */
	
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 500; i++) {
			String doGetHttpRequest = OkhttpUtil.doGetHttpRequest("http://top100.xinmeikuang.com/bdtj.html");
			System.out.println(doGetHttpRequest + ":" + i);
		}
	}
	@Test
	public void getData() throws JsonProcessingException {
	    String url = "https://api.baidu.com/json/tongji/v1/ReportService/getData";
	    
        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("username","xuliangbdtj"); //賬戶
        header.put("password","Xl2019"); //密碼
        header.put("token","e0c7f480546eed21fff95abbe53c71d3"); // token	-
        header.put("account_type","1"); //固定参数

        Map<String, String> body = new LinkedHashMap<String, String>();
        body.put("siteId","12996839");    //动态参数 站点id 12996839  
        body.put("method","trend/time/a"); // 配置参数
        body.put("start_date","20190109");  //开始时间
        body.put("end_date","20190110");    // 结束时间
        body.put("metrics","pv_count,visitor_count,ip_count,bounce_ratio,avg_visit_time,avg_visit_pages");//ip_count,bounce_ratio,avg_visit_time 获取数据量

        Map<String, Object> params = new LinkedHashMap<String, Object>();
        params.put("header", header);
        params.put("body", body);
        
        ObjectMapper json = new ObjectMapper();
        String param = json.writeValueAsString(params);
        
		String doPostHttpRequest = OkhttpUtil.doPostHttpRequest(url, param); //http  post请求
		System.out.println(doPostHttpRequest.toString());
		
		com.alibaba.fastjson.JSONObject parseObject2 = JSON.parseObject(doPostHttpRequest);
		String data=parseObject2.getString("body");
		parseObject2= JSON.parseObject(data);
		JSONArray jsonArray =parseObject2.getJSONArray("data");
			
		com.alibaba.fastjson.JSONObject j = com.alibaba.fastjson.JSONObject.parseObject(jsonArray.getJSONObject(0).toString());
		com.alibaba.fastjson.JSONObject j1 = com.alibaba.fastjson.JSONObject.parseObject(j.get("result").toString());
		
		JSONArray object3 = j1.getJSONArray("pageSum");
		JSONArray jsonArray2 = object3.getJSONArray(0);
		Integer pv = (Integer)jsonArray2.get(0);
		Integer pu = (Integer)jsonArray2.get(1);
		Integer ip = (Integer)jsonArray2.get(2);
		
		Integer bounce_ratio = (Integer)jsonArray2.get(3); //所查询指标为跳出率
		Integer avg_visit_time = (Integer)jsonArray2.get(4);//平均访问时长
		Integer avg_visit_pages = (Integer)jsonArray2.get(5);//平均访问页数
		
		Flow flow = new Flow();
		flow.setPv(pv);
		flow.setPu(pu);
		flow.setIp(ip);
		flow.setBounce_ratio(bounce_ratio);
		flow.setAvg_visit_time(avg_visit_time);//秒
		flow.setAvg_visit_pages(avg_visit_pages);
		
		System.out.println(flow);
	}
	
	@Test
	public void getSiteList() throws JsonProcessingException {
		String url = "https://api.baidu.com/json/tongji/v1/ReportService/getSiteList";
		
        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put("username","xuliangbdtj");        				//賬戶
        header.put("password","Xl2019");  				//密码
        header.put("token","e0c7f480546eed21fff95abbe53c71d3"); // token
        header.put("account_type","1");         				//固定參數

        Map<String, String> body = new LinkedHashMap<String, String>();
        body.put("siteId","1");      //动态参数 站点id 11479659  10781839
        body.put("method","trend/time/a");  // 配置参数
        body.put("start_date","20190109");  //开始时间
        body.put("end_date","20190110");    // 结束时间
        body.put("metrics","pv_count,visitor_count,ip_count");//ip_count,bounce_ratio,avg_visit_time 获取数据量

        Map<String, Object> params = new LinkedHashMap<String, Object>();
        params.put("header", header);
        
        ObjectMapper json = new ObjectMapper();
        String param = json.writeValueAsString(params);
        
		String doPostHttpRequest = OkhttpUtil.doPostHttpRequest(url, param);  //https  post请求
		
		com.alibaba.fastjson.JSONObject parseObject2 = JSON.parseObject(doPostHttpRequest);
		String data=parseObject2.getString("body");
		parseObject2= JSON.parseObject(data);
		JSONArray jsonArray =parseObject2.getJSONArray("data");
		
		com.alibaba.fastjson.JSONObject j = com.alibaba.fastjson.JSONObject.parseObject(jsonArray.getJSONObject(0).toString());
		Object object = j.get("list");
		
		@SuppressWarnings("static-access")
		JSONArray parseArray = parseObject2.parseArray(object.toString());
		
		SiteList siteList = new SiteList();
		List<SiteList> lists = new ArrayList<SiteList>();
		for (int i = 0; i < parseArray.size(); i++) {
			com.alibaba.fastjson.JSONObject parseObject = JSON.parseObject(parseArray.get(i).toString());
			
			String create_time = (String) parseObject.get("create_time");
			String domain = (String) parseObject.get("domain");
			int site_id = (int) parseObject.get("site_id");
			int status = (int) parseObject.get("status");
			
			siteList.setCreate_time(create_time);
			siteList.setDomain(domain);
			siteList.setSite_id(site_id);
			siteList.setStatus(status);
			lists.add(siteList);
			
		}
		for (int i = 0; i < lists.size(); i++) {
			System.out.println(i+"."+lists.get(i));
		}
	}
}


