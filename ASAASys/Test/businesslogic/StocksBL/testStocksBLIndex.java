package businesslogic.StocksBL;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import data.Get;
import data.GetStockDetail;
import junit.framework.Assert;
public class testStocksBLIndex {
     StocksBLIndex test;
     
     @Before
     public void setUp(){
    	 test = new StocksBLIndex();
     }
     
     
     @Test
     public void testAtr() throws JSONException, ParseException{
    	 Assert.assertEquals("sh600100",test.getAtr("600100", 40, "2015-10-08").get(39).getName());
    	
     }
     @Test
     public void testVr() throws JSONException, ParseException{   	 
    	 Assert.assertEquals("sh600100",test.getVr("600100", 40, "2015-10-08").get(39).getName());
     }
     @Test
     public void testCCI() throws JSONException, ParseException{
    	 Assert.assertEquals("sh600100",test.getCCI("600100", 40, "2015-10-08").get(39).getName());
    	
     }
     @Test
     public void testObv() throws JSONException, ParseException{
    	 Assert.assertEquals("sh600100",test.getObv("600100", 40, "2015-10-08").get(39).getName());
     }
     
}
