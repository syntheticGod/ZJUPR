package vo;

public class GrailsSearchVO {
	private String beginDate;      
	private String endDate;
	private  double kaipanMin;
	private  double kaipanMax;
	private  double shoupanMin;
	private  double shoupanMax;
	private  double maxMax;
	private  double maxMin;
	private  double minMax;
	private  double minMin;
	
	public GrailsSearchVO( String beginDate,     
	 String endDate,
	 double kaipanMin,
	 double kaipanMax,
	 double shoupanMin,
	 double shoupanMax,
	 double maxMin,
	 double maxMax,
	 double minMin,
	 double minMax ){
		this.beginDate=beginDate;
		this.endDate=endDate;
		this.kaipanMin=kaipanMin;
		this.kaipanMax=kaipanMax;
		this.shoupanMin=shoupanMin;
		this.shoupanMax=shoupanMax;
		 this.maxMax=maxMax;
		 this.maxMin=maxMin;
		 this.minMax=minMax;
		 this.minMin=minMin;
		
		
		
	}
	
	public String getBeginDate(){
		return beginDate;
	}
	public String getEndDate(){
		return endDate;
	}
	public  double getKaipanMin(){
		return kaipanMin;
	}
	public  double getKaipanMax(){
		return kaipanMax;
	}
	public  double getShoupanMin(){
		return shoupanMin;
	}
	public  double getShoupanMax(){
		return shoupanMax;
	}
	public  double getMaxMax(){
		return maxMax;
	}
	public  double getMaxMin(){
		return maxMin;
	}
	public  double getMinMax(){
		return minMax;
	}
	public  double getMinMin(){
		return minMin;
	}


	
}
