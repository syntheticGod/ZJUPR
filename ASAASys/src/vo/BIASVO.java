package vo;
//乖离率

public class BIASVO {
	private String  data;
	private String date;
	
	public BIASVO(String data,String date){
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
