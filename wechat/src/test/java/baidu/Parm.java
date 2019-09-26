package baidu;

public class Parm {
	
	private String site_id;//	uint	是	站点id
	private String method;	//string	是	通常对应要查询的报告
	private String start_date;	//string	是	查询起始时间,例：20160501
	private String end_date;	//string	是	查询结束时间,例：20160531
	private String start_date2;	//string	否	对比查询起始时间
	private String end_date2;	//string	否	对比查询结束时间
	private String metrics;	//string	是	自定义指标选择，多个指标用逗号分隔
	private String gran;	//string	否	时间粒度(只支持有该参数的报告): day/hour/week/month
	private String order;	//string	否	指标排序，示例：visitor_count,desc
	private String start_index;	//uint	否	获取数据偏移，用于分页；默认是0
	private String max_results;	//uint	否	单次获取数据条数，用于分页；默认是20; 0表示获取所有数据
	
	public String getSite_id() {
		return site_id;
	}
	public void setSite_id(String site_id) {
		this.site_id = site_id;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getStart_date2() {
		return start_date2;
	}
	public void setStart_date2(String start_date2) {
		this.start_date2 = start_date2;
	}
	public String getEnd_date2() {
		return end_date2;
	}
	public void setEnd_date2(String end_date2) {
		this.end_date2 = end_date2;
	}
	public String getMetrics() {
		return metrics;
	}
	public void setMetrics(String metrics) {
		this.metrics = metrics;
	}
	public String getGran() {
		return gran;
	}
	public void setGran(String gran) {
		this.gran = gran;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getStart_index() {
		return start_index;
	}
	public void setStart_index(String start_index) {
		this.start_index = start_index;
	}
	public String getMax_results() {
		return max_results;
	}
	public void setMax_results(String max_results) {
		this.max_results = max_results;
	}
	
	
}
