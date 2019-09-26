package 敏感词库;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 【匹配度可以，速度较慢】
 * @author xuliang
 *
 */
public class KeyWordFilterUtil {
	
	private static Pattern pattern = null;
	private static int keywordsCount = 0;

	// 从words.properties初始化正则表达式字符串
	private static void initPattern() {
		StringBuffer patternBuffer = new StringBuffer();
		try {
			//words.properties
			InputStream in = KeyWordFilterUtil.class.getClassLoader().getResourceAsStream("keywords.properties");
			Properties property = new Properties();
			property.load(in);
			Enumeration<?> enu = property.propertyNames();
			patternBuffer.append("(");
			while (enu.hasMoreElements()) {
				String scontent = (String) enu.nextElement();
				patternBuffer.append(scontent + "|");
				keywordsCount ++;
			}
			patternBuffer.deleteCharAt(patternBuffer.length() - 1);
			patternBuffer.append(")");
			// 装换编码
			pattern = Pattern.compile(patternBuffer.toString());
		} catch (Exception e) {
		}
	}

	private static String doFilter(String str) {
		Matcher m = pattern.matcher(str);
		while (m.find()) {
			System.out.println("The result is here :" + m.group());
		}
		str = m.replaceAll("*");  //选择替换方式，这里以* 号代替
		return str;
	}
	
	public static String filterKeyWord(String word) {
		initPattern();
		if(word == null || word.trim().equals("")) {
			return null;
		}
		return doFilter(word);
	}
	
	public static void main(String[] args) {
		long startNumer = System.currentTimeMillis();
		System.out.println(filterKeyWord(""));
		long endNumer = System.currentTimeMillis();
		System.out.println("总共耗时:"+(endNumer-startNumer) + "ms");
	}
}


