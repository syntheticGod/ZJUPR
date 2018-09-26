package vo;

public class CategoryDetailVO {
	private String name;
	private int num;
	private double percent;
	
	public CategoryDetailVO(String name,int num,double percent){
		this.name=name;
		this.num=num;
		this.percent=percent;
		
	}
	
	public void setname(String name){
		this.name=name;
		
	}
	public void setnum(int num){
		this.num=num;
	}
	
	public void setpercent(int percent){
		this.percent=percent;
	}
	public String getname(){
		return name;
	}
	public int getnum(){
		return num;
	}
	public double getpercent(){
		return percent;
	}
}
