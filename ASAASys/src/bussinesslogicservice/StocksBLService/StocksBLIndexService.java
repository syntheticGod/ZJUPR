package bussinesslogicservice.StocksBLService;

import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;

import vo.AtrVO;
import vo.CCIVO;
import vo.ObvVO;
import vo.VrVO;

public interface StocksBLIndexService {
	/**
	 * 返回一段时间的均幅指标
	 * @param number：返回数据个数
	 *        name:股票ID （不带sh）
	 *        endtime:结束时间
	 * 
	 * @return
	 */
	public ArrayList<AtrVO> getAtr(String name,int number,String endtime)throws JSONException, ParseException;
	/**
	 * 返回一段时间的能量潮
	 * @param number：返回的数据个数
	 *        name：股票ID（不带sh）
	 *        endtime：结束时间
	 */
	public ArrayList<ObvVO> getObv(String name,int number,String endtime)throws JSONException, ParseException;
	/**
	 * 返回一段时间的容量比率
	 * @param name:股票ID
	 *        number:返回的数据个数
	 *        endtime:结束时间
	 *
	 */
	public ArrayList<VrVO> getVr(String name,int number,String endtime)throws JSONException, ParseException;
	/**
	 * 返回一段时间的顺势指标
	 * @param name:股票ID
	 *        number:返回的数据个数
	 *        endtime:结束时间
	 */
	public ArrayList<CCIVO> getCCI(String name,int number,String endtime)throws JSONException,ParseException;
	
	

}
