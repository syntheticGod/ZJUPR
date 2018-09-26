package po;

public class StockKindPO {
	//id: 股票ID kind:股票种类
	private String id;
	private String kind;
	public StockKindPO(){
		
	}
	public StockKindPO(String id,String kind){
		this.id = id;
		this.kind = kind;
	}
	
	public void setid(String id){
		this.id = id;
	}
	public void setkind(String kind){
		this.kind = kind;
	}
	
    public String getid(){
    	return id;
    }
    public String getkind(){
    	return kind;
    }
}
