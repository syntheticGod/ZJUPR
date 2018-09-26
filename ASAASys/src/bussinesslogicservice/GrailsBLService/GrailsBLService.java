package bussinesslogicservice.GrailsBLService;

import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;

import vo.GrailsSearchVO;
import vo.GrailsVO;

public interface GrailsBLService {
	
	public ArrayList<GrailsVO>  getGrails(GrailsSearchVO grailsSearch) throws JSONException, ParseException;

}
