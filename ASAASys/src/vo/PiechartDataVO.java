package vo;

public class PiechartDataVO {
   private String label;
   private double bili;
   private double data;
   public PiechartDataVO(String label,double bili){
	   this.label=label;
	   this.bili=bili;
	   data=0;
   }
   public void setdata(double data){
	   this.data=data;
	   
   }
	public String getlabel(){
		
		return label;
	}
	
public double getbili(){
		
		return bili;
	}
public double getdata(){
	
	return data;
}
}
