package vo;

public class RemenVO {
	private String category;
	private double avgvolume;
	private double avgvolumep;
	private double avgturnover;
	private double avgturnoverp;
	
	public RemenVO(String category,double avgvolume,double avgvolumep,double avgturnover,double avgturnoverp){
		this.category=category;
		this.avgvolume=avgvolume;
		this.avgvolumep=avgvolumep;
		this.avgturnover=avgturnover;
		this.avgturnoverp=avgturnoverp;
	}
	
	public void setcategory(String category){
		this.category=category;
	}
	
	public void setavgvolume(double avgvolume){
		this.avgvolume=avgvolume;
	}
	
	public void setavgvolumep(double avgvolumep){
		this.avgvolumep=avgvolumep;
	}
	
	public void setavgturnover(double avgturnover){
		this.avgturnover=avgturnover;
	}
	
	public void setavgturnoverp(double avgturnoverp){
		this.avgturnoverp=avgturnoverp;
	}
	
	public String getcategory(){
		return category;
	}
	
	public double getavgvolume(){
		return avgvolume;
	}
	
	public double getavgvolumep(){
		return avgvolumep;
	}
	
	public double getavgturnover(){
		return avgturnover;
	}
	
	public double getavgturnoverp(){
		return avgturnoverp;
	}

}
