package businesslogic.GrailsBL;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;

import junit.framework.Assert;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import vo.GrailsSearchVO;
import vo.GrailsVO;

public class testGrailsBL {
	GrailsBL bl;
	
	@Before
	public void init(){
    	bl=new GrailsBL();
    	
    	
    	
    }
	
	@Test
	public void test() {
		
		//ArrayList<GrailsVO>  getGrails(GrailsSearchVO grailsSearch)
		
		GrailsSearchVO grailsSearch_1=new GrailsSearchVO("2016-02-22", "2016-03-11", 0, 0, 0, 0, 0, 0, 0, 0);
		GrailsSearchVO grailsSearch_2=new GrailsSearchVO("2016-02-22", "2016-03-11", 3000, 3200, 0, 0, 0, 0, 0, 0);
		GrailsSearchVO grailsSearch_3=new GrailsSearchVO("2016-02-22", "2016-03-11", 0, 500, 0, 0, 0, 0, 0, 0);
		ArrayList<GrailsVO> actual_1=null;
		ArrayList<GrailsVO> actual_2=null;
		ArrayList<GrailsVO> actual_3=null;
		try {
			actual_1 = bl.getGrails(grailsSearch_1);
			actual_2 = bl.getGrails(grailsSearch_2);
			actual_3 = bl.getGrails(grailsSearch_3);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		Assert.assertEquals("2016-02-22", actual_1.get(0).getdate());
		Assert.assertEquals("2016-02-22", actual_2.get(0).getdate());
		Assert.assertEquals(0, actual_3.size());
		
		//bl.getGrails(grailsSearch);
	}

}
