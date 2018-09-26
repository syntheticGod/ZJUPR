package businesslogic.StocksBL;

import java.text.ParseException;
import java.util.ArrayList;

import junit.framework.Assert;

import org.json.JSONException;
import org.junit.Test;

import vo.CategoryStatisticsVO;
import vo.RequestCategoryVO;

public class testCategoryStatisticsBL {
	CategoryStatisticsBL bl;
	
	public void init(){
		bl = new CategoryStatisticsBL();
	}
	@Test
	public void testCategoryStatistics() throws JSONException, ParseException{
		init();
		
		CategoryStatisticsVO categorystatisticsvo = null;
		
		ArrayList<RequestCategoryVO> list =new ArrayList<RequestCategoryVO>();
		
		RequestCategoryVO vo1=new RequestCategoryVO("600100", "同方股份");
		RequestCategoryVO vo2=new RequestCategoryVO("600109","国金证券");
		
		list.add(vo1);
		list.add(vo2);
		
		try{
			categorystatisticsvo = bl.CategoryStatistics(list);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals("计算机",bl.CategoryStatistics(list).getCategoryVOList().get(0).getcategory());	
		Assert.assertEquals("600100",bl.CategoryStatistics(list).getCategoryVOList().get(0).getid());
		Assert.assertEquals("国金证券",bl.CategoryStatistics(list).getCategoryVOList().get(1).getname());
		Assert.assertEquals("计算机",bl.CategoryStatistics(list).getRemenVOList().get(0).getcategory());
//		Assert.assertEquals(449523.0,bl.CategoryStatistics(list).getRemenVOList().get(0).getavgvolume());
//		Assert.assertEquals(0.40988132741870037,bl.CategoryStatistics(list).getRemenVOList().get(0).getavgvolumep());
//		Assert.assertEquals(2.28,bl.CategoryStatistics(list).getRemenVOList().get(1).getavgturnover());
//		Assert.assertEquals(0.5123595505617978,bl.CategoryStatistics(list).getRemenVOList().get(1).getavgturnoverp());
		
		
	}
	
	@Test
	public void testGetStcokKind() throws JSONException, ParseException{
		init();
		
		String str1="600100";
		String str2="600109";

		Assert.assertEquals("计算机",bl.GetStockKind(str1));
		Assert.assertEquals("非银金融",bl.GetStockKind(str2));
			
	}
	
	@Test
	public void testGetCategoryDetail(){
		init();
		String str1="计算机";
		String str2="非银金融";
		String str3="公用事业";
		
		ArrayList<String> list =new ArrayList<String>();
		list.add(str1);
		list.add(str2);
		list.add(str3);
		
		Assert.assertEquals("计算机",bl.GetCategoryDetail(list).get(0).getname());
		Assert.assertEquals(1,bl.GetCategoryDetail(list).get(0).getnum());
	    Assert.assertEquals(0.3333333333333333,bl.GetCategoryDetail(list).get(1).getpercent());
		
				}
}
