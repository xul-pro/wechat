package com.hoyatod.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class VoiceDownload {
	 /** 
     *  
     * 根据文件id下载文件 
     * @param mediaId 
     *            媒体id 
     * @throws Exception 
     */  
  
    public static InputStream getInputStream(String mediaId) {
    	String access_token = WechatTools.getAccess_token();
        InputStream is = null;  
        String url = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token="+ access_token + "&media_id=" + mediaId;  
        try {  
            URL urlGet = new URL(url);  
            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();  
            http.setRequestMethod("GET");  // 必须是get方式请求  
            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");  
            http.setDoOutput(true);  
            http.setDoInput(true);  
            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒  
            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒  
            http.connect();
            
            is = http.getInputStream();    //获取文件转化为byte流  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return is;  
  
    }  
    
    /** 
     *  
     * 获取下载图片信息（jpg） 
     * @param mediaId  文件的id 
     * @throws Exception 
     */  
    public static void saveImageToDisk(String mediaId, String picName, String picPath) throws Exception {  
        InputStream inputStream = getInputStream(mediaId);  
        byte[] data = new byte[10240];  
        int len = 0;  
        FileOutputStream fileOutputStream = null;  
        try {  
            fileOutputStream = new FileOutputStream(picPath+picName+".amr");  
            while ((len = inputStream.read(data)) != -1) {  
                fileOutputStream.write(data, 0, len);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (inputStream != null) {  
                try {  
                    inputStream.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (fileOutputStream != null) {  
                try {  
                    fileOutputStream.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }  
    
    public static void ioToFile(String mediaId,String path) throws Exception {
    	InputStream is = getInputStream(mediaId);
    	
    	File file = new File(path+"/"+"a.mp3");
    	FileOutputStream fos = new FileOutputStream(file);
    	byte[] b = new byte[1024];
    	while((is.read(b)) != -1){
    		fos.write(b);
    	}
    	is.close();
    	fos.close();
    } 
}
