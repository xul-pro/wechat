package com.hoyatod.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.hoyatod.config.WechatSDK;


/**
 * 微信扫码支付接口
 * 
 * @author AzZ·xul
 *
 */
public class WecahtScanCodePayUtil {
	
	private static Logger log = Logger.getLogger(WecahtScanCodePayUtil.class);
	
	/**
	 * 1.mch_id 商户号 2.nonce_str 随机字符串 3.sign_type 签名方式  4.body 测试收费  5.attach 商品描述
	 * 6.out_trade_no 订单号 7.fee_type 币种  8.total_fee 总费用 9.终端ip 10.notify_url 回调地址
	 * 11.trade_type JSAPI 12.openid 微信唯一标识
	 * @param out_trade_no
	 * @param total_fee
	 * @param clienIp
	 * @param notify_url
	 * @param openid
	 * @return String 
	 */
	public static String unifiedOrder(String out_trade_no, String total_fee, String clienIp, String notify_url,String openid) {
		SortedMap<Object,Object> map = new TreeMap<Object,Object>(); 
		map.put("appid", WechatSDK.APPID);
		map.put("mch_id", WechatSDK.MCH_ID); 
		map.put("sign_type", "MD5");
		map.put("body", "测试收费");
		map.put("attach", "商品描述");
		map.put("out_trade_no", out_trade_no);
		map.put("fee_type", "CNY"); 
		map.put("total_fee", total_fee);           // 总金额 单位为分
		map.put("spbill_create_ip", clienIp);      // 终端ip
		map.put("notify_url", notify_url);         // 回调地址
		map.put("trade_type", "JSAPI");            // 交易类型  
		map.put("openid", openid);                 // 用户标识
		String sign = createSign(map);             // 签名
		map.put("sign", sign);
		String mapToXml = MapToXml(map);
		String result = httpsRequest(WechatSDK.ORDER_URL, "POST", mapToXml);
 		return result;
	}
	
	private static String httpsRequest(String orderUrl, String requestMethod, String outputStr) {
		try {
			/**
			 *  创建SSLContext对象，并使用我们指定的信任管理器初始化
			 */
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			URL url = new URL(orderUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			
			conn.setSSLSocketFactory(ssf);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod(requestMethod);                  // 设置请求方式（GET/POST）
			
			conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			if (null != outputStr) {                               // 当outputStr不为null时向输出流写数据
				OutputStream outputStream = conn.getOutputStream();
				outputStream.write(outputStr.getBytes("UTF-8"));   // 注意编码格式
				outputStream.close();
			}
			
			InputStream inputStream = conn.getInputStream();       // 从输入流读取返回内容
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();
			
			return buffer.toString();
		} catch (Exception e) {
			log.error("系统异常", e);
			return null;
		}
		
	}

	/**
	 * map转成xml
	 */
	public static String MapToXml(SortedMap<Object,Object> map) {
		String xml = "<xml>";
		Iterator<Entry<Object, Object>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<Object, Object> entry = iter.next();
			String key = (String) entry.getKey();
			String val = (String) entry.getValue();
			xml += "<" + key + ">" + val + "</" + key + ">";
		}
		xml += "</xml>";
		return xml;
	}
	
	/**
	 * xml字符串转成map
	 */
	@SuppressWarnings("unchecked")
	public static SortedMap<Object,Object> doXMLParse(String xml) {
		SortedMap<Object,Object> map = new TreeMap<Object,Object>(); 
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xml);               // 将字符串转为XML
			Element rootElt = doc.getRootElement();            // 获取根节点
			List<Element> list = rootElt.elements();           // 获取根节点下所有节点
			for (Element element : list) {                     // 遍历节点
				map.put(element.getName(), element.getText()); // 节点的name为map的key，text为map的value
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * @Description：返回给微信的参数
	 * @param return_code
	 *            返回编码
	 * @param return_msg
	 *            返回信息
	 */
	public static String setXML(String return_code, String return_msg) {
		return "<xml><return_code><![CDATA[" + return_code + "]]></return_code><return_msg><![CDATA[" + return_msg+ "]]></return_msg></xml>";
	}
	/**
	 * 签名算法
	 */
	@SuppressWarnings("rawtypes")
	public static String createSign(SortedMap<Object,Object> map) {
		StringBuffer sb = new StringBuffer();
		Set es = map.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			Object v = entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + WechatSDK.API_KEY);
		String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
		return sign;
	}
	
	/**
	 * 商户订单号
	 */
	public static String getOut_trade_no() {
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return df.format(new Date()) + getRandomNum(7);
	}
	private static String getRandomNum(int count) {
		char start = '0';
		char end = '9';
		Random rnd = new Random();
		char[] result = new char[count];
		int len = end - start + 1;
		while (count-- > 0) {
			result[count] = (char) (rnd.nextInt(len) + start);
		}
		return new String(result);
	}
	
	/**
	 * 获取微信支付时间戳
	 */
	public static String create_timestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}
	
	public static String getTransactionNumber(){
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		return "4001042001"+df.format(new Date()) + getRandomNum(10);
	}
	/**
	 * 获取预支付ID时 获取随机码
	 */
	public static String create_nonce_str() {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String res = "";
		for (int i = 0; i < 16; i++) {
			Random rd = new Random();
			res += chars.charAt(rd.nextInt(chars.length() - 1));
		}
		return res;
	}
	
	/**
	 * 获得随机字符串
	 */
	public static String getNonceStr() {
		Random random = new Random();
		return MD5Util.MD5Encode(String.valueOf(random.nextInt(10000)), "UTF-8");
	}
}
