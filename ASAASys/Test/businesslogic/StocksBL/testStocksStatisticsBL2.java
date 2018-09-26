package businesslogic.StocksBL;

import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import data.Get;
import data.GetStockDetail;
import junit.framework.Assert;
import po.StockDetailPO;
import vo.ARVO;
import vo.KDJVO;
import vo.RSIVO;
import vo.WRVO;

public class testStocksStatisticsBL2 {
	
	StocksStatisticsBL2 getStockDetail;
	
	@Before
	public void setUp(){
		getStockDetail = new StocksStatisticsBL2();
	}


	@Test
	public void testKDJ() throws Exception {
		
		ArrayList<KDJVO> result = getStockDetail.ComputeKDJ("600300", 40, 14, "2016-04-01");
		Assert.assertEquals("错误","45.029",result.get(0).getK());
		Assert.assertEquals("错误","48.343",result.get(0).getD());
		Assert.assertEquals("错误","54.971",result.get(0).getJ());
		Assert.assertEquals("错误","2016-02-05",result.get(0).getDate());
		
	}
	
	public void testRSI() throws Exception {
		
		ArrayList<RSIVO> result = getStockDetail.ComputeRSI("600300", 40, 14, "2016-04-01");
		Assert.assertEquals("错误","31.915",result.get(0).getData());
		Assert.assertEquals("错误","2016-02-05",result.get(0).getDate());
		
	}
	
	public void testWR() throws Exception {
		
		ArrayList<WRVO> result = getStockDetail.ComputeWR("600300", 40, 14, "2016-04-01");
		Assert.assertEquals("错误","13.214",result.get(0).getData());
		Assert.assertEquals("错误","2016-02-05",result.get(0).getDate());
		
	}
	
	public void testAR() throws Exception {
		
		ArrayList<ARVO> result = getStockDetail.ComputeAR("600300", 40, 14, "2016-04-01");
		Assert.assertEquals("错误","195.699",result.get(0).getData());
		Assert.assertEquals("错误","2016-02-05",result.get(0).getDate());
		
	}
	
	

}
