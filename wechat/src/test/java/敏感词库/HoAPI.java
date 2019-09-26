package 敏感词库;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

import com.hoyatod.util.OkhttpUtil;

@SuppressWarnings({"rawtypes","unchecked"})//红12
public class HoAPI {
	
	
	@Test
	public void check() throws IOException {
		
		//?str=红包&token=8cba8a838ff3670f83a9f2186a9ee3e1
		String url = "http://www.hoapi.com/index.php/Home/Api/check";
		HoApiDTO hoApiDTO = new HoApiDTO();
		hoApiDTO.setStr("红包");
		hoApiDTO.setToken("8cba8a838ff3670f83a9f2186a9ee3e1");
		hoApiDTO.setLv(1);
		
//		Map parames = new HashMap<String, String>();
//		parames.put("str", "红包");  
//        parames.put("token", "8cba8a838ff3670f83a9f2186a9ee3e1");  
//        parames.put("lv", "1");  
		
//		String doPostHttpRequest = OkhttpUtil.doPostHttpRequest(url, parames.toString());
//		String doGetHttpRequest = OkhttpUtil.doGetHttpRequest(url);
        String response = OkhttpUtil.httpPost(url,hoApiDTO.toString());
		System.out.println(response);
	}
	
	private static String getResponse(String requsetUrl, String content) {
        try {
            URL url = new URL(requsetUrl);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setDoOutput(true); // 使用 URL 连接进行输出
            httpConn.setDoInput(true); // 使用 URL 连接进行输入
            httpConn.setUseCaches(false); // 忽略缓存
            httpConn.setRequestMethod("POST"); // 设置URL请求方法
            OutputStream outputStream = httpConn.getOutputStream();
            
            outputStream.write(content.getBytes("UTF-8"));
            outputStream.close();
            BufferedReader responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
            String readLine;
            StringBuffer responseSb = new StringBuffer();
            while ((readLine = responseReader.readLine()) != null) {
                responseSb.append(readLine);
            }
            return responseSb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }

    }
	
}
