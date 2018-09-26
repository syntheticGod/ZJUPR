package data;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import data.Get;
import data.GetStockDetail;
import junit.framework.Assert;
public class testGetStockKind {
	
	@Test
	public void testGetKind() throws JSONException{
		Assert.assertEquals("错误", "计算机", GetStockKind.GetTonglianKind("600100").getkind());
		Assert.assertEquals("错误", "银行", GetStockKind.GetTonglianKind("600000").getkind());
		Assert.assertEquals("错误", "交通运输", GetStockKind.GetTonglianKind("600004").getkind());
	}
	

}
