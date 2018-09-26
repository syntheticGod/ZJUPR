package businesslogic.StocksBL;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;

import po.StockDetailPO;
import presentation.ita1.TimeGetter;
import vo.AtrVO;
import vo.CCIVO;
import vo.ObvVO;
import vo.VrVO;
import data.DataController;
import dataservice.DataControllerService;
import bussinesslogicservice.StocksBLService.StocksBLIndexService;

public class StocksBLIndex implements StocksBLIndexService{
DataControllerService dc = new DataController();
	

	@Override
	public ArrayList<AtrVO> getAtr(String name,int number, String endtime) throws JSONException, ParseException {
		ArrayList<StockDetailPO> stocksPO = new ArrayList<StockDetailPO>();
		//确保返回的数据个数有number个
		int n = 0;
		//
		do{
			stocksPO = dc.getStock(name,TimeGetter.getDayBefore(endtime, n+number+13), endtime);
			n++;
			
		}while(stocksPO.size()!=number+13);
		//存放Number天数的均幅指标值
		ArrayList<AtrVO> result = new ArrayList<AtrVO>();
		for(int i = 0;i<number;i++){
			//当日移动值
			double Tr = 0;
			int count;
			for(count = i;count <= i+13;count++){
				Tr += Double.parseDouble(stocksPO.get(count).gethigh())-Double.parseDouble(stocksPO.get(count).getlow());
			}
			AtrVO temp = new AtrVO();
			//处理日移动值的递归结果保留3位小数点
			DecimalFormat df = new DecimalFormat("0.000");
			String Trtotal=df.format(Tr/14);
			
			
			temp.setAtrnum(Trtotal);
			temp.setday(stocksPO.get(i).getdate());
			temp.setName("sh"+name);
			
			result.add(temp);
		}
		
		return result;
	}

	@Override
	public ArrayList<ObvVO> getObv(String name, int number, String endtime)
			throws JSONException, ParseException {
		ArrayList<StockDetailPO> stocksPO = new ArrayList<StockDetailPO>();
		//确保返回的数据个数有number个
		int n = 0;
		//
		do{
			stocksPO = dc.getStock(name,TimeGetter.getDayBefore(endtime, n+number), endtime);
			n++;
			
		}while(stocksPO.size()!=number);
		//存放Number天数的能量潮值
		ArrayList<ObvVO> result = new ArrayList<ObvVO>();
		
		//设置Obv基值
		ObvVO firstday = new ObvVO();
		firstday.setday(stocksPO.get(0).getdate());
		firstday.setName(name);
		firstday.setObv(stocksPO.get(0).getvolume());
		result.add(firstday);
		for(int i = 1;i<number;i++){
			//每日obv值
			double obvtemp;
			//当日股票上涨时Obv基值加上成交量
			if(Double.parseDouble(stocksPO.get(i).getclose())
				>Double.parseDouble(stocksPO.get(i).getopen())){
				obvtemp = Double.parseDouble(stocksPO.get(0).getvolume())+
						Double.parseDouble(stocksPO.get(i).getvolume());
			}
			//股票跌时Obv基值减去当日成交量
			else{
				obvtemp = Double.parseDouble(stocksPO.get(0).getvolume()) -
						Double.parseDouble(stocksPO.get(i).getvolume());
			}
			
			ObvVO temp = new ObvVO();		
					
					
			temp.setObv(String.valueOf(obvtemp));
			temp.setday(stocksPO.get(i).getdate());
			temp.setName("sh"+name);
					
			result.add(temp);
		}
				
		return result;
		
	}
	
	@Override
	public ArrayList<VrVO> getVr(String name, int number, String endtime)
			throws JSONException, ParseException {
		ArrayList<StockDetailPO> stocksPO = new ArrayList<StockDetailPO>();
		//确保返回的数据个数有number个  Vr容量比率计算周期为12
		int n = 0;
		//
		do{
			stocksPO = dc.getStock(name,TimeGetter.getDayBefore(endtime, n+number+11), endtime);
			n++;
			
		}while(stocksPO.size()!=number+11);
		//存放Number天数的均幅指标值
		ArrayList<VrVO> result = new ArrayList<VrVO>();
		for(int i = 0;i<number;i++){
			//Up：一个周期内上升日的成交量总和 down：一个周期内下跌日成交量总和
			double Up = 0;
			double Down = 0;
			for(int count = i;count <= i+11;count++){
				//如果当日上涨 统计到Up
				if(Double.parseDouble(stocksPO.get(count).getclose())
					>Double.parseDouble(stocksPO.get(count).getopen())){
					Up += Double.parseDouble(stocksPO.get(count).getvolume());
				}
				//如果当日下跌 统计到down
				else{
					Down += Double.parseDouble(stocksPO.get(count).getvolume());
				}
			}
			
			VrVO temp = new VrVO();
			
			//处理日移动值的递归结果保留1位小数点百分比
			DecimalFormat df = new DecimalFormat("0.0");
			String Vrtotal=df.format(Up/Down*100);
			
			temp.setVr(Vrtotal);;
			temp.setday(stocksPO.get(i).getdate());
			temp.setName("sh"+name);
			
			result.add(temp);
		}
		
		return result;
	}
	
	@Override
	public ArrayList<CCIVO> getCCI(String name, int number, String endtime)
			throws JSONException, ParseException {
		ArrayList<StockDetailPO> stocksPO = new ArrayList<StockDetailPO>();
		//确保返回的数据个数有number个
		int n = 0;
		//
		do{
			stocksPO = dc.getStock(name,TimeGetter.getDayBefore(endtime, n+number), endtime);
			n++;
			
		}while(stocksPO.size()!=number);
		
		//存放当日的股票代表价格TP：（最高价+最低价+收盘价）/3
		double[] TP = new double[number];
		for(int i = 0;i<number;i++){
			TP[i] = (Double.parseDouble(stocksPO.get(i).gethigh())
			+Double.parseDouble(stocksPO.get(i).getlow())
			+Double.parseDouble(stocksPO.get(i).getclose()))/3;			
		}
		
		//计算number天里TP的简单移动平均值TPSMA
		double TPSMA = 0;
		for(int i = 0;i<number;i++)TPSMA += TP[i]/number;
		
		//计算number天里的平均绝对偏差SD
		double sd = 0;
		for(int i = 0;i<number;i++) sd += Math.abs(TP[i]-TPSMA)/n;
		
		//计算number天里的CCI值
		ArrayList<CCIVO> result = new ArrayList<CCIVO>();
		for(int i = 0;i<number;i++){
			CCIVO temp = new CCIVO();
			
			DecimalFormat df = new DecimalFormat("0.000");
			String CCIone=df.format((TP[i] - TPSMA)/(sd*0.015));
			temp.setCCI(CCIone);
			temp.setday(stocksPO.get(i).getdate());
			temp.setName(name);
			result.add(temp);
		}
		return result;
	}
	
	public static void main(String[] args) throws JSONException, ParseException{
		StocksBLIndexService drive = new StocksBLIndex();
//		ArrayList<AtrVO> test = drive.getAtr("600000", 46, "2015-10-08");
//		System.out.println("结果是:"+test.get(45).getAtrnum());
//		ArrayList<ObvVO> test = drive.getObv("600300", 50, "2015-10-08");
//		System.out.println("obv result:"+test.get(49).getObv());
//		ArrayList<VrVO> test = drive.getVr("600000", 14, "2015-03-01");
//		System.out.println("Vr result : "+test.get(13).getVr());
		ArrayList<CCIVO> test4 = drive.getCCI("600000", 40,"2015-10-07");
		System.out.println("CCI result: "+ test4.get(39).getCCI());
	}



}
