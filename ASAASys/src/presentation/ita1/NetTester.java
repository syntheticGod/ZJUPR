package presentation.ita1;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class NetTester {
	
//	public static void main(String[] args)
//	{
//	
//		System.out.println(NetTest());
//	}
	
	
	public static boolean NetTest()
	{
	boolean ans=false;
	URL url = null;
	try {
	url = new URL("http://www.baidu.com/");
	InputStream in = url.openStream();
	ans=true;
	in.close();
	} catch (IOException e) {
	 
	}
	return ans;
	}
	
	
	
}
