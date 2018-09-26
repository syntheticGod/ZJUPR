package bussinesslogicservice.StocksBLService;

import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;

import vo.CategoryDetailVO;
import vo.CategoryStatisticsVO;
import vo.RequestCategoryVO;

public interface CategoryStatisticsBLService {

	public  CategoryStatisticsVO CategoryStatistics(ArrayList<RequestCategoryVO> list) throws JSONException, ParseException;
	
	public String GetStockKind(String id) throws JSONException, ParseException;
	
	public ArrayList<CategoryDetailVO> GetCategoryDetail(ArrayList<String> list);
}