package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import dataservice.StockNameGetService;

public class NameGetter implements StockNameGetService{
	public  String getName(String name) {               
	          
		String urlStr="http://hq.sinajs.cn/list=sh"+name;
		
		
	    URL url = null;              
	      
	    HttpURLConnection httpConn = null;            
	    
	    BufferedReader in = null;   
	    StringBuffer sb = new StringBuffer();   
	    try{     
	     url = new URL(urlStr);     
	     in = new BufferedReader( new InputStreamReader(url.openStream(),"GBK") );   
	     String str = null;    
	     while((str = in.readLine()) != null) {    
	      sb.append( str );     
	            }     
	        } catch (Exception ex) {   
	            
	        } finally{    
	         try{             
	          if(in!=null) {  
	           in.close();     
	                }     
	            }catch(IOException ex) {      
	            }     
	        }     
	        String result =sb.toString();     
	        
	        
	        int index=result.indexOf("=");
	        int index_2=result.indexOf(",");
	        result=result.substring(index+2, index_2);
	        
	        return result;    
	        }    
	
	
	
}
