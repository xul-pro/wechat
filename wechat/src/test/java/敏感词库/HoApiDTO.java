package 敏感词库;

import java.io.Serializable;

public class HoApiDTO {
	
	
	private String str;	//是	要检查的句子		使用假、币 
	private String token;//否	你的token,携带后会根据你的一些自定义设置进行处理		test_id
	private Integer lv;//否	权重等级【1-5】，5最严格，1最放松
	
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getLv() {
		return lv;
	}
	public void setLv(Integer lv) {
		this.lv = lv;
	}
	@Override
	public String toString() {
		return "HoApiDTO [str=" + str + ", token=" + token + ", lv=" + lv + "]";
	}
	
	
}
