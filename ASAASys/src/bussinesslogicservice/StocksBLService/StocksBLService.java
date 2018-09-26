package bussinesslogicservice.StocksBLService;

import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;

import vo.StockDetailVO;
import vo.StocksSearchInfoVO;
import vo.StocksVO;

public interface StocksBLService {
	
	public StocksVO addStocks(String str) throws JSONException, ParseException;
	
	public ArrayList<StocksVO> getDetailsOfStock(String str) throws JSONException, ParseException;
	
	public ArrayList<StocksVO> stocksSearch(StocksSearchInfoVO stocksInfo) throws JSONException, ParseException;



}
