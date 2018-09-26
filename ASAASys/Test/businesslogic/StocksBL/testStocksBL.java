package businesslogic.StocksBL;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;

import junit.framework.Assert;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import vo.StocksSearchInfoVO;
import vo.StocksVO;



public class testStocksBL {
	StocksBL bl;
	
	
	@Before 
	public void init(){
		bl=new StocksBL();

	}
	
	@Test
	public void testAddStocks() {
		init();
		
		StocksVO actual = null;
		try {
			actual = bl.addStocks("600300");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals("600300", actual.getName());
		
	}
	
	@Test
	public void testGetDetailsOfStock() {
		init();
		
		ArrayList<StocksVO> actual = null;
		try {
			actual = bl.getDetailsOfStock("600300");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<actual.size();i++){
			Assert.assertEquals("600300", actual.get(i).getName());
			
			
		}
		
		
	}
	
	@Test
	public void testStocksSearch() {
		init();
		
		ArrayList<StocksVO> actual = null;
		StocksSearchInfoVO stocksInfo=new StocksSearchInfoVO("600300", "2016-01-01", "2016-03-11", 0, 0, 0, 0, 0, 0, 0, 0);
		try {
			actual = bl.stocksSearch(stocksInfo);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<actual.size();i++){
			Assert.assertEquals("600300", actual.get(i).getName());
			
			
		}
		
		
	}
}
