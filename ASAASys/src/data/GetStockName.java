package data;



import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import po.StockNamePO;
public class GetStockName {
	/**
     * �������еĹ�Ʊ�б��url
     * 
     * @param jsonString
     *            Json�����ַ���
     * @throws JSONException
     * @throws ParseException
     */
    public static ArrayList<StockNamePO> GetStockList(String jsonString) throws JSONException,
            ParseException {
    	/*
    	 * JSONObject ������ת��ԭ�е�JSON����
    	 * JSONArray������һ�����ָ�����Ƶ�����
    	 */
    	ArrayList<StockNamePO> namePO = new ArrayList<StockNamePO>();
    	
    	//�������쳣ʱ����null
    	if(jsonString == "wrong"){
    		return namePO;
    	}

        JSONObject jo = new JSONObject(jsonString);
        JSONArray ja = jo.getJSONArray("data");
        
        
        //������ת���ɶ���Ĵ���
        /*
                String jsonStr = jo.getString("employee");
                Employee emp = new Employee();
                JsonHelper.toJavaBean(emp, jsonStr);

                System.out.println("\n��Json���ݽ���ΪEmployee����");
                System.out.println("name: " + emp.getName() + " sex: " + emp.getSex()
                        + " age: " + emp.getAge());
        */
        /*
         * ��������JSON�����е�data���ù�Ʊ���б���Ϣ
         */
        for(int i = 0;i<ja.length();i++){
             System.out.println("name: " + ja.getJSONObject(i).getString("name") + "  link: " + ja.getJSONObject(i).getString("link")
               );
             StockNamePO tmp = new StockNamePO();
             tmp.setname(ja.getJSONObject(i).getString("name"));
             namePO.add(tmp);
        }
        return namePO;
 

    }
    public static void main(String[] args) throws JSONException, ParseException{
    	String JSONstring = Get.sendGet("http://121.41.106.89:8010/api/stocks/", "year=2014&exchange=sh");
    	GetStockList(JSONstring);
    }

}
