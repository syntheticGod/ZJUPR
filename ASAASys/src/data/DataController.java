package data;



import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;

import dataservice.DataControllerService;
import po.BenchMarkDetailPO;
import po.StockDetailPO;
import po.StockKindPO;
import po.StockNamePO;


public class DataController implements DataControllerService{
	public ArrayList<BenchMarkDetailPO> getBench(String starttime, String endtime) throws JSONException, ParseException{
		String result = Get.sendGet("http://121.41.106.89:8010/api/benchmark/hs300","start="+starttime+"&end="+endtime+"&fields=open+close+high+low");
		return GetBenchMarkDetail.GetDetailBenchMark(result);
	}
	public ArrayList<StockDetailPO> getStock(String name,String starttime,String endtime) throws JSONException, ParseException{
		String result = Get.sendGet("http://121.41.106.89:8010/api/stock/"+"sh"+name+"/","start="+starttime+"&end="+endtime+"&fields=open+high+close+low+volume+turnover+pb");
		return GetStockDetail.GetStock(result);
	}
	public ArrayList<StockDetailPO> getNotimeStock(String name) throws JSONException, ParseException{
		String result = Get.sendGet("http://121.41.106.89:8010/api/stock/"+"sh"+name+"/","fields=open+high+close+low+volume+turnover+pb");
		return GetStockDetail.GetStock(result);
	}
	public ArrayList<StockNamePO> getStockName() throws JSONException, ParseException{
		String result = Get.sendGet("http://121.41.106.89:8010/api/stocks/", "year=2014&exchange=sh");
		return GetStockName.GetStockList(result);
	}
	@Override
	public StockKindPO getStockKind(String id) throws JSONException,
			ParseException {
		return GetStockKind.GetTonglianKind(id);
	}

}
