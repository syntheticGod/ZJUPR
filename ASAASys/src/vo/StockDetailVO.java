package vo;

public class StockDetailVO {
	private String name;
	private String date;
	private String open;
	private String close;
	private String high;
	private String low;
	private String volume;
	private String turnover;
	private String pb;
	
	public StockDetailVO(String name,String date,String open,String close,String high,String low,String volume,String turnover,String pb){
		this.name=name;
		this.date=date;
		this.open=open;
		this.close=close;
		this.high=high;
		this.low=low;
		this.volume=volume;
		this.turnover=turnover;
		this.pb=pb;
		
	}
	
	public String getName(){
		return name;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getOpen(){
		return open;
	}

	public String getClose(){
		return close;
	}
	
	public String getHigh(){
		return high;
	}
	
	public String getLow(){
		return low;
	}
	
	public String getVolume(){
		return volume;
	}
	
	public String getTurnover(){
		return turnover;
	}
	
	public String getPb(){
		return pb;
	}


}
