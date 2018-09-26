package data;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import data.Get;
import data.GetStockDetail;
import junit.framework.Assert;
import po.StockDetailPO;

public class TestGetStockDetail {
	
	GetStockDetail getStockDetail;
	
	@Before
	public void setUp(){
		getStockDetail = new GetStockDetail();
	}


	@Test
	public void testGetStock() throws JSONException, ParseException {
		String s = Get.sendGet("http://121.41.106.89:8010/api/stock/sh600000/","start=2016-03-04&end=2016-03-05&fields=open+high+close+low+volume+turnover+pb");
		ArrayList<StockDetailPO> result = getStockDetail.GetStock(s);
		Assert.assertEquals("json数据转换有问题","18.45",result.get(0).getclose());
		Assert.assertEquals("json数据转换有问题","2016-03-04",result.get(0).getdate());
		Assert.assertEquals("json数据转换有问题","0",result.get(0).gethigh());
		Assert.assertEquals("json数据转换有问题","0",result.get(0).getopen());
		Assert.assertEquals("json数据转换有问题","0",result.get(0).getvolume());
		Assert.assertEquals("json数据转换有问题","0",result.get(0).getturnover());
		Assert.assertEquals("json数据转换有问题","1.27",result.get(0).getpb());
	}

}
