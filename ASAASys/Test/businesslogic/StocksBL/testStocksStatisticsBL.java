package businesslogic.StocksBL;

import java.text.ParseException;
import java.util.ArrayList;

import junit.framework.Assert;

import org.json.JSONException;
import org.junit.Test;

import vo.BIASVO;
import vo.DMIVO;
import vo.PSYVO;

public class testStocksStatisticsBL {
	StocksStatisticsBL bl;
	
	public void init(){
		bl = new StocksStatisticsBL();
	}
	@Test
	public void testComputeBIAS() throws Exception{
		init();
		
		ArrayList<BIASVO> list = null;
		
		try{
			list = bl.ComputeBIAS("600100","2016-04-01",10, 12);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals("2016-03-18",list.get(0).getDate());	
		Assert.assertEquals("-2.14",list.get(1).getData());
		
	}
	
	@Test
	public void testComputePSY() throws Exception{
		init();
		
		ArrayList<PSYVO> list =null;
	
		try{
			list=bl.ComputePSY("600100","2016-04-01",10);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals("2016-03-18",list.get(0).getDate());	
		Assert.assertEquals("75.00",list.get(1).getData());
		
	}
	
	@Test
	public void testComputeDMI() throws Exception{
		init();
		
		ArrayList<DMIVO> list =null;
		
		try{
			list=bl.ComputeDMI("600100","2016-04-01",10);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals("2016-03-18",list.get(0).getDate());	
		Assert.assertEquals("0.53",list.get(0).getZhengDM());
		Assert.assertEquals("0",list.get(0).getFuDM());
		Assert.assertEquals("33.13",list.get(1).getZhengDI());
		Assert.assertEquals("17.96",list.get(1).getFuDI());
		Assert.assertEquals("0.19",list.get(2).getTrueRange());
		Assert.assertEquals("47.59",list.get(2).getDX());
		Assert.assertEquals("34.18",list.get(3).getADX());
		Assert.assertEquals("35.05",list.get(4).getADXR());
		
		
		
		
		
	}

}
