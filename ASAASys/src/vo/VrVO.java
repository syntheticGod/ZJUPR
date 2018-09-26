package vo;

public class VrVO {
	//Artnum：当日的均幅指标 day：当日日期 Vr:每日容量比率 
			private String name;
			private String Vr;
			private String day;
			public VrVO(){
				
			}
			public VrVO(String name,String Vr,String day){
				this.name = name;
				this.Vr = Vr;
				this.day=day;
			}
			
			//Set方法
			public void setName(String name){
				this.name = name;
			}
			public void setVr(String Vr){
				this.Vr = Vr;
			}
			public void setday(String day){
				this.day = day;
			}
			
			//Get方法
			public String getName(){
				return name;
			}
			public String getVr(){
				return Vr;
			}
			public String getday(){
				return day;
			}


}
