package 敏感词库;

import java.util.List;

public class Data {
	
	private List<Errors> error;
	private String new_str;
	private String input_str;
	
	public List<Errors> getError() {
		return error;
	}
	public void setError(List<Errors> error) {
		this.error = error;
	}
	public String getNew_str() {
		return new_str;
	}
	public void setNew_str(String new_str) {
		this.new_str = new_str;
	}
	public String getInput_str() {
		return input_str;
	}
	public void setInput_str(String input_str) {
		this.input_str = input_str;
	}
	
	
}
