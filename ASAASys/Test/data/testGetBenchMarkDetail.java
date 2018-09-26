package data;

import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;
import org.junit.*;

import po.BenchMarkDetailPO;

public class testGetBenchMarkDetail {
	@Test
	public void testBench() throws JSONException, ParseException{
		String s = Get.sendGet("http://121.41.106.89:8010/api/benchmark/hs300", "start=2015-01-01&end=2015-01-30&fields=open+close+high+low");
		ArrayList<BenchMarkDetailPO> testPO=GetBenchMarkDetail.GetDetailBenchMark(s);
		Assert.assertEquals("返回股票信息错误", "3533.71", testPO.get(0).getclose());
	}
	

}
