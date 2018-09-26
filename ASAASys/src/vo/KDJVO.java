package vo;

/**
 * ���ָ��随机指标
 * @author lenovo
 *
 */
public class KDJVO {
private String  K;
private String  D;
private String  J;
private String  date;
	public KDJVO(String K,String D,String J,String  date){
		this.K = K;
		this.D = D;
		this.J = J;
		this.date=date;
	}
	
	public void setData(String K,String D,String J,String  date){
		this.K = K;
		this.D = D;
		this.J = J;
		this.date=date;
	}
	
	public String getK(){
		return K;
	}
	public String getD(){
		return D;
	}
	public String getJ(){
		return J;
	}
	public String getDate(){
		return date;
	}

	
}
