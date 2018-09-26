package po;


public class StockDetailPO {
	//open: ���̼�  high: ��߼�  low: ��ͼ� close: ���̼�  volume: �ɽ���    turnover: ������    pb: �о���
	private String date;
	private String high;
	private String open;
	private String close;
	private String low;
	private String volume;
	private String turnover;
	private String pb;
	
	//���캯��
	public StockDetailPO(){
		
	}
	public StockDetailPO(String date , String high , String open , String close , String low , String volume , String turnover , String pb){
		this.high = high;
		this.date = date;
		this.open = open;
		this.close = close;
		this.low = low;
		this.volume = volume;
		this.turnover = turnover;
		this.pb = pb;
	}
	
	
	//set ����
	public void sethigh(String high){
		this.high = high;
	}
	public void setdate(String date){
		this.date = date;
	}
	public void setopen(String open){
		this.open = open;
	}
	public void setclose(String close){
		this.close = close;
	}
	public void setlow(String low){
		this.low = low;
	}
	public void setvolume(String volume){
		this.volume = volume;
	}
	public void setturnover(String turnover){
		this.turnover = turnover;
	}
	public void setpb(String pb){
		this.pb = pb;
	}
	
	//get ����
	public String getdate(){
		return date;
	}
	public String gethigh(){
		return high;
	}
	public String getopen(){
		return open;
	}
	public String getclose(){
		return close;
	}
	public String getlow(){
		return low;
	}
	public String getvolume(){
		return volume;
	}
	public String getturnover(){
		return turnover;
	}
	public String getpb(){
		return pb;
	}

}
