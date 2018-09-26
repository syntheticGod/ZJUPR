package presentation.ita1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeGetter {
  public static String getToday(){
	    Date date=new Date();
	    DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	   
	  
	  return df.format(date);
  }
	
public static String getDayBefore(int n){
	Calendar c=Calendar.getInstance();
	
	  c.add(Calendar.DATE, -n);
	  Date date=c.getTime();
	  DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	  
	  return df.format(date);
  }

public static String getDayBefore(String dateSet,int n){
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date xdate=null;
	
	try {
		xdate= sdf.parse(dateSet);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	 Calendar c=Calendar.getInstance();
	 c.setTime(xdate);
	  c.add(Calendar.DATE, -n);
	  Date date=c.getTime();
	  DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	  
	  return df.format(date);
  }


	public static int getYear(){
		Calendar calendar=Calendar.getInstance();
		//获得当前时间的月份，月份从0开始所以结果要加1
		int year=calendar.get(Calendar.YEAR);
		
		
		
		return year;
		
		
	}
	
	
	
	
	/**
	 * 
	 * @param day 
	 * @return  星期几，若是周日则为0，周六为6.
	 */
	public static int getDAY_OF_WEEK(String day){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date xdate=null;
		
		try {
			xdate= sdf.parse(day);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 Calendar   calendar   =   Calendar.getInstance();   
		 calendar.setTime(xdate);
         int   week   =   calendar.get(Calendar.DAY_OF_WEEK)-1;   
		
		return week;
	}



}
