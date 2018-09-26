package vo;

public class CCIVO {
	//CCI：当日的顺势指标 day：当日日期
		private String name;
		private String CCI;
		private String day;
		public CCIVO(){
			
		}
		public CCIVO(String name,String CCI,String day){
			this.name = name;
			this.CCI = CCI;
			this.day=day;
		}
		
		//Set方法
		public void setName(String name){
			this.name = name;
		}
		public void setCCI(String CCI){
			this.CCI = CCI;
		}
		public void setday(String day){
			this.day = day;
		}
		
		//Get方法
		public String getName(){
			return name;
		}
		public String getCCI(){
			return CCI;
		}
		public String getday(){
			return day;
		}

}
