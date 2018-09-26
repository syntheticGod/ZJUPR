package vo;
/**
 * 威廉指标
 * @author lenovo
 *
 */
public class WRVO {
	private String  data;
	private String  date;
		public WRVO(String data,String  date){
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
