package data;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import data.Get;
import data.GetStockDetail;
import data.GetStockName;
import junit.framework.Assert;
import po.StockNamePO;

public class TestGetStockName {
	GetStockName getStockName;
	
	@Before
	public void setUp(){
		getStockName = new GetStockName();
	}

	@Test
	public void testGetStockList() throws JSONException, ParseException {
		String s = Get.sendGet("http://121.41.106.89:8010/api/stocks/", "year=2014&exchange=sh");
		ArrayList<StockNamePO> result = getStockName.GetStockList(s);
		Assert.assertEquals("json数据转换有问题","sh600000",result.get(0).getname());
		Assert.assertEquals("json数据转换有问题","sh600004",result.get(1).getname());
		Assert.assertEquals("json数据转换有问题","sh600005",result.get(2).getname());
		
	}

}
