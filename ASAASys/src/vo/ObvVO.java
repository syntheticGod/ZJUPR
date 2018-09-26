package vo;

public class ObvVO {
	//Artnum：当日的均幅指标 day：当日日期 Obv:每日能量潮值 单位：（百股）
		private String name;
		private String Obv;
		private String day;
		public ObvVO(){
			
		}
		public ObvVO(String name,String Obv,String day){
			this.name = name;
			this.Obv = Obv;
			this.day=day;
		}
		
		//Set方法
		public void setName(String name){
			this.name = name;
		}
		public void setObv(String Obv){
			this.Obv = Obv;
		}
		public void setday(String day){
			this.day = day;
		}
		
		//Get方法
		public String getName(){
			return name;
		}
		public String getObv(){
			return Obv;
		}
		public String getday(){
			return day;
		}

}
