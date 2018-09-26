package data;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Get {
    /**
     * ��ָ��URL����GET����������
     * 
     * @param url
     *            ���������URL
     * @param param
     *            ����������������Ӧ���� name1=value1&name2=value2 ����ʽ��
     * @return URL ������Զ����Դ����Ӧ���
     */
    public static String sendGet(String url, String param) {
    	
    	//�Լ��¼ӵ�
    	StringBuilder json = new StringBuilder();
    	
    	//ԭ�е�
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // �򿪺�URL֮�������
            URLConnection connection = realUrl.openConnection();
//            // ����ͨ�õ���������
//            connection.setRequestProperty("accept", "*/*");
//            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            // ����ʵ�ʵ�����
            connection.setRequestProperty("X-Auth-Code","114116581bbb58a98f819f438c9d8433");
            connection.connect();
//            // ��ȡ������Ӧͷ�ֶ�
//            Map<String, List<String>> map = connection.getHeaderFields();
//            // �������е���Ӧͷ�ֶ�
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // ���� BufferedReader����������ȡURL����Ӧ
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                json.append(line);
            }
        } catch (Exception e) {
            System.out.println("����GET��������쳣��" + e);
            e.printStackTrace();
            return "wrong";
        }
        // ʹ��finally�����ر�������
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return json.toString();
    }
    //opencodeΪ:114116581bbb58a98f819f438c9d8433
    public static void main(String[] args){
    	String s=Get.sendGet("http://121.41.106.89:8010/", "");
        System.out.println(s);
    }
}