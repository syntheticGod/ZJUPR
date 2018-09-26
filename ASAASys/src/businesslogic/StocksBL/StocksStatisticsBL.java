package businesslogic.StocksBL;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;

import po.StockDetailPO;
import presentation.ita1.TimeGetter;
import data.DataController;
import dataservice.DataControllerService;
import vo.BIASVO;
import vo.DMIVO;
import vo.PSYVO;
import bussinesslogicservice.StocksBLService.StocksStatisticsBLService;

public class StocksStatisticsBL  implements StocksStatisticsBLService{

	@Override
	public ArrayList<BIASVO> ComputeBIAS(String str,String endtime,int number,int canshu) throws Exception, JSONException, ParseException {
		// TODO Auto-generated method stub
		ArrayList<BIASVO>list =new ArrayList<BIASVO>();
		ArrayList<StockDetailPO>  stocksPO = new ArrayList<StockDetailPO> ();
		double AverageOfN = 0;
		
		DataControllerService dc =new DataController();
		int n = 0;
//		for(int i = 0;i<dc.getNotimeStock(str).size();i++){
		//保证返回Number个数据
			do{
			  stocksPO = dc.getStock(str, TimeGetter.getDayBefore(endtime, n+number+canshu), endtime);
			  n++;
			  
			}while(stocksPO.size()!=number+canshu-1);
//		}
			for(int k=0;k<number;k++){
				AverageOfN=0;
				double temp =0;
			for(int i =k+canshu-1;i>=k;i--){
				temp += Double.parseDouble(stocksPO.get(i).getclose());
			}
		       AverageOfN = temp/canshu;
			double result = (((Double.parseDouble(stocksPO.get(k).getclose()))-AverageOfN)/(AverageOfN))*100;
			
			DecimalFormat df = new DecimalFormat("0.00");
			 
			String re = df.format(result);
			
			BIASVO temp1 = new BIASVO(re,stocksPO.get(k+canshu-1).getdate());
			
			list.add(temp1);
		}	
		return list;
	}

	@Override
	public ArrayList<PSYVO> ComputePSY(String str,String endtime,int number) throws Exception, Exception, Exception {
		// TODO Auto-generated method stub
		ArrayList<PSYVO>list =new ArrayList<PSYVO>();
		ArrayList<StockDetailPO>  stocksPO = new ArrayList<StockDetailPO> ();
		int n =0;
		
		DataControllerService dc =new DataController();
		
		do{
			  stocksPO = dc.getStock(str, TimeGetter.getDayBefore(endtime, n+number+11), endtime);
			  n++;
			  
			}while(stocksPO.size()!=number+11);
		
		for(int k=0;k<number;k++){
			double increaseDays = 0;
			
			for(int i =k+11;i>=k;i--){
				if(Double.parseDouble(stocksPO.get(i).getclose()) > Double.parseDouble(stocksPO.get(i).getopen())){
					increaseDays++;			
				}
			}
			double result = (increaseDays/12)*100;
			
			DecimalFormat df = new DecimalFormat("0.00");
			 
			String re = df.format(result);
			
			PSYVO temp =new PSYVO(re,stocksPO.get(k+11).getdate());
			
			list.add(temp);
		}
						
		
		return list;
	}

	@Override
	public ArrayList<DMIVO> ComputeDMI(String str,String endtime,int number) throws Exception, JSONException, ParseException {
		// TODO Auto-generated method stub
		ArrayList<DMIVO>list =new ArrayList<DMIVO>();
		ArrayList<StockDetailPO>  stocksPO = new ArrayList<StockDetailPO> ();
		int n =0;
		
		DataControllerService dc = new DataController();
		
		do{
			  stocksPO = dc.getStock(str, TimeGetter.getDayBefore(endtime, n+number+24), endtime);
			  n++;	  
			}while(stocksPO.size()!=number+24);
		
		String zhengDM[]=new String[number+23];
		String fuDM[]=new String[number+23];
		String trueRange[]=new String[number+23];
		String zhengDI[]=new String[number+12];
		String fuDI[]=new String[number+12];
		String DX[]=new String[number+12];
		String ADX[]=new String[number+1];
		String ADXR[]=new String[number];
		
		for(int i = 1;i<=number+23;i++){
			
			
				if( Double.parseDouble(stocksPO.get(i).gethigh())>Double.parseDouble(stocksPO.get(i-1).gethigh()) ){
					double result =Double.parseDouble(stocksPO.get(i).gethigh()) - Double.parseDouble(stocksPO.get(i-1).gethigh());	
					DecimalFormat df = new DecimalFormat("0.00");
					 
					String re = df.format(result);
					
					zhengDM[i-1]=re;	
					}else{
						zhengDM[i-1]="0";
					}
				
			   if( Double.parseDouble(stocksPO.get(i).getlow())<Double.parseDouble(stocksPO.get(i-1).getlow()) ){
						
					double result =Double.parseDouble(stocksPO.get(i-1).getlow()) - Double.parseDouble(stocksPO.get(i).getlow());	
					DecimalFormat df = new DecimalFormat("0.00");
					 
					String re = df.format(result);
				    fuDM[i-1]=re;
				}else{
					fuDM[i-1]="0";
				}
				
				 if(Double.parseDouble(zhengDM[i-1])>Double.parseDouble(fuDM[i-1])){
					 fuDM[i-1]="0";
				 }else if(Double.parseDouble(zhengDM[i-1])<Double.parseDouble(fuDM[i-1])){
					 zhengDM[i-1]="0";
				 }
		}
				 
		for(int i = 1;i<=number+23;i++){
				double a =Double.parseDouble(stocksPO.get(i).gethigh()) - Double.parseDouble(stocksPO.get(i).getlow());
                double b =Double.parseDouble(stocksPO.get(i).gethigh()) - Double.parseDouble(stocksPO.get(i-1).getclose());			
				double c =Double.parseDouble(stocksPO.get(i).getlow()) - Double.parseDouble(stocksPO.get(i-1).getclose());
				
				if( (Math.abs(a)>=Math.abs(b)) && (Math.abs(a)>=Math.abs(c)) ){
					DecimalFormat df = new DecimalFormat("0.00");
					 
					 trueRange[i-1] = df.format(Math.abs(a));
					
				}
				
				if( (Math.abs(b)>=Math.abs(a)) && (Math.abs(b)>=Math.abs(c)) ){
					DecimalFormat df = new DecimalFormat("0.00");
					 
					 trueRange[i-1] = df.format(Math.abs(b));
				}
				
				if( (Math.abs(c)>=Math.abs(a)) && (Math.abs(c)>=Math.abs(b)) ){
					DecimalFormat df = new DecimalFormat("0.00");
					 
					 trueRange[i-1] = df.format(Math.abs(c));
				}
		}
		//System.out.print(zhengDM[2]);
			
			for(int i=0;i<number+12;i++){
				double zhengDM12=0;
				double fuDM12=0;
				double TR12=0;
				
				for(int j=i+11;j>=i;j--){
					zhengDM12+=Double.parseDouble(zhengDM[j])/12.0;
					fuDM12+=Double.parseDouble(fuDM[j])/12.0;
					TR12+=Double.parseDouble(trueRange[j])/12.0;
				}
				DecimalFormat df = new DecimalFormat("0.00");
				zhengDI[i]=df.format((zhengDM12/TR12)*100);
				fuDI[i]=df.format((fuDM12/TR12)*100);
				
			}
//			System.out.print(zhengDI[1]);
			
			for(int i=0;i<number+12;i++){
				DecimalFormat df = new DecimalFormat("0.00");
				DX[i]=df.format((Math.abs(Double.parseDouble(zhengDI[i])-Double.parseDouble(fuDI[i]))/(Double.parseDouble(zhengDI[i])+Double.parseDouble(fuDI[i])))*100);
			}
			
			for(int i=0;i<number+1;i++){
				double AverageOfDX=0;
				for(int j=i+11;j>=i;j--){
					AverageOfDX+=Double.parseDouble(DX[j])/12.0;
				}
				DecimalFormat df = new DecimalFormat("0.00");
				ADX[i]=df.format(AverageOfDX);
			}
			
			for(int i=0;i<number;i++){
				DecimalFormat df = new DecimalFormat("0.00");
				ADXR[i]=df.format((Double.parseDouble(ADX[i])+Double.parseDouble(ADX[i+1]))/2.0);
			}
			
			for(int i=0;i<number;i++){
				DMIVO temp =new DMIVO(zhengDM[i+23], fuDM[i+23], trueRange[i+23], zhengDI[i+12], fuDI[i+12], DX[i+12], ADX[i+1], ADXR[i], stocksPO.get(i+24).getdate());
				
				list.add(temp);	
			}	
		return list;
	}

	
	public static void main(String[] args) throws Exception{
		StocksStatisticsBL test=new StocksStatisticsBL();
		System.out.print(test.  ComputeDMI("600100","2016-03-30",10).get(0).getDate());
	}
}
