package data;



import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import po.BenchMarkDetailPO;

public class GetBenchMarkDetail {
	/**
     * ��ȡָ������ָ��������
     * 
     * @param date:����   close:���̼�  open:���̼�  high:��߼�  low:��ͼ�
     * @throws JSONException
     * @throws ParseException
     */
	 public static ArrayList<BenchMarkDetailPO> GetDetailBenchMark(String jsonString) throws JSONException,
     ParseException {
	/*
	 * JSONObject ������ת��ԭ�е�JSON����
	 * JSONArray������һ�����ָ�����Ƶ�����
	 */
	//��ʱdata���ص���������һ��JSON��������Ҫ��������JSON����
		ArrayList<BenchMarkDetailPO> benchPO = new ArrayList<BenchMarkDetailPO>();
		
		
		//�������쳣ʱ����null
		if(jsonString == "wrong"){
			return benchPO;
		}
		

        JSONObject jo = new JSONObject(jsonString);
        JSONObject temp = new JSONObject(jo.getString("data"));
        JSONArray ja = temp.getJSONArray("trading_info");
 
 
    /*
     * ��������JSON�����е�data���ô��̵��б���Ϣ
     */
        for(int i = 0;i<ja.length();i++){
            System.out.println("date: " + ja.getJSONObject(i).getString("date") + "  close: " + ja.getJSONObject(i).getString("close")+" open: "+ ja.getJSONObject(i).getString("open")
            		+" high: "+ ja.getJSONObject(i).getString("high") + " low: "+ja.getJSONObject(i).getString("low"));
            BenchMarkDetailPO tmp = new BenchMarkDetailPO();
            tmp.setclose(ja.getJSONObject(i).getString("close"));
            tmp.setdate(ja.getJSONObject(i).getString("date"));
            tmp.sethigh(ja.getJSONObject(i).getString("high"));
            tmp.setlow(ja.getJSONObject(i).getString("low"));
            tmp.setopen(ja.getJSONObject(i).getString("open"));
            benchPO.add(tmp);
            
        }
		return benchPO;      
	 }
	 public static void main(String[] args) throws JSONException, ParseException{
		 String s = Get.sendGet("http://121.41.106.89:8010/api/benchmark/hs300", "start=2015-01-01&end=2015-01-30&fields=open+close+high+low");
		 System.out.println(s);
		 GetDetailBenchMark(s);
	 }
	 

}
