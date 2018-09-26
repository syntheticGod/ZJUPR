package businesslogic.StocksBL;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;

import po.StockDetailPO;
import data.DataController;
import dataservice.DataControllerService;
import vo.CategoryDetailVO;
import vo.CategoryStatisticsVO;
import vo.CategoryVO;
import vo.RemenVO;
import vo.RequestCategoryVO;
import bussinesslogicservice.StocksBLService.CategoryStatisticsBLService;

public class CategoryStatisticsBL implements CategoryStatisticsBLService{

	@Override
	public CategoryStatisticsVO CategoryStatistics(
			ArrayList<RequestCategoryVO> list) throws JSONException, ParseException {
		// TODO Auto-generated method stub
		
		
		DataControllerService dc = new DataController();
		
		
		ArrayList<CategoryVO> categoryvolist = new ArrayList<CategoryVO>();
		
		//System.out.println(list.size());
		
		for(int i=0;i<list.size();i++){
			CategoryVO categoryvo =new CategoryVO(list.get(i).getid(), list.get(i).getname(), dc.getStockKind(list.get(i).getid()).getkind());
		
			categoryvolist.add(categoryvo);
		}
		
		//System.out.print(categoryvolist);
		
		ArrayList<String> categorylist = new ArrayList<String>();
		
		
		for(int m=0;m<list.size();m++){
			if(!categorylist.contains(categoryvolist.get(m).getcategory())){
				categorylist.add(categoryvolist.get(m).getcategory());
			}
		}
		
		ArrayList<RemenVO> remenvolist = new ArrayList<RemenVO>();
		
		String category[]= new String[categorylist.size()];
		long avgvolume[]= new long[categorylist.size()];
		double avgvolumep[]= new double[categorylist.size()]; 
		double avgturnover[]= new double[categorylist.size()];
		double avgturnoverp[]= new double[categorylist.size()];
		
		
		for(int n=0;n<categorylist.size();n++){
			
			category[n]=categorylist.get(n);
			
			//System.out.print(category[n]);
//			avgvolume[n]="";
//			avgturnover[n]="";
//			avgvolumep[n]="";
//			avgturnoverp[n]="";
			
			long av=avgvolume[n];
		
			double at=avgturnover[n];
			
			int count =0;
			
			for(int k=0;k<categoryvolist.size();k++){
				
				if(categoryvolist.get(k).getcategory() == categorylist.get(n)){
					count++;
					
					ArrayList<StockDetailPO> stocksPO = dc.getNotimeStock(categoryvolist.get(k).getid());
				  
					//System.out.println(stocksPO.size());
					
					for(int j=0;j<stocksPO.size();j++){
						
						//System.out.println(stocksPO.get(j).getvolume());
						av+=Double.parseDouble(stocksPO.get(j).getvolume())/30.0;
						
						at+=Double.parseDouble(stocksPO.get(j).getturnover())/30.0;
						}
				}
				
			}
			av=av/count;
			at=at/count;
			DecimalFormat df = new DecimalFormat("0.00");
			avgvolume[n]=av;
			avgturnover[n]=Double.parseDouble(df.format(at));
			
			
		}
		
		
		for(int n=0;n<categorylist.size();n++){
			double avp=avgvolumep[n];
			double atp=avgturnoverp[n];
			
			double sumofav=0;
			double sumofat=0;
			
			for(int m=0;m<categorylist.size();m++){
				sumofav+=avgvolume[m];
				sumofat+=avgturnover[m];
			}
			
			avp=avgvolume[n]/sumofav;
			atp=avgturnover[n]/sumofat;
			
			avgvolumep[n]=avp;
			avgturnoverp[n]=atp;
			
			//System.out.println(avgvolume[n]);
			
		}
		
		
		
		for(int i=0;i<categorylist.size();i++){
			RemenVO temp=new RemenVO(category[i],avgvolume[i], avgvolumep[i], avgturnover[i], avgturnoverp[i]);
			
			remenvolist.add(temp);
		}
		CategoryStatisticsVO categorystatisticsvo = new CategoryStatisticsVO(categoryvolist, remenvolist);
	
		return categorystatisticsvo;
	}
	
	public static void main(String args[]) throws JSONException, ParseException{
		CategoryStatisticsBL test=new CategoryStatisticsBL();
		
		String str1="食品饮料";
		String str2="采掘";//计算机
		String str3="轻工制造";
		String str4="采掘";
		
		
		
		
		
		
		
		
		
		
		
	    ArrayList<String> list =new ArrayList<String>();
	    list.add("计算机");
	    list.add("食品饮料");
	    list.add("交通运输");
	    list.add("纺织服装");
	    list.add("银行");
	    list.add("采掘");
	    list.add("有色金属");
	    list.add("化工");
	    list.add("汽车");
	    list.add("商业贸易");
	    list.add("公用事业");
	    list.add("轻工制造");
	    list.add("采掘");
		System.out.print(test.GetCategoryDetail(list).get(0).getpercent());
		System.out.println(test.GetCategoryDetail(list).get(5).getname());
		System.out.println(test.GetCategoryDetail(list).get(5).getnum());
		System.out.println(test.GetCategoryDetail(list).get(5).getpercent());
		System.out.print(test.GetCategoryDetail(list).size());
	}

	@Override
	public String GetStockKind(String id) throws JSONException, ParseException {
		// TODO Auto-generated method stub
		String result;
		DataControllerService dc =new DataController();
		result = dc.getStockKind(id).getkind();
		return result;
	}

	@Override
	public ArrayList<CategoryDetailVO> GetCategoryDetail(ArrayList<String> list) {
		// TODO Auto-generated method stub
		 ArrayList<CategoryDetailVO> result = new  ArrayList<CategoryDetailVO>();
		 
		ArrayList<String> categorylist = new ArrayList<String>();
		for(int i =0;i<list.size();i++){
			if(!categorylist.contains(list.get(i))){
				categorylist.add(list.get(i));
			}
		}
		 int num[]=new int[categorylist.size()];
		 double percent[]=new double[categorylist.size()];
		
		 for(int k=0;k<categorylist.size();k++){
			 for(int j =0;j<list.size();j++){
				 if(categorylist.get(k).equals(list.get(j))){
					 num[k]++;
					 }
				 }
			 }
		 for(int m=0;m<categorylist.size();m++){
			 String str1=num[m]+"";
			 String str2=list.size()+"";
			 percent[m]= Double.parseDouble(str1)/Double.parseDouble(str2);
		 }
		 
		 for(int n=0;n<categorylist.size();n++){
			 CategoryDetailVO temp =new CategoryDetailVO(categorylist.get(n),num[n],percent[n]);
			 result.add(temp);
		 }
		 
		return result;
	}

}
