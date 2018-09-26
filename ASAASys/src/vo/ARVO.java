package vo;
/**
 * 人气意愿
 * @author lenovo
 *
 */
public class ARVO {
	private String  data;
	private String  date;
		public ARVO(String data,String  date){
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
