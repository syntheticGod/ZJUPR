package vo;
//动向指标

public class DMIVO {
	private String zhengDM;
	private String fuDM;

	private String trueRange;//真实波幅
	private String DX;
	private String ADX;
	private String ADXR;
	
	private String zhengDI;
	private String fuDI;
	
	private String date;
	
	public DMIVO(String zhengDM,String fuDM,String trueRange,String zhengDI,String fuDI,String DX,String ADX,String ADXR,String date){
		this.zhengDM=zhengDM;
		this.fuDM=fuDM;
		this.trueRange=trueRange;
		this.DX=DX;
		this.ADX=ADX;
		this.zhengDI=zhengDI;
		this.ADXR=ADXR;
		this.fuDI=fuDI;
		this.date=date;
		
	}
	
	public void setzhengDM(String zhengDM){
		this.zhengDM=zhengDM;
	}
	public void setfuDM(String fuDM){
		this.fuDM=fuDM;
	}
	
	public void setTrueRange(String trueRange){
		this.trueRange=trueRange;
	}

	public void setDX(String DX){
		this.DX=DX;
	}
	public void setADX(String ADX){
		this.ADX=ADX;
	}
	public void setADXR(String ADXR){
		this.ADXR=ADXR;
	}
	public void setZhengDI(String zhengDI){
		this.zhengDI=zhengDI;
	}
	public void setFuDI(String fuDI){
		this.fuDI=fuDI;
	}

	public void setDate(String date){
		this.date=date;
	}
	

	public String getZhengDM(){
		return zhengDM;
	}
	public String getFuDM(){
		return fuDM;
	}
	public String getZhengDI(){
		return  zhengDI;
	}
	public String getFuDI(){
		return  fuDI;
	}
	
	public String getTrueRange(){
		return trueRange;
	}
	
	public String getDX(){
		return DX;
	}
	public String getADX(){
		return  ADX;
	}
	public String getADXR(){
		return  ADXR;
	}
	
	public String getDate(){
		return date;
	}
	
}
