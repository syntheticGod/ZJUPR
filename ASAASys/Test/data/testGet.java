package data;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class testGet {
	
	@Test
	public void testResult(){
		String rel = Get.sendGet("http://121.41.106.89:8010/", "");
        Assert.assertEquals("返回信息错误", "{\"status\": \"ok\", \"data\": \"Welcome AnyQuant API, Visit Doc For Usage\"}", rel);
	}

}
