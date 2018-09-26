package vo;
//心理线
public class PSYVO {
private String  data;
private String  date;
	
	public PSYVO(String data,String date){
		this.data = data;
		this.date = date;
		
	}
	
	public void setData(String data){
		this .data = data;
	}
	public void setDate(String date){
		this .date = date;
	}
	
	public String getData(){
		return data;
	}
	
	public String getDate(){
		return date;
	}

}
