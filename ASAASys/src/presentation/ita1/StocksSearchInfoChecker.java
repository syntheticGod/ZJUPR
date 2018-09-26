package presentation.ita1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StocksSearchInfoChecker {
     public static boolean checkisDate(String str){

    	 return DateType.isDate(str);
     }
     public static boolean checkDateOrder(String str1,String str2){
		
    	 //String dateString = "2012-12-06 ";  
    	 Date date1=null;
    	 Date date2 = null;
    	 try  
    	 {  
    	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
    	     date1 = sdf.parse(str1);  
    	 }  
    	 catch (ParseException e)  
    	 {  
    	     System.out.println(e.getMessage());  
    	 }  
    	 
    	 try  
    	 {  
    	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
    	     date2 = sdf.parse(str2);  
    	 }  
    	 catch (ParseException e)  
    	 {  
    	     System.out.println(e.getMessage());  
    	 }
    	 
    	 boolean ans=date1.before(date2)||date1.equals(date2);
    	 
    	 return ans;
     }
     public static boolean checkNull(String str1,String str2){
		boolean ans=false;
    	 if(str1.equals("")&&str2.equals(""))
    	ans= true;
    	 return ans;
    	 
     }
     public static boolean checkInfoOrder(String str1,String str2){
		
    	 if(!(str1.equals("0")||NumberValidationUtils.isPositiveInteger(str1)||NumberValidationUtils.isPositiveDecimal(str1)))
    	    return false;
    	 if(!(str2.equals("0")||NumberValidationUtils.isPositiveInteger(str2)||NumberValidationUtils.isPositiveDecimal(str2)))
    		 return false;
    	 double num1=Double.parseDouble(str1);
    	 double num2=Double.parseDouble(str2);
    	 if(num1>num2)
    		 return false;
    		 
    		 
    	 return true;
     }
}
