package businesslogic.StocksBL;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;

import data.DataController;
import dataservice.DataControllerService;
import po.StockDetailPO;
import presentation.ita1.TimeGetter;
import vo.ARVO;
import vo.KDJVO;
import vo.RSIVO;
import vo.WRVO;

public class StocksStatisticsBL2 {
	/**
	 * 随机指标
	 * @param str
	 * @return
	 * @throws Exception
	 * @throws JSONException
	 * @throws ParseException
	 */
		public ArrayList<KDJVO> ComputeKDJ(String str,int day,int number, String endtime) throws Exception, JSONException, ParseException {
			ArrayList<KDJVO>list =new ArrayList<KDJVO>();
			double RSV = 0;
			double K=0;
			double D=0;
			double J=0;
			DataControllerService dc =new DataController();
			ArrayList<StockDetailPO> stock = new ArrayList<StockDetailPO>();
			int n = 0;
			do{
			    stock= dc.getStock(str,TimeGetter.getDayBefore(endtime, n+day+number-1),endtime);
			    n++;
		    }while(stock.size()!=day+number-1);
			for(int i=number-1;i<stock.size();i++){
			    double high=Double.valueOf(stock.get(i).gethigh());
			    double low=Double.valueOf(stock.get(i).gethigh());
			
			    for(int j=i-number+1;j<i+1;j++){
				    double hig=Double.valueOf(stock.get(j).gethigh());
				    double lo=Double.valueOf(stock.get(j).getlow());
				    if(hig>=high){
					    high=hig;
				    }
				    if(lo<=low){
					    low=lo;
				    }
			    }
			    
			    	double close = Double.parseDouble(stock.get(i).getclose());
			    	RSV=((close-low)/(high-low))*100;
					if(i==0){
						K=(2.0/3)*50+(1.0/3)*RSV;
						D=(2.0/3)*50+(1.0/3)*K;
						J=3*D-2*K;
					}else{
						K=(2.0/3)*K+(1.0/3)*RSV;
						D=(2.0/3)*D+(1.0/3)*K;
						J=3*D-2*K;
			    }
					
					DecimalFormat df = new DecimalFormat("0.000");
					KDJVO temp = new KDJVO(df.format(K),df.format(D),df.format(J),stock.get(i).getdate());
					list.add(temp);
			}
			return list;
			
		}
		/**
		 * 强弱指标
		 */
		public ArrayList<RSIVO> ComputeRSI(String str,int day,int number,String endtime) throws Exception, JSONException, ParseException {
			ArrayList<RSIVO>list =new ArrayList<RSIVO>();
			DataControllerService dc =new DataController();
			int n = 0;
			ArrayList<StockDetailPO> stock = new ArrayList<StockDetailPO>();
			do{
			    stock= dc.getStock(str,TimeGetter.getDayBefore(endtime, n+day+number-1),endtime);
			    n++;
		    }while(stock.size()!=day+number-1);
			for(int i=number-1;i<stock.size();i++){
				
				double A = 0;
				double B = 0;
				double RSI = 0;
				double RS = 0;
				
				for(int j=i-number+1;j<i;j++){
					double C=Double.parseDouble(stock.get(j+1).getclose())-Double.parseDouble(stock.get(j).getclose());
					if(C>=0){
						A+=C;
					}else{
						B-=C;
					}
				}
				if(A==B)
					RS=1;
				else
				RS=A/B;
				
				RSI=100-100/(1+RS);
				DecimalFormat df = new DecimalFormat("0.000");
				RSIVO temp = new RSIVO(df.format(RSI),stock.get(i).getdate());

				list.add(temp);
			}
			
			return list;
			
		}
		
		/**
		 * 威廉指标
		 */
		public ArrayList<WRVO> ComputeWR(String str,int day,int number, String endtime) throws Exception, JSONException, ParseException {
            
			ArrayList<WRVO>list =new ArrayList<WRVO>();
			DataControllerService dc =new DataController();
			int n = 0;
			ArrayList<StockDetailPO> stock = new ArrayList<StockDetailPO>();
			do{
			    stock= dc.getStock(str,TimeGetter.getDayBefore(endtime, n+day+number-1),endtime);
			    n++;
		    }while(stock.size()!=day+number-1);
			
			for(int i=number-1;i<stock.size();i++){
			    double high=0;
			    double low=0;
			    double WR = 0;
			
			    for(int j=i-number+1;j<i+1;j++){
				    double hig=Double.valueOf(stock.get(j).gethigh());
				    double lo=Double.valueOf(stock.get(j).getlow());
				    if(hig>=high){
					    high=hig;
				    }
				    if(lo<=low){
					    low=lo;
				    }
			    }
			    
			    	double close = Double.parseDouble(stock.get(i).getclose());
			    	WR=((high-close)/(high-low))*100;
					DecimalFormat df = new DecimalFormat("0.000");
					WRVO temp = new WRVO(df.format(WR),stock.get(i).getdate());
					list.add(temp);
			    }
			return list;
		}
		
		/**
		 * 人气意愿
		 */
public ArrayList<ARVO> ComputeAR(String str,int day,int number, String endtime) throws Exception, JSONException, ParseException {
            
			ArrayList<ARVO>list =new ArrayList<ARVO>();
			DataControllerService dc =new DataController();
			int n = 0;
			ArrayList<StockDetailPO> stock = new ArrayList<StockDetailPO>();
			do{
			    stock= dc.getStock(str,TimeGetter.getDayBefore(endtime, n+day+number-1),endtime);
			    n++;
		    }while(stock.size()!=day+number-1);
			
			for(int i=number-1;i<stock.size();i++){
			    double AR = 0;
			    
			    double HO = 0;
			    double OL = 0;
			    for(int j=i-number+1;j<i+1;j++){
				    double high=Double.valueOf(stock.get(j).gethigh());
				    double low=Double.valueOf(stock.get(j).getlow());
				    double open=Double.valueOf(stock.get(j).getopen());
				    HO+=(high-low);
				    OL+=(open-low);
			    }
			    
			    	
			    	AR=(HO/OL)*100;
					DecimalFormat df = new DecimalFormat("0.000");
					ARVO temp = new ARVO(df.format(AR),stock.get(i).getdate());
					list.add(temp);
			    }
			return list;
		}

public static void main(String[] args) throws Exception{
	StocksStatisticsBL2 test=new StocksStatisticsBL2();
	ArrayList<RSIVO> list= test.ComputeRSI("600300", 50, 6,"2016-04-01");
	
	
}
}
