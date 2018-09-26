package vo;

import java.util.ArrayList;

public class CategoryStatisticsVO {
	private ArrayList<CategoryVO> categoryvolist;
	private ArrayList<RemenVO> remenvolist;
	
    public CategoryStatisticsVO(ArrayList<CategoryVO> categoryvolist,ArrayList<RemenVO> remenvolist){
    	this.categoryvolist=categoryvolist;
    	this.remenvolist=remenvolist;
    }
    
    public ArrayList<CategoryVO> getCategoryVOList(){
    	return categoryvolist;
    }
    
    public ArrayList<RemenVO> getRemenVOList(){
    	return remenvolist;
    }
}
