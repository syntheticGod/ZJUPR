package dataservice;

import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;

import po.BenchMarkDetailPO;
import po.StockDetailPO;
import po.StockKindPO;
import po.StockNamePO;

public interface DataControllerService {
	/**
	 * 返回对应股票ID的股票行业
	 * @param id 输入的股票ID
	 * @return 返回一个StockKindPO
	 *         用 get方法 获得它的 ID 和 Kind 属性
	 */
	public StockKindPO getStockKind(String id) throws JSONException, ParseException;
	/**
	 *  返回大盘的信息
	 * @param starttime:开始时间
	 * @param endtime:结束时间
	 * @return
	 * @throws JSONException
	 * @throws ParseException
	 */
	public ArrayList<BenchMarkDetailPO> getBench(String starttime, String endtime) throws JSONException, ParseException;
	/**
	 * 返回具体股票的信息
	 * @param name:股票ID
	 * @param starttime:开始时间
	 * @param endtime:结束时间
	 * @return
	 * @throws JSONException
	 * @throws ParseException
	 */
	public ArrayList<StockDetailPO> getStock(String name,String starttime,String endtime) throws JSONException, ParseException;
	/**
	 * 默认返回上一个月具体股票的信息
	 * @param name:股票ID
	 * @return
	 * @throws JSONException
	 * @throws ParseException
	 */
	public ArrayList<StockDetailPO> getNotimeStock(String name) throws JSONException, ParseException;
	/**
	 * 返回所有股票列表
	 * @return
	 * @throws JSONException
	 * @throws ParseException
	 */
	public ArrayList<StockNamePO> getStockName() throws JSONException, ParseException;

}
