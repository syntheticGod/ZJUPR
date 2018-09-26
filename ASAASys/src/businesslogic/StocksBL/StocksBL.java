package businesslogic.StocksBL;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.json.JSONException;

import data.DataController;
import dataservice.DataControllerService;
import po.StockDetailPO;
import presentation.ita1.TimeGetter;
import vo.StockDetailVO;
import vo.StocksSearchInfoVO;
import vo.StocksVO;
import bussinesslogicservice.StocksBLService.StocksBLService;



public class StocksBL implements StocksBLService {


	@Override
	public StocksVO addStocks(String str) throws JSONException, ParseException {
		// TODO Auto-generated method stub
		Date dt=new Date(0);//�������Ҫ��ʽ,��ֱ����dt,dt���ǵ�ǰϵͳʱ��
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//������ʾ��ʽ
        String nowTime="";
        
        nowTime= df.format(dt);
       
        ArrayList<StockDetailPO> StockPO = new ArrayList<StockDetailPO>();
        
        boolean exist=false;
        
        for(int i=1;i<31;i++){
        	DataControllerService dc = new DataController();
    		StockPO=dc.getStock(str, TimeGetter.getDayBefore(i-1), TimeGetter.getDayBefore(i-2));
        	if(StockPO.size()!=0){
        		exist=true;
                break;
        	}
    		
        }
        
        StocksVO stocksvo = new StocksVO("none", "none","none","none","none","none","none","none","none");
        
        if(exist){
        	 stocksvo = new StocksVO(str, StockPO.get(0).getdate(),StockPO.get(0).getopen(),StockPO.get(0).getclose(),StockPO.get(0).gethigh(),StockPO.get(0).getlow(),StockPO.get(0).getvolume(),StockPO.get(0).getturnover(),StockPO.get(0).getpb());
        }
       
		
		
		
		
		//String name,String date,String open,String close,String high,String low,String volume,String turnover,String pb
		
		
		
	
		return stocksvo;
		
	}

	@Override
	public ArrayList<StocksVO> getDetailsOfStock(String str) throws JSONException, ParseException {
		// TODO Auto-generated method stub
		ArrayList<StockDetailPO> StockPO=new ArrayList<StockDetailPO>();
		
		DataControllerService dc = new DataController();
		
		StockPO = dc.getNotimeStock(str);
		
		
		
		
		if(StockPO.size()==0){
			ArrayList<StocksVO>list1 = new ArrayList<StocksVO>();
			return list1;
		}
	
		
		
		
		ArrayList<StocksVO> list = new ArrayList<StocksVO>();
		
		//String name,String date,String open,String close,String high,String low,String volume,String turnover,String pb
		
		for(int i = 0;i<StockPO.size();i++){
			StocksVO temp = new StocksVO(str,StockPO.get(i).getdate(),StockPO.get(i).getopen(),StockPO.get(i).getclose(),StockPO.get(i).gethigh(),StockPO.get(i).getlow(),StockPO.get(i).getvolume(),StockPO.get(i).getturnover(),StockPO.get(i).getpb());
			list.add(temp);
		}
		return list;
	}

	@Override
	public ArrayList<StocksVO> stocksSearch(StocksSearchInfoVO stocksInfo) throws JSONException, ParseException {
		// TODO Auto-generated method stub		
		DataControllerService dc = new DataController();
	
		
		ArrayList<StocksVO> stocksearch = new ArrayList<StocksVO>();
		
		ArrayList<StockDetailPO> StockPO = dc.getStock(stocksInfo.getName(), stocksInfo.getBeginDate(), stocksInfo.getEndDate());
		int n = -1;
		while(StockPO.size()==0){
			StockPO=dc.getStock(stocksInfo.getName(),stocksInfo.getBeginDate(), TimeGetter.getDayBefore(stocksInfo.getEndDate(), n));
			n--;
		}
			for(int i = 0;i<StockPO.size();i++){
				
				StocksVO temp = new StocksVO(stocksInfo.getName(),StockPO.get(i).getdate(),StockPO.get(i).getopen(),StockPO.get(i).getclose(),StockPO.get(i).gethigh(),StockPO.get(i).getlow(),StockPO.get(i).getvolume(),StockPO.get(i).getturnover(),StockPO.get(i).getpb());
				
			/*	String date = temp.getDate();
				String searchbegindate = stocksInfo.getBeginDate();
				String searchenddate = stocksInfo.getEndDate();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
				Date d = (Date) sdf.parse(date);
				Date sbd = (Date) sdf.parse(searchbegindate);
				Date sed = (Date) sdf.parse(searchenddate);*/
				
			
				
					if( (Double.parseDouble(temp.getOpen())<=stocksInfo.getKaipanMax()&&Double.parseDouble(temp.getOpen())>=stocksInfo.getKaipanMin()) || (stocksInfo.getKaipanMin()==0&&stocksInfo.getKaipanMax()==0)){
						
						if( (Double.parseDouble(temp.getClose())<=stocksInfo.getShoupanMax()&&Double.parseDouble(temp.getClose())>=stocksInfo.getShoupanMin()) || (stocksInfo.getShoupanMin()==0&&stocksInfo.getShoupanMax()==0)){
							
							if( (Double.parseDouble(temp.getHigh())<=stocksInfo.getMaxMax()&&Double.parseDouble(temp.getHigh())>=stocksInfo.getMaxMin()) || (stocksInfo.getMaxMin()==0&&stocksInfo.getMaxMax()==0)){
								
								if( (Double.parseDouble(temp.getLow())<=stocksInfo.getMinMax()&&Double.parseDouble(temp.getLow())>=stocksInfo.getMinMin()) || (stocksInfo.getMinMin()==0&&stocksInfo.getMinMax()==0)){	
									stocksearch.add(temp);
								}
							}
						}					
					}	
					
			}
				
		return stocksearch;

	}
	public static void main(String[] args) throws JSONException, ParseException{
		StocksBL test=new StocksBL();
		System.out.print(test.getDetailsOfStock("sh600001"));
	}

	
}
