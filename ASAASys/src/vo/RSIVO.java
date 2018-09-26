package vo;
/**
 * ǿ��ָ��强弱指标
 * @author lenovo
 *
 */
public class RSIVO {
private String  data;
private String  date;
	public RSIVO(String data,String  date){
		this.data = data;
		this.date = date;
	}
	
	public void setData(String data,String  date){
		this .data = data;
		this.date = date;
	}
	public String getData(){
		return data;
	}
	public String getDate(){
		return date;
	}
	
}
