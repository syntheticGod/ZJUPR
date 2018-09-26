package presentation.ita2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONException;

import presentation.ita1.TimeGetter;
import businesslogic.StocksBL.StocksBL;
import bussinesslogicservice.StocksBLService.StocksBLService;
import vo.StocksSearchInfoVO;
import vo.StocksVO;

public class TimePusher_ita2 {
  /**
   * 
   * 
   * 
   * @param begindate 开始日期
   * @param n 要获得之前n个的股票数据(n可为负数)
   * @param name 股票代码
   * @return  股票数据
   */
	public static ArrayList<StocksVO> getStocksBefore(String name,String begindate,int n){
	  
		begindate=TimeGetter.getDayBefore(begindate, -1);
		
	
		int tempn=n/5*2+n-5;
		 ArrayList<StocksVO> anslist=null;
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		  Date begin = null;
		  
		  try {
			begin = sdf.parse(begindate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
		  int size=0;
		  
        while(size!=n){
			  
        	Calendar c=Calendar.getInstance();
			c.setTime(begin);
		  
			
			c.add(Calendar.DATE, -tempn);
		  Date date=c.getTime();
		  DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		  String tempDate=df.format(date);
	       
		  StocksBLService bl=new StocksBL();
		  
		  StocksSearchInfoVO tempVO=new StocksSearchInfoVO( name,tempDate,     
				  begindate,
					 0,
					 0,
					 0,
					 0,
					 0,
					 0,
					 0,
					 0 );
		  
		  
		 
		  try {
			  anslist=bl.stocksSearch(tempVO);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  size=anslist.size();
		  tempn++;
			  
		  }
		  
		  return anslist;
		  
		  
		 
	
  }

	
	
	
}
