package com.hoyatod.util;

import java.io.File;
import java.util.Iterator;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class Tools {
	
	/**
     * 判断字符串是否为空
     **/
    public static boolean isNullOrEmpty(String str) {
        return (null == str || str.trim().equals(""));
    }
    /**
     * 生成指定长度的随机数
     * 
     * @param length
     * @return String
     */
	public static String getRandomString(int length) {
		StringBuffer buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		int range = buffer.length();
		for (int i = 0; i < length; i++) {
			sb.append(buffer.charAt(r.nextInt(range)));
		}
		return sb.toString();
	}
	
	public static String fileUpload(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
			if (multipartResolver.isMultipart(request)) {
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request; 
				Iterator<String> iter = multiRequest.getFileNames(); 
				while (iter.hasNext()) {
					MultipartFile file = multiRequest.getFile(iter.next());
					if (file != null) {
						if (!file.getOriginalFilename().trim().equals("")) {
							String fileName = "my"+".mp4";
							String loadpath = request.getSession().getServletContext().getRealPath("/");
							String root = new File(loadpath).getParentFile().getAbsolutePath()+"/voice/";
							String rootPath = root+"/";
							if(!new File(rootPath).exists()){
								new File(rootPath).mkdirs();
							}
							String path = rootPath + fileName;
							File localFile = new File(path);
							file.transferTo(localFile);
							return "success";
						}
					}
					return "fail";
				}
			}
			return "fail";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
}
