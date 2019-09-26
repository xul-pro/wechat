package com.hoyatod.util.commom;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理类
 */
public class StringUtil {

    /**
     * 判断字符串是否为空
     * 
     * @param str
     *            需要判断的字符串
     * @return 为空返回true，不为空返回false
     **/
    public static boolean isNullOrEmpty(String str) {
        return (null == str || str.trim().equals(""));
    }
    
	 /**
     * 判断字符传长度是否正确
     * @param str 需要判断的字符串
     * @param length 需要判断字符串的长度
     * @return 为空返回0，长度不对返回-1，长度正确返回1
     **/
    public static int equalStringLength(String str, int length) {
        return StringUtil.isNullOrEmpty(str) ? 0 : str.length()==length ? 1 : -1;
    }

    /**
    * 过滤特殊字符串.<br>
    * @param str 字符串.
    * @return 返回值描述.
    * @throws Exception 异常描述
     */
    public static String StringFilter(String str) {
        // 只允许字母和数字       
        // String   regEx  =  "[^a-zA-Z0-9]";                     
        // 清除掉所有特殊字符  
    	if(isNullOrEmpty(str)) return str;
    	String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";  
    	Pattern   p   =   Pattern.compile(regEx);     
    	Matcher   m   =   p.matcher(str);     
    	return   m.replaceAll("").trim();     
	}

    /**判断字符串是否为数字*/
    public static boolean isNumeric(String str){
    	if(str == null || str.equals("")) return false;
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public static String getRandomString(int length) {
        StringBuffer buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        int range = buffer.length();
        for (int i = 0; i < length; i ++) {
            sb.append(buffer.charAt(r.nextInt(range)));
        }
        return sb.toString();
    }

    /**
     * 验证手机号
     * @param phoneNo
     * @return
     */
    public static boolean validPhoneNo(String phoneNo) {
		boolean flag = false;
		Pattern pattern = Pattern.compile("^[1][3,5,7,8]\\d{9}$");
		Matcher m = pattern.matcher(phoneNo);
		if (m.matches()) {
			return true;
		}
		return flag;
	}
    
    /**
     * 微信标签
     * @param typesb
     * @param type
     * @return
     */
    public static void spliceGoodsLabel(StringBuffer typesb, String type) {
    	switch(type) {
    	case "1" :
    		typesb.append("【微信】");
    		break;
    	case "2" :
    		typesb.append("【微博】");
    		break;
    	case "3" :
    		typesb.append("【网站/APP】");
    		break;
    	case "4" :
    		typesb.append("【报纸杂志】");
    		break;
    	case "5" :
    		typesb.append("【户外】");
    		break;
    	case "6" :
    		typesb.append("【文案策划】");
    		break;
    	case "7" :
    		typesb.append("【新闻稿】");
    		break;
    	case "8" :
    		typesb.append("【海报图片】");
    		break;
    	case "9" :
    		typesb.append("【H5制作】");
    		break;
    	case "10" :
    		typesb.append("【公关服务】");
    		break;
    	case "11" :
    		typesb.append("【品牌规划】");
    		break;
    	case "12" :
    		typesb.append("【广告代理】");
    		break;
    	case "13" :
    		typesb.append("【会务策划】");
    		break;
    	}
    }

    public static String nullToStr(Object obj){
    	if(obj == null){
    		return "";
    	}
    	return obj.toString();
    }

    /**
     * 判断字符是否含有中文
     * 
     * @param str
     * @return true:含有 false:不含
     */
    public static boolean isChinese(String str) {
    	if(StringUtil.isNullOrEmpty(str)) {
    		return false;
    	}
    	Pattern pattern = Pattern.compile("[\\u4E00-\\u9FBF]+");
    	return pattern.matcher(str.trim()).find();
    }
    /**
     * 生成十位长度数字字符
     * 
     * @return
     */
    public static String getTenLengthString() {
    	StringBuffer buffer = new StringBuffer("0123456789");
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        int range = buffer.length();
        for (int i = 0; i < 10; i ++) {
            sb.append(buffer.charAt(r.nextInt(range)));
        } 
        return sb.toString();
    }
    
    public static boolean isBlank(String ip) {
		if(ip==null||ip.length()==0){
			
			return true;
		}
		return false;
	}
    
    private final static String REGEX_ZIPCODE = "^(010|02\\d|0[3-9]\\d{2})\\d{6,8}$";
    
    /**
	 * 获取固定号码号码中的区号
	 *
	 * @param strNumber
	 * @return
	 */
	public static String getZipFromHomephone(String strNumber) {
		Pattern zipcode = Pattern.compile(REGEX_ZIPCODE);
		Matcher matcher = zipcode.matcher(strNumber);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}
	/**
	 * 	去空格 回车 换行 水平符号
	 *  @param str
	 *  @return String
	 */
	public static String replaceBlank(String str) {
		String dest = "";//     \\s*|\t|\r|\n 空格 水平  换行 回车
		if (str != null) {
			Pattern p = Pattern.compile("\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}
}
