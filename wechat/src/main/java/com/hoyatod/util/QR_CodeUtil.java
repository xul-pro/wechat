package com.hoyatod.util;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.hoyatod.config.QR_Code;
import com.hoyatod.dto.ActionInfoDTO;
import com.hoyatod.dto.QR_CodeDTO;
import com.hoyatod.dto.RespDataDTO;
import com.hoyatod.dto.SceneDTO;

public class QR_CodeUtil {
	
	/*生成永久二维码*/
    public static String getPerpetualQR(QR_CodeDTO qr_CodeDTO){
         //发送给微信服务器的数据
//       String jsonStr = "{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\"：{\"scene\": {\"scene_id\": "+account+"}}}";
         String response = sendPost(JsonUtils.toJson(qr_CodeDTO), QR_Code.create_ticket_path.replace("ACCESS_TOKEN", WechatTools.getAccess_token())); //post请求得到返回数据（这里是封装过的，就是普通的java post请求）
         return response.toString();
    }
    
    public static void main(String[] args) {
    	QR_CodeDTO qr_CodeDTO = new QR_CodeDTO();
    	qr_CodeDTO.setAction_name("QR_LIMIT_SCENE");
    	  
    	ActionInfoDTO actionInfoDTO = new ActionInfoDTO();
    	SceneDTO sceneDTO = new SceneDTO();
    	sceneDTO.setScene_id("1");
    	actionInfoDTO.setScene(sceneDTO);
    	
    	qr_CodeDTO.setAction_info(actionInfoDTO);
    	//{"ticket":"gQGi8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyY1RJTlY2c2dkQzIxMDAwMHcwM0oAAgQe9nVcAwQAAAAA","url":"http:\/\/weixin.qq.com\/q\/02cTINV6sgdC210000w03J"}
    	System.out.println(JsonUtils.toJson(qr_CodeDTO));
    	String perpetualQR = getPerpetualQR(qr_CodeDTO);
    	RespDataDTO fromJson = JsonUtils.fromJson(perpetualQR, RespDataDTO.class);
    	
    	//https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET
    	Boolean downloadFile = downloadFile("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+fromJson.getTicket(), "F:\\qr\\img.jpg");
    	System.out.println(downloadFile);
	}
    
    public static String sendPost(String param, String url) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            
            
            conn.setDoOutput(true);// 发送POST请求必须设置如下两行
            conn.setDoInput(true);
            
            // 获取URLConnection对象对应的输出流
            // out = new PrintWriter(conn.getOutputStream());
            out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "utf-8"));
            
            out.print(param);// 发送请求参数
            out.flush();// flush输出流的缓冲
            
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                 result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                 if (out != null) {
                      out.close();
                 }
                 if (in != null) {
                      in.close();
                 }
            } catch (IOException ex) {
                 ex.printStackTrace();
            }
        }
        return result;
   }
    
    //根据url下载文件，参数（文件网址，存文件的本地地址）     
    public static Boolean downloadFile(String urlString, String filePath){
             // 构造URL
             URL url;
              try {
                  url = new URL(urlString);
                   // 打开连接
                  URLConnection con;
                  try {
                       con = url.openConnection();
                       // 输入流
                      InputStream is = con.getInputStream();
                      // 1K的数据缓冲
                      byte[] bs = new byte[1024];
                      // 读取到的数据长度
                      int len;
                      // 输出的文件流
                      OutputStream os = new FileOutputStream(filePath);
                      // 开始读取
                      while ((len = is.read(bs)) != -1) {
                       os.write(bs, 0, len);
                      }
                      // 完毕，关闭所有链接
                      os.close();
                      is.close();
                      return true;
                  } catch (IOException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                       return false;
                  }
                 
              } catch (MalformedURLException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
                  return false;
              }
           
         }  
}
