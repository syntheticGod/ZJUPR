package businesslogic.GrailsBL;

import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;

import po.BenchMarkDetailPO;
import data.DataController;
import dataservice.DataControllerService;
import vo.GrailsSearchVO;
import vo.GrailsVO;
import bussinesslogicservice.GrailsBLService.GrailsBLService;




public class GrailsBL implements GrailsBLService {

	public ArrayList< GrailsVO> getGrails(GrailsSearchVO grailsSearch) throws JSONException, ParseException {
		// TODO Auto-generated method stub
		DataControllerService dc =new DataController();
	    
	    ArrayList< GrailsVO>  grailssearch = new ArrayList< GrailsVO>();
	    
	    ArrayList<BenchMarkDetailPO> benchmark = dc.getBench(grailsSearch.getBeginDate(), grailsSearch.getEndDate());
	  
	    if(benchmark.size() == 0){
	    	
	    }else{
	    	for(int i =  0;i<benchmark.size();i++){
	    		GrailsVO temp = new GrailsVO(benchmark.get(i).getdate(),benchmark.get(i).getopen(),benchmark.get(i).getclose(),benchmark.get(i).gethigh(),benchmark.get(i).getlow());
	    		
	   		if( (Double.parseDouble(temp.getopen())<=grailsSearch.getKaipanMax() && Double.parseDouble(temp.getopen())>= grailsSearch.getKaipanMin() )||( grailsSearch.getKaipanMax()==0 &&grailsSearch.getKaipanMin()==0)){
	    		if( (Double.parseDouble(temp.getclose())<=grailsSearch.getShoupanMax() && Double.parseDouble(temp.getclose())>= grailsSearch.getShoupanMin() )||( grailsSearch.getShoupanMax()==0 &&grailsSearch.getShoupanMin()==0)){
	    				if( (Double.parseDouble(temp.gethigh())<=grailsSearch.getMaxMax() && Double.parseDouble(temp.gethigh())>= grailsSearch.getMaxMin() )||( grailsSearch.getMaxMin()==0 &&grailsSearch.getMaxMax()==0)){
	    					if( (Double.parseDouble(temp.getlow())<=grailsSearch.getMinMax() && Double.parseDouble(temp.getlow())>= grailsSearch.getMinMin() )||( grailsSearch.getMinMax()==0 &&grailsSearch.getMinMin()==0)){
	    						
	    						grailssearch.add(temp);
	    					}
	    				}
	    			}    			
	    		}  		
	    	} 	
	    }    
		return grailssearch;
		
	}

}
