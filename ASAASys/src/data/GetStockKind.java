package data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import po.StockKindPO;






public class GetStockKind {
	final static String URL = "https://api.wmcloud.com:443/data/v1//api/equity/getEquIndustry.json";
	final static String TOKEN = "85d6d9fb3ae37ec9d8cae561cfc8d17ca60199addf31c54b79bade64eadb9e89";	
	//1e6e01ca1199c3f101e4e331fa5b3f3e883226ef7d6e75539a3efede24c5e6d6
	final static String PARAM1 = "field=&industryVersionCD=010303&industry=&secID=&ticker=";
	final static String PARAM2 = "&intoDate=";
	public static StockKindPO GetTonglianKind(String id) throws JSONException{
        StringBuilder json = new StringBuilder();
    	
    	StockKindPO kind = new StockKindPO();
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = URL+ "?" +PARAM1+id+PARAM2;
            URL realUrl = new URL(urlNameString);
            
            URLConnection connection = realUrl.openConnection();

            connection.setRequestProperty("Authorization","Bearer "+TOKEN);
            connection.connect();

            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                json.append(line);
            }
        } catch (Exception e) {
            System.out.println("出现异常" + e);
            e.printStackTrace();
            return kind;
        }
      
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        System.out.println(" "+json);
        
        JSONObject stockKind= new JSONObject(json.toString());
        JSONArray jr = new JSONArray(stockKind.getString("data"));
        result = jr.getJSONObject(0).getString("industryName1");
		kind.setkind(result);
		kind.setid(id);
		return kind;
	}
	
	public static void main(String[] args) throws JSONException{
	StockKindPO s=GetStockKind.GetTonglianKind("600100");
	System.out.println(s.getid());
	System.out.println(s.getkind());
	}	
}