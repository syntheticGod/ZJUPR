package data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import data.GetStockName;
import data.NameGetter;
import junit.framework.Assert;

public class TestNameGetter {
	NameGetter nameGetter;
	
	@Before
	public void setUp(){
		nameGetter = new NameGetter();
	}

	@Test
	public void testGetName() {
		String s = nameGetter.getName("601006");
		Assert.assertEquals("股票名获取有问题","大秦铁路",s);
	}

}
