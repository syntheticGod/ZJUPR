package po;




public class BenchMarkDetailPO {
	//date:����   close:���̼�  open:���̼�  high:��߼�  low:��ͼ�
	private String date;
	private String open;
	private String high;
	private String close;
	private String low;
	
	//���췽��
	public BenchMarkDetailPO(){
		
	}
	public BenchMarkDetailPO(String date,String open,String close,String high,String low){
		this.date = date;
		this.open = open;
		this.close = close;
		this.high = high;
		this.low = low;
	}
	
	//set����
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
	public void sethigh(String high){
		this.high = high;
	}
	
	//get����
	public String getdate(){
		return date;
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
	public String gethigh(){
		return high;
	}
	

}
