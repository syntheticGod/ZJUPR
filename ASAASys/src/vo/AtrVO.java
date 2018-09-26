package vo;

public class AtrVO {
	//Artnum：当日的均幅指标 day：当日日期
	private String name;
	private String Atrnum;
	private String day;
	public AtrVO(){
		
	}
	public AtrVO(String name,String Atrnum,String day){
		this.name = name;
		this.Atrnum = Atrnum;
		this.day=day;
	}
	
	//Set方法
	public void setName(String name){
		this.name = name;
	}
	public void setAtrnum(String Atrnum){
		this.Atrnum = Atrnum;
	}
	public void setday(String day){
		this.day = day;
	}
	
	//Get方法
	public String getName(){
		return name;
	}
	public String getAtrnum(){
		return Atrnum;
	}
	public String getday(){
		return day;
	}

}
