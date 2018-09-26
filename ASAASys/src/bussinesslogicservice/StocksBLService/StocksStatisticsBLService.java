package bussinesslogicservice.StocksBLService;

import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;

import vo.BIASVO;
import vo.DMIVO;
import vo.PSYVO;

/**
 * 统计股票各个指标：
 * 
 * 乖离率
 * 心理线
 * 动向指标
 * 
 * 随机指标
 * 强弱指标
 * 威廉指标
 * 人气意愿
 * 容量比率
 * 能量潮
 * CCI
 * 均幅指标
 * 
 * @author 岛风
 *
 */
public interface StocksStatisticsBLService {
	/**
	 * 乖离率的值 
	 * @param str
	 * @param endtime
	 * @param number
	 * @return
	 * @throws Exception
	 * @throws JSONException
	 * @throws ParseException
	 */
	
	public ArrayList<BIASVO> ComputeBIAS(String str,String endtime,int number,int canshu) throws Exception, JSONException, ParseException;

	

	//乖离率

	public ArrayList<PSYVO>ComputePSY(String str,String endtime,int number) throws Exception, Exception, Exception;
	//心理线
	public ArrayList<DMIVO>ComputeDMI(String str,String endtime,int number) throws Exception, JSONException, ParseException;
    //动向指标
}