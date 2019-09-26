package com.hoyatod.api;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.hoyatod.config.WechatConfig;

import net.sf.json.JSONObject;

/** 
 * 调用图灵机器人api接口，获取智能回复内容 
 * 
 * @author xul 
 */  
public class TulingApiInterface {
	
	/** 
     * 调用图灵机器人api接口，获取智能回复内容，解析获取自己所需结果 
     * @param content 
     * @return String
     */  
	public static String getTulingResult(String content){  
        try {
        	//httpget请求  将参数转为url编码   
			String apiUrl = WechatConfig.TLAPI.replace("KEY", WechatConfig.APIKEY);  
			String param = apiUrl+URLEncoder.encode(content,"utf-8"); 
			HttpGet request = new HttpGet(param); 
			
			String result = null;  
			HttpResponse response = HttpClients.createDefault().execute(request);  
			if(response.getStatusLine().getStatusCode()==200){  
			    result = EntityUtils.toString(response.getEntity());  
			}  
			if(null == result){ //请求失败处理   
			    return WechatConfig.SYSTEM_ERROR;  
			}  
			JSONObject json = JSONObject.fromObject(result);
			if(100000==json.getInt("code")){   //以code=100000为例，参考图灵机器人api文档   
			    result = json.getString("text");  
			}  
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}  
    } 
	
    /** 调用图灵机器人平台接口  
    */   
    public static void main(String[] args) throws IOException {   
        /**String INFO = URLEncoder.encode("北京今日天气", "utf-8");   
        String getURL = "http://www.tuling123.com/openapi/api?key=" + WechatConfig.APIKEY + "&info=" + INFO;   
        URL getUrl = new URL(getURL);   
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();   
        connection.connect();   
        BufferedReader reader = new BufferedReader(new InputStreamReader( connection.getInputStream(), "utf-8"));  
        StringBuffer sb = new StringBuffer();   
        String line = "";   
        while ((line = reader.readLine()) != null) {   
            sb.append(line);   
        }   
        reader.close();   
        connection.disconnect();   
        System.out.println(sb);*/ 
//    	System.out.println(getTulingResult("武汉天气"));
    	
    	
    	
      
    } 

	@Test
	public void test() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + i * j + "\t");
			}
			System.out.println();
		}
	}
	
	
	@Test
	public void paiXu() {
		int [] arrs = {2,54,12,25,89,15};
		for (int i = 0; i < arrs.length; i++) {
			for (int j = i; j < arrs.length; j++) {
				if(arrs[i]>arrs[j]) {
					int temp = arrs[i];
					arrs[i] = arrs[j];
					arrs[j] = temp;
				}
			}
			System.out.println(arrs[i]);
		}
	}
}
