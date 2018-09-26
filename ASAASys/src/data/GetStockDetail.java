package data;



import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import po.StockDetailPO;
public class GetStockDetail {
	/**
     * ����ָ����Ʊ����Ľ�������
     * 
     * @param 
     *            open: ���̼� high: ��߼�  low: ��ͼ�  close: ���̼�  adj_price: ��Ȩ��  volume: �ɽ���  turnover: ������
     *            pe: ��ӯ�� pb: �о���             
     * @throws JSONException
     * @throws ParseException
     */
    public static ArrayList<StockDetailPO> GetStock(String jsonString) throws JSONException,
            ParseException {
    	/*
    	 * JSONObject ������ת��ԭ�е�JSON����
    	 * JSONArray������һ�����ָ�����Ƶ�����
    	 */
    	//��ʱdata���ص���������һ��JSON��������Ҫ��������JSON����
    	
    	ArrayList<StockDetailPO> stockPO = new ArrayList<StockDetailPO>();
    	
    	//�������쳣ʱ����null
    	if(jsonString == "wrong"){
    		return stockPO;
    	}

        JSONObject jo = new JSONObject(jsonString);
        JSONObject temp = new JSONObject(jo.getString("data"));
        JSONArray ja = temp.getJSONArray("trading_info");
        
        
        /*
         * ��������JSON�����е�data���ù�Ʊ���б���Ϣ
         */
        for(int i = 0;i<ja.length();i++){
//             System.out.println("date: " + ja.getJSONObject(i).getString("date") + "  high: " + ja.getJSONObject(i).getString("high")+" open: "+ ja.getJSONObject(i).getString("open")+" close: "+ ja.getJSONObject(i).getString("close")
//        		+" low: "+ja.getJSONObject(i).getString("low")+" volume: "+ja.getJSONObject(i).getString("volume")+" turnover: "+ja.getJSONObject(i).getString("turnover")+" pb: "+ja.getJSONObject(i).getString("pb"));
             StockDetailPO tmp = new StockDetailPO();
             tmp.setclose(ja.getJSONObject(i).getString("close"));
             tmp.setdate(ja.getJSONObject(i).getString("date"));
             tmp.sethigh(ja.getJSONObject(i).getString("high"));
             tmp.setlow(ja.getJSONObject(i).getString("low"));
             tmp.setopen(ja.getJSONObject(i).getString("open"));
             tmp.setpb(ja.getJSONObject(i).getString("pb"));
             tmp.setturnover(ja.getJSONObject(i).getString("turnover"));
             String volumestr=ja.getJSONObject(i).getString("volume");
             if(volumestr.length()>=2)            
             tmp.setvolume(volumestr.substring(0, volumestr.length()-2));
             else
              tmp.setvolume( volumestr);
             stockPO.add(tmp);
           
        }
		return stockPO;
    }
    public static void main(String[] args) throws JSONException, ParseException{
    	String s = Get.sendGet("http://121.41.106.89:8010/api/stock/sh600000/","start=2016-03-05&end=2016-03-06&fields=open+high+close+low+volume+turnover+pb");
    	System.out.println(s);
   	GetStockDetail.GetStock(s);
    }

}
