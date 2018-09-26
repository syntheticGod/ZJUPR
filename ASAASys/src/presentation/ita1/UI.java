package presentation.ita1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.html.ImageView;

import java.awt.Font;
import java.awt.Rectangle;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;

import org.json.JSONException;

import presentation.ita2.Atr_BasePanel;
import presentation.ita2.BIAS_BasePanel;
import presentation.ita2.CCI_BasePanel;
import presentation.ita2.DMI_BasePanel;
import presentation.ita2.FrLoadingThread;
import presentation.ita2.KChart_BasePanel;
import presentation.ita2.KDJ_BasePanel;
import presentation.ita2.LoadingFrame;
import presentation.ita2.Obv_BasePanel;
import presentation.ita2.PSY_BasePanel;
import presentation.ita2.Piechart_BasePanel;
import presentation.ita2.RSI_BasePanel;
import presentation.ita2.VolumeChart_BasePanel;
import presentation.ita2.Vr_BasePanel;
import businesslogic.GrailsBL.GrailsBL;
import businesslogic.StocksBL.CategoryStatisticsBL;
import businesslogic.StocksBL.StocksBL;
import bussinesslogicservice.GrailsBLService.GrailsBLService;
import bussinesslogicservice.StocksBLService.CategoryStatisticsBLService;
import bussinesslogicservice.StocksBLService.StocksBLService;
import vo.*;
import data.NameGetter;
import data.ReadStocks_resolved;
import dataservice.StockNameGetService;



public class UI extends JFrame {

	private JPanel contentPane;
	private JPanel panel_Us;
	private JPanel panel_input_stocks;
	private JPanel panel_input_grails;
	private JPanel panel_present_stocks;
	private JPanel panel_present_grails;
	private JPanel panel_input_StocksSearch;
	private JPanel panel_present_stocks_Details;
	private JPanel panel_function;
	private JPanel panel_function_zhibiao;
	private JPanel panel_function_hangye;
	private JPanel panel_Head_zhibiao;
	private JPanel panel_Base_zhibiao;
	private JPanel panel_Base_hangye;
	private JPanel WaitPanel;	
	private JLabel HeadLabel;	
	private KChart_BasePanel KchartPanel;
	private VolumeChart_BasePanel VolumeChartPanel;
	private BIAS_BasePanel BIASPanel;
	private PSY_BasePanel PSYPanel;
	private Atr_BasePanel AtrPanel;
	private Obv_BasePanel ObvPanel;
	private Vr_BasePanel VrPanel;
	private CCI_BasePanel CCIPanel;
	private KDJ_BasePanel KDJPanel;
	private DMI_BasePanel DMIPanel;
	private RSI_BasePanel RSIPanel;
	private JComboBox comboBox;
	private int hasSelected;
	Piechart_BasePanel Hange_num;
	Piechart_BasePanel Hange_volume;
	Piechart_BasePanel Hange_turnOver;
	Piechart_BasePanel Hange_Remen;
	private boolean StockhasChanged[];
	private JTable table;
	private JTextField textField;
    private DefaultTableModel stocksPresentBaseModel;
    private DefaultTableModel stocksPresentDetailsModel;
    private DefaultTableModel grailsPresentBaseModel;
    private DefaultTableCellRenderer renderer;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTable table_1;
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;
    private JTextField textField_14;
    private JTextField textField_15;
    private JTextField textField_16;
    private JTextField textField_17;
    private JTextField textField_18;
    private JTextField textField_19;
    private JTextField textField_20;
    private JTable table_2;
    private JLabel lblNewLabel_3;
    private JLabel remenHangye;
    private JLabel remenZhishu;
    private String numOfStock;
    private String nameOfStock;
    private boolean loadingFinish;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

//					UI frame = new UI();
//					frame.setVisible(true);

					FrLoadingThread f=new FrLoadingThread();
					f.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	
	
	
	
	
	
	
	/**
	 * 内部类：用于显示等待界面
	 * @author gc
	 *
	 */
	class WaitingThread extends Thread{ 
		   

		public void run() {
	       

         boolean notstarted=true;
	            for(long k= 0; k <100000000;k++){
	            	try {
	                    Thread.sleep(200);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();  
	                }
	            	if(!loadingFinish){
	            		if(notstarted){
	            			
		            		WaitPanel.setVisible(true);
		   	    		    panel_input_StocksSearch.setVisible(false);
				    		panel_present_stocks_Details.setVisible(false);		
				    		KchartPanel.setVisible(false);
				    		VolumeChartPanel.setVisible(false);
				    		notstarted=false;
	            		}

	            	}		
	            	else{
	            		
	            		WaitPanel.setVisible(false);
	    	    		panel_Head_zhibiao.setVisible(true);
	    	    		panel_Base_zhibiao.setVisible(true);
	            		break;
	            	}
	            		
	            }//循环体    
	        
	    }
	}
	
	class LoadingThread extends Thread{ 
		   private int task;

		   LoadingThread(){
			   this.task=0;
		   }
		   
		   
		public void run() {
			switch (task){
			case 0:
				BIASPanel.DataInit(numOfStock, TimeGetter.getToday());
				BIASPanel.labelInit();
				BIASPanel.setVisible(true);
				break;
			case 1:
				PSYPanel.DataInit(numOfStock, TimeGetter.getToday());
				PSYPanel.labelInit();
				PSYPanel.setVisible(true);
				break;
			case 2:
				AtrPanel.DataInit(numOfStock, TimeGetter.getToday());
				AtrPanel.labelInit();
				AtrPanel.setVisible(true);
				break;
			case 3:
				ObvPanel.DataInit(numOfStock, TimeGetter.getToday());
				ObvPanel.labelInit();
				ObvPanel.setVisible(true);
				break;
			case 4:
				 VrPanel.DataInit(numOfStock, TimeGetter.getToday());
				 VrPanel.labelInit();
				 VrPanel.setVisible(true);
				break;
			case 5:
				CCIPanel.DataInit(numOfStock, TimeGetter.getToday());
				CCIPanel.labelInit();
				CCIPanel.setVisible(true);
				break;
			case 6:
				DMIPanel.DataInit(numOfStock, TimeGetter.getToday());
				DMIPanel.labelInit();
				DMIPanel.setVisible(true);
				break;
			case 7:
				KDJPanel.DataInit(numOfStock, TimeGetter.getToday());
				KDJPanel.labelInit();
				KDJPanel.setVisible(true);
				break;
			case 8:
				 RSIPanel.DataInit(numOfStock, TimeGetter.getToday());
				 RSIPanel.labelInit();
				 RSIPanel.setVisible(true);
				break;
			}

		 StockhasChanged[0]=false;
		 loadingFinish=true;	
	               
	        
	    }
		
		void settask(int i){
			this.task=i;
		}
	}
	
	
	
	
	/**
	 * Create the frame.
	 */
	public UI() {
		loadingFinish=false;
		StockhasChanged=new boolean[4];
		hasSelected=0;
	for(int i=0;i<4;i++){
		StockhasChanged[i]=true;
	}
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1280, 720);
		this.setResizable(false);
		this.setTitle("ASAA");
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		ImageIcon icon=new ImageIcon("background.jpg");
	    //Image im=new Image(icon);
	    //将图片放入label中
	    JLabel label=new JLabel(icon);
	    
	    //设置label的大小
	    label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
	    
	    getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//重要！！！！！
	    
	    //contentPane.add(label);
	    contentPane.setOpaque(false);
	    
	    //******************************************************************************************************以上为设置背景
	    stocksPresentBaseModel = new DefaultTableModel(0, 11){
	    	  public boolean isCellEditable(int row,int column)
	    	  {
	    	   return false;
	    	  }
	    	  public String getColumnName(int columnIndex){
	    		  if(columnIndex == 0) return "股票代码"; 
	    		  if(columnIndex == 3) return "日期";
	    		  if(columnIndex == 6) return "最高价";
	    		  if(columnIndex == 7) return "最低价";
	    		  if(columnIndex == 5) return "收盘价";
	    		  if(columnIndex == 8) return "成交量(百股)";
	    		  if(columnIndex == 9) return "换手率";
	    		  if(columnIndex == 10) return "市净率";
	    		  if(columnIndex == 4) return "开盘价";
	    		  if(columnIndex == 1) return "股票名称"; 
	    		  if(columnIndex == 2) return "行业"; 
				return null;
	    		  
	    		  
	    	  }
	    	 };
	    	//******************************************************************************************************以上为股票基本展示表格组件
	    	 stocksPresentDetailsModel = new DefaultTableModel(0, 8){
		    	  public boolean isCellEditable(int row,int column)
		    	  {
		    	   return false;
		    	  }
		    	  public String getColumnName(int columnIndex){
		    		  if(columnIndex == 0) return "日期"; 
		    		  if(columnIndex == 3) return "最高价";
		    		  if(columnIndex == 4) return "最低价";
		    		  if(columnIndex == 2) return "收盘价";
		    		  if(columnIndex == 5) return "成交量(百股)";
		    		  if(columnIndex == 6) return "换手率";
		    		  if(columnIndex == 7) return "市净率";
		    		  if(columnIndex == 1) return "开盘价";
					return null;
		    		  
		    		  
		    	  }
		    	 };
	    //******************************************************************************************************以上为股票详细展示表格组件
		    	 grailsPresentBaseModel=new DefaultTableModel(0, 5){
			    	  public boolean isCellEditable(int row,int column)
			    	  {
			    	   return false;
			    	  }
			    	  public String getColumnName(int columnIndex){
			    		  if(columnIndex == 0) return "日期"; 
			    		  if(columnIndex == 1) return "开盘价";
			    		  if(columnIndex == 2) return "收盘价";
			    		  if(columnIndex == 3) return "最高价";
			    		  if(columnIndex == 4) return "最低价";
			    		 
						return null;
			    		  
			    		  
			    	  }
			    	 };
		 //******************************************************************************************************以上为大盘基本展示表格组件 
			    	 renderer=new DefaultTableCellRenderer();
			          renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			          renderer.setOpaque(false);
	    

	      
			          KchartPanel = new KChart_BasePanel();
			          KchartPanel.setBounds(279, 0, 995, 690);
					  contentPane.add(KchartPanel);
					  KchartPanel.setVisible(false);
			    	 
					  VolumeChartPanel=new VolumeChart_BasePanel();
					  VolumeChartPanel.setBounds(279, 0, 995, 690);
					  contentPane.add(VolumeChartPanel);
					  VolumeChartPanel.setVisible(false);	  
					  
					  
					  panel_Head_zhibiao=new JPanel();
					  panel_Head_zhibiao.setVisible(false);
					  panel_Head_zhibiao.setLayout(null);
					  panel_Head_zhibiao.setOpaque(false);
					  panel_Head_zhibiao.setBounds(279, 0, 995, 70);
					  contentPane.add(panel_Head_zhibiao);
					  
					  comboBox = new JComboBox();
					  //comboBox.setForeground(Color.WHITE);
					  comboBox.setFont(new Font("微软雅黑", Font.BOLD, 13));

					  comboBox.setModel(new DefaultComboBoxModel(new String[] {"乖离率", "心理线", "均幅指标", "能量潮", "容量比率", "顺势指标", "趋向指标", "随机指标", "相对强弱指标"}));
					  comboBox.setBounds(38, 26, 84, 33);
					  
					  comboBox.setOpaque(false);
					  panel_Head_zhibiao.add(comboBox);
					  
					  comboBox.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							int Selected=comboBox.getSelectedIndex();
							if(hasSelected!=Selected){
								Panel_zhibiao_reboot();
							
								loadingFinish=false;
				    			WaitingThread t1 = new WaitingThread();	    			
				    			LoadingThread t2=new LoadingThread();	 
				    			t2.settask(Selected);
				    			t1.start();
				    			t2.start();
				    			hasSelected=Selected;
							}

						}  
					  });
					  
					  HeadLabel = new JLabel("股票代码名字");
					  HeadLabel.setForeground(Color.WHITE);
					  HeadLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
					  HeadLabel.setBounds(381, 11, 263, 49);
					  panel_Head_zhibiao.add(HeadLabel);
					  
					  panel_Base_zhibiao=new JPanel();
					  panel_Base_zhibiao.setBounds(279, 70, 995, 620);
					  panel_Base_zhibiao.setOpaque(false);
					  panel_Base_zhibiao.setVisible(false);
					  panel_Base_zhibiao.setLayout(null);
					  contentPane.add(panel_Base_zhibiao);
					  
					  JScrollPane pane = new JScrollPane();
					  panel_Base_zhibiao.add(pane);
					  pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
					  pane.setBounds(0, 0, 995, 620);
					  pane.setOpaque(false);
					  pane.getViewport().setOpaque(false);
					  pane.setSize(995, 620);  //关键！这里要用setSize设定固定大小！！！
					  
					  JPanel layerPane = new JPanel();
					  layerPane.setLayout(null);
					  layerPane.setPreferredSize(new Dimension(975, 690));
					  layerPane.setOpaque(false);
					 //关键！可以设定大些或设成和JScrollPane同样大小，这样如果内部空间位置超出设置的大小就会根据位置显示滚动条，  注意不能用setSize（否则滚动条不显示）！
					  pane.setViewportView(layerPane);
					  //之后在layerPane上加新的东西
					  
					  
					   BIASPanel=new BIAS_BasePanel();					  
					   BIASPanel.setBounds(0, 0, 995, 690);
					   layerPane.add(BIASPanel);
					   BIASPanel.setVisible(false);
					   
					   
					   PSYPanel=new PSY_BasePanel();
					   PSYPanel.setBounds(0, 0, 995, 690);
					   layerPane.add(PSYPanel);
					   PSYPanel.setVisible(false);
					   
					   AtrPanel=new Atr_BasePanel();
					   AtrPanel.setBounds(0, 0, 995, 690);
					   layerPane.add(AtrPanel);
					   AtrPanel.setVisible(false);
					   
					   ObvPanel=new  Obv_BasePanel();
					   ObvPanel.setBounds(0, 0, 995, 690);
					   layerPane.add(ObvPanel);
					   ObvPanel.setVisible(false);
					   
					   VrPanel=new Vr_BasePanel();
					   VrPanel.setBounds(0, 0, 995, 690);
					   layerPane.add(VrPanel);
					   VrPanel.setVisible(false);
					   
					    CCIPanel=new CCI_BasePanel();
					    CCIPanel.setBounds(0, 0, 995, 690);
					    layerPane.add(CCIPanel);
					    CCIPanel.setVisible(false);
					    
					    DMIPanel=new  DMI_BasePanel();
					    DMIPanel.setBounds(0, 0, 995, 690);
					    layerPane.add(DMIPanel);
					    DMIPanel.setVisible(false);
					    
					    KDJPanel=new KDJ_BasePanel ();
					    KDJPanel.setBounds(0, 0, 995, 690);
					    layerPane.add(KDJPanel);
					    KDJPanel.setVisible(false);
					    
					    RSIPanel=new RSI_BasePanel();
					    RSIPanel.setBounds(0, 0, 995, 690);
					    layerPane.add(RSIPanel);
					    RSIPanel.setVisible(false);
           //******************************************************************************************************	 以上为指标面板
						  panel_Base_hangye=new JPanel();
						  panel_Base_hangye.setBounds(279, 0, 995, 690);
						  panel_Base_hangye.setOpaque(false);
						  panel_Base_hangye.setVisible(false);
						  panel_Base_hangye.setLayout(null);
						  contentPane.add(panel_Base_hangye);
						  
						  JScrollPane pane_hangye = new JScrollPane();
						  panel_Base_hangye.add(pane_hangye);
						  pane_hangye.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
						  pane_hangye.setBounds(0, 0, 995, 690);
						  pane_hangye.setOpaque(false);
						  pane_hangye.getViewport().setOpaque(false);
						  pane_hangye.setSize(995, 690);  //关键！这里要用setSize设定固定大小！！！
						  
						  JPanel layerPane_hangye = new JPanel();
						  layerPane_hangye.setPreferredSize(new Dimension(975, 2476));
						  layerPane_hangye.setOpaque(false);	
						  layerPane_hangye.setLayout(null);
						  pane_hangye.setViewportView(layerPane_hangye);
					    
						  Hange_num=new Piechart_BasePanel();
						  Hange_num.setBounds(0, 0, 995, 600);
						  layerPane_hangye.add( Hange_num);
						  
						  Hange_volume=new Piechart_BasePanel();
						  Hange_volume.setBounds(0, 601, 995, 600);
						  layerPane_hangye.add( Hange_volume);
					    
						  Hange_turnOver=new  Piechart_BasePanel();
						  Hange_turnOver.setBounds(0, 1202, 995, 600);
						  layerPane_hangye.add( Hange_turnOver);
					    
						   Hange_Remen=new Piechart_BasePanel();
						   Hange_Remen.setBounds(0, 1803, 995, 600);
						   layerPane_hangye.add( Hange_Remen);
						   
					    
						   remenZhishu = new JLabel("热门指数=（行业平均换手率所占百分比+行业平均成交量百分比）*50");						   
						   remenZhishu.setForeground(Color.WHITE);
						   remenZhishu.setFont(new Font("微软雅黑", Font.BOLD, 20));
						   remenZhishu.setBounds(0, 2404, 950, 35);
						   layerPane_hangye.add(remenZhishu);
					    
						   remenHangye = new JLabel("统计得最热门行业为：");
						   remenHangye.setForeground(Color.WHITE);
						   remenHangye.setFont(new Font("微软雅黑", Font.BOLD, 20));
						   remenHangye.setBounds(0, 2440, 950, 35);
						   layerPane_hangye.add(remenHangye);
			//*****************************************************************************************************以上为行业统计面板
					    WaitPanel = new JPanel();
						WaitPanel.setBounds(0, 0, 1274, 690);
						contentPane.add(WaitPanel);
						WaitPanel.setVisible(false);						
						WaitPanel.setSize( 1274, 690);
						WaitPanel.setOpaque(false);		
						WaitPanel.setLayout(null);
						JLabel WaitLabel = new JLabel("获取数据中，请稍候……");
						WaitLabel.setForeground(new Color(255, 255, 255));
						WaitLabel.setFont(new Font("楷体", Font.BOLD, 30));
						WaitLabel.setBounds(550, 202, 508, 101);
					    WaitPanel.add(WaitLabel);
					    
					    
					    
        panel_function = new JPanel();
	    panel_function.setForeground(Color.WHITE);
	    panel_function.setBounds(0, 170, 279, 520);
	    contentPane.add(panel_function);
	    panel_function.setLayout(null);
	    panel_function.setOpaque(false);//透明
	    
	   
	    panel_function_zhibiao= new JPanel();
		panel_function_zhibiao.setVisible(false);
		contentPane.add(panel_function_zhibiao);
	    panel_function_zhibiao.setBounds(0, 170, 279, 520);	    
	    panel_function_zhibiao.setLayout(null);
	    panel_function_zhibiao.setOpaque(false);//透明
	    
	    panel_function_hangye=new JPanel();
	    panel_function_hangye.setVisible(false);
		contentPane.add(panel_function_hangye);
		panel_function_hangye.setBounds(0, 170, 279, 520);	    
		panel_function_hangye.setLayout(null);
		panel_function_hangye.setOpaque(false);//透明
	    
	    
	    JButton Button_Stock1 = new JButton("");
	    Button_Stock1.setFont(new Font("楷体", Font.BOLD, 24));
	    Button_Stock1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		
	    		//*******************************************************************************************************
	    		//要加入下层的传入股票的具体信息,不用搜索，用默认最近一个月的方法
	    		
	    		if(NetTester.NetTest()){
	    			StocksBLService bl=new StocksBL();
		    		ArrayList<StocksVO> detailList=null;
		    		
		    		try {
		    			detailList=bl.getDetailsOfStock(numOfStock);
		    			
		    			setStocksDetails(detailList);
		    			
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		
		    		
		    		
		    		lblNewLabel_3.setText(nameOfStock+"("+numOfStock+")"+"的历史交易记录");
		    		
		    		 panel_input_StocksSearch.setVisible(true);
		    		panel_present_stocks_Details.setVisible(true);
		    		
		    		KchartPanel.setVisible(false);
		    		VolumeChartPanel.setVisible(false);
		    		panel_Head_zhibiao.setVisible(false);
		    		panel_Base_zhibiao.setVisible(false);
	    		}
	    		else{
	    			JOptionPane.showMessageDialog(null, "网路链接中断，请检查网路！","", JOptionPane.ERROR_MESSAGE);
	    		}
	    		
	    	
	    	}
	    });
	    buttonSet(Button_Stock1,"交易记录.png");
	    Button_Stock1.setBounds(61, 24, 160, 46);
	    panel_function_zhibiao.add(Button_Stock1);
		//**************************************************************
	    JButton Button_Stock2 = new JButton("");
	    Button_Stock2.setFont(new Font("楷体", Font.BOLD, 24));
	    Button_Stock2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	
	    		if(StockhasChanged[0]){
	    			loadingFinish=false;
	    			WaitingThread t1 = new WaitingThread();	    			
	    			LoadingThread t2=new LoadingThread();	 
	    			t2.settask(0);
	    			t1.start();
	    			t2.start();
	    		}
	    		
	    			panel_input_StocksSearch.setVisible(false);
		    		panel_present_stocks_Details.setVisible(false);
		    		
		    		KchartPanel.setVisible(false);
		    		VolumeChartPanel.setVisible(false);
	    		panel_Head_zhibiao.setVisible(true);
	    		panel_Base_zhibiao.setVisible(true);
	    			
	    		
	    		 
	    	}
	    });
	    buttonSet( Button_Stock2,"各项指标.png");
	    Button_Stock2.setBounds(61, 83, 160, 46);
	    panel_function_zhibiao.add(Button_Stock2);
	    
	    JButton Button_Stock3 = new JButton("");
	    Button_Stock3.setFont(new Font("楷体", Font.BOLD, 24));
	    Button_Stock3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	  
	    		
	    		
	    		if(NetTester.NetTest()){
	    			
	    			if(StockhasChanged[1]){
	    				KchartPanel.DataInit(numOfStock, nameOfStock, TimeGetter.getToday());
		    			KchartPanel.labelInit();
		    			StockhasChanged[1]=false;
	    			}
	    			
	    			KchartPanel.setVisible(true);
	   
	    			
	    			 panel_input_StocksSearch.setVisible(false);
			         panel_present_stocks_Details.setVisible(false);
			         VolumeChartPanel.setVisible(false);
			         panel_Head_zhibiao.setVisible(false);
			         panel_Base_zhibiao.setVisible(false);
	    		}
	    		else{
	    			JOptionPane.showMessageDialog(null, "网路链接断开，请检查网路！","", JOptionPane.ERROR_MESSAGE);
	    			
	    			
	    		}
	    		
	    		
	    		
	    	}
	    });
	    buttonSet( Button_Stock3,"K线图.png");
	    Button_Stock3.setBounds(61, 142, 160, 46);
	    panel_function_zhibiao.add(Button_Stock3);
	    
	    JButton Button_Stock4 = new JButton("");
	    Button_Stock4.setFont(new Font("楷体", Font.BOLD, 24));
	    Button_Stock4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(NetTester.NetTest()){
 			
                    if(StockhasChanged[2]){
                    	VolumeChartPanel.DataInit(numOfStock, nameOfStock, TimeGetter.getToday());
    	    			VolumeChartPanel.ShoushulabelInit();
    	    			StockhasChanged[2]=false;
                    }
	    			
	    			VolumeChartPanel.setVisible(true);
	    			
	    			 panel_input_StocksSearch.setVisible(false);
			         panel_present_stocks_Details.setVisible(false);
			         KchartPanel.setVisible(false);
			         panel_Head_zhibiao.setVisible(false);
			         panel_Base_zhibiao.setVisible(false);
	    		}
	    		else{
	    			JOptionPane.showMessageDialog(null, "网路链接断开，请检查网路！","", JOptionPane.ERROR_MESSAGE);
	    			
	    			
	    		}
	    	}
	    });
	    buttonSet( Button_Stock4,"成交量图.png");
	    Button_Stock4.setBounds(61, 201, 160, 46);
	    panel_function_zhibiao.add(Button_Stock4);
	    
	    JButton Button_Stock5 = new JButton("");
	    Button_Stock5.setFont(new Font("楷体", Font.BOLD, 24));
	    Button_Stock5.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Panel_zhibiao_reboot();
	    		//comboBox.setSelectedIndex(0);
	    		WaitPanel.setVisible(false);
	    		panel_function_zhibiao.setVisible(false);
	    		panel_function.setVisible(true);
    			panel_input_stocks.setVisible(true);
	    		panel_present_stocks.setVisible(true);
   			 panel_input_StocksSearch.setVisible(false);
	         panel_present_stocks_Details.setVisible(false);
	         VolumeChartPanel.setVisible(false);
	         KchartPanel.setVisible(false);
	         panel_Head_zhibiao.setVisible(false);
	         panel_Base_zhibiao.setVisible(false);
	         for(int i=0;i<4;i++){
	     		StockhasChanged[i]=true;
	     	}
	    	}
	    });
	    buttonSet( Button_Stock5,"返回.png");
	    Button_Stock5.setBounds(61, 260, 160, 46);  
	    panel_function_zhibiao.add(Button_Stock5);
	    
	    
	//**********************************************************************以上为左侧功能面板    
	    JButton Button_Stock6 = new JButton("");
	    Button_Stock6.setFont(new Font("楷体", Font.BOLD, 24));
	    Button_Stock6.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panel_function_hangye.setVisible(false);
	    		panel_function.setVisible(true);
    			panel_input_stocks.setVisible(true);
	    		panel_present_stocks.setVisible(true);
//   			 panel_input_StocksSearch.setVisible(false);
//	         panel_present_stocks_Details.setVisible(false);
//	         VolumeChartPanel.setVisible(false);
//	         KchartPanel.setVisible(false);
	    		panel_Base_hangye.setVisible(false);
	        
	         for(int i=0;i<4;i++){
	     		StockhasChanged[i]=true;
	     	}
	    	}
	    });
	    buttonSet( Button_Stock6,"返回.png");
	    Button_Stock6.setBounds(61, 24, 160, 46);  
	    panel_function_hangye.add(Button_Stock6);
	    
	    
	  //**********************************************************************以上为行业功能面板    
	    
	    JButton btnNewButton = new JButton(" ");
	    buttonSet(btnNewButton,"按钮股票查看.png");
//	    btnNewButton.setBackground(new Color(255,255,255));  
//	    btnNewButton.setBorder(null); 
//	    btnNewButton.setOpaque(false);
//	    btnNewButton.setForeground(Color.WHITE);
	    btnNewButton.setFont(new Font("楷体", Font.BOLD, 24));
    
	    
	  
	   
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panel_present_stocks.setVisible(true);
	    		panel_input_stocks.setVisible(true);	    		
	    		panel_input_grails.setVisible(false);
	    		panel_present_grails.setVisible(false);
	    		panel_input_StocksSearch.setVisible(false);
	    		panel_present_stocks_Details.setVisible(false);
	    		panel_Us.setVisible(false);
	    		KchartPanel.setVisible(false);
	    		VolumeChartPanel.setVisible(false);
	    	}
	    });
	    btnNewButton.setBounds(61, 24, 160, 46);
	   
	    //btnNewButton.setBounds(12, 24, 1000, 500);
	    panel_function.add(btnNewButton);
	    
	    JButton button = new JButton(" ");
	    button.setForeground(Color.WHITE);
	   //buttonSet(button);
	    
	    
	    button.setFont(new Font("楷体", Font.BOLD, 24));
	    button.setBounds(61, 83, 160, 46);
	    buttonSet(button,"按钮大盘查看.png");
	    button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panel_present_stocks.setVisible(false);
	    		panel_input_stocks.setVisible(false);	    		
	    		panel_input_grails.setVisible(true);
	    		panel_present_grails.setVisible(true);
	    		panel_input_StocksSearch.setVisible(false);
	    		panel_present_stocks_Details.setVisible(false);
	    		panel_Us.setVisible(false);
	    		KchartPanel.setVisible(false);
	    		VolumeChartPanel.setVisible(false);
	    	}
	    });
	    
	    
	    
	    
	    
	    
	    
	    panel_function.add(button);
	    
	    
	    
	    
	    
	    //设置表格基本信息
	    
	     panel_input_stocks = new JPanel();
	    
	    panel_input_stocks.setVisible(false);
	    panel_input_stocks.setOpaque(false);
	    panel_input_stocks.setBounds(279, 0, 995, 172);
	    contentPane.add(panel_input_stocks);
	    panel_input_stocks.setLayout(null);
	   
	    
	    JLabel lblNewLabel = new JLabel("股票代码");
	    lblNewLabel.setForeground(Color.WHITE);
	    lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 25));
	    lblNewLabel.setBounds(22, 31, 110, 59);
	    panel_input_stocks.add(lblNewLabel);
	    
	    textField = new JTextField();
	    textField.setBounds(144, 42, 88, 35);
	    panel_input_stocks.add(textField);
	    textField.setColumns(10);
	    
	    JButton btnNewButton_1 = new JButton(" ");
	    buttonSet(btnNewButton_1,"按钮添加.png");
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		 String stocks=textField.getText();
	    		
	    		 
	    			    Pattern pattern = Pattern.compile("[0-9]*"); 
	    			    if( !pattern.matcher(stocks).matches()){
	    			    	JOptionPane.showMessageDialog(null, "请输入数字！","", JOptionPane.ERROR_MESSAGE);
	    			    }
	    			    else if(stocks.equals("")){
	    			    	JOptionPane.showMessageDialog(null, "请输入股票代码！","", JOptionPane.ERROR_MESSAGE);
	    			    }
	    			    else{
	    			    	ReadStocks_resolved reader=new ReadStocks_resolved();
	    			    	if(reader.checkStock(stocks)){
	    			    		if(addStocksBase(textField.getText()))
	    			    			reader.addStock(stocks);
	    			    		
	    			    			
	    			    	}
	    			    		
	    			    	else
	    			    		JOptionPane.showMessageDialog(null, "该股票已存在！","", JOptionPane.ERROR_MESSAGE);
	    			    	
	    		    	   	
	    			    }
 			    textField.setText("");

	    	}
	    });
	    btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 15));
	    btnNewButton_1.setBounds(63, 94, 123, 59);
	    panel_input_stocks.add(btnNewButton_1);
	    
	    JButton button_1 = new JButton(" ");
	    buttonSet(button_1,"查看具体信息.png");
	    button_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int SelectedRow=table.getSelectedRow();
	    		if(SelectedRow==-1)
	    			JOptionPane.showMessageDialog(null, "请选择一个股票！","", JOptionPane.ERROR_MESSAGE);
	    		else{
		    		DefaultTableModel model=(DefaultTableModel)table.getModel();
		    		numOfStock=(String)model.getValueAt(SelectedRow, 0);
		    		//*******************************************************************************************************
		    		//要加入下层的传入股票的具体信息,不用搜索，用默认最近一个月的方法
		    		
		    		if(NetTester.NetTest()){
		    			StocksBLService bl=new StocksBL();
			    		ArrayList<StocksVO> detailList=null;
			    		
			    		try {
			    			detailList=bl.getDetailsOfStock(numOfStock);
			    			
			    			setStocksDetails(detailList);
			    			
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			    		
			    		
			    		
			    		StockNameGetService NameGet=new NameGetter();
						nameOfStock=NameGet.getName(numOfStock);
						HeadLabel.setText(nameOfStock+"(hs"+numOfStock+")");
			    		
			    		lblNewLabel_3.setText(nameOfStock+"("+numOfStock+")"+"的历史交易记录");
			    		
			    		panel_input_StocksSearch.setVisible(true);
			    		panel_present_stocks_Details.setVisible(true);
			    		panel_function_zhibiao.setVisible(true);
		    			panel_function.setVisible(false);
		    			panel_input_stocks.setVisible(false);
			    		panel_present_stocks.setVisible(false);
		    			
		    		}
		    		else{
		    			JOptionPane.showMessageDialog(null, "网路链接中断，请检查网路！","", JOptionPane.ERROR_MESSAGE);
		    		}
	    			
	    	}
	    	}
	    });
	    button_1.setFont(new Font("楷体", Font.PLAIN, 18));
	    button_1.setBounds(238, 94, 161, 58);
	    panel_input_stocks.add(button_1);
	    
	    JButton button_2 = new JButton(" ");
	    buttonSet(button_2,"按钮删除所选股票.png");
	    button_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int SelectedRow=table.getSelectedRow();
	    		if(SelectedRow==-1)
	    			JOptionPane.showMessageDialog(null, "请选择一个股票！","", JOptionPane.ERROR_MESSAGE);
	    		else{
	    			DefaultTableModel model=(DefaultTableModel)table.getModel();
		    		String numOfStock=(String)model.getValueAt(SelectedRow, 0);
		    		ReadStocks_resolved reader=new ReadStocks_resolved();
		    		reader.removeStock(numOfStock); 		
		    		stocksPresentBaseModel.removeRow(SelectedRow);
	    		}
	    		
	    
	    		
	    	}
	    });
	    button_2.setFont(new Font("楷体", Font.PLAIN, 18));
	    button_2.setBounds(451, 92, 161, 58);
	    panel_input_stocks.add(button_2);
	    
	    JButton button_3 = new JButton("");
	    buttonSet( button_3,"行业统计.png");
	    button_3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(NetTester.NetTest()){
					int totalRow=table.getRowCount();
					DefaultTableModel model=(DefaultTableModel)table.getModel();
		    		ArrayList<RequestCategoryVO> list=new ArrayList<RequestCategoryVO>();
		    		ArrayList<String> hangyeList=new ArrayList<String>();
		    
		    		
					for(int i=0;i<totalRow;i++){
						String num=(String)model.getValueAt(i, 0);
						String name=(String)model.getValueAt(i, 1);
						String hangye=(String)model.getValueAt(i, 2);
						RequestCategoryVO tempVO=new RequestCategoryVO(num,name);
						
						list.add(tempVO);
						
						hangyeList.add(hangye);

					}
					//调用下层方法
				
					
					
					 
					
					CategoryStatisticsBL bl=new CategoryStatisticsBL();
					CategoryStatisticsVO VO=new CategoryStatisticsVO(null, null);
					
		
					
					ArrayList<CategoryDetailVO> Hanglist=bl.GetCategoryDetail(hangyeList);
					try {
						VO=bl.CategoryStatistics(list);
						
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					ArrayList<RemenVO> remenvolist=VO.getRemenVOList();
					ArrayList<PiechartDataVO> volumelist=new ArrayList<PiechartDataVO>();
					ArrayList<PiechartDataVO> turnOverlist=new ArrayList<PiechartDataVO>();
					ArrayList<PiechartDataVO> Remenlist=new ArrayList<PiechartDataVO>();
					ArrayList<PiechartDataVO> numlist=new ArrayList<PiechartDataVO>();
					int maxAt=0;
					double max=0;
					for(int i=0;i<remenvolist.size();i++){
						RemenVO remen=remenvolist.get(i);
						
						PiechartDataVO turnoverVO=new PiechartDataVO(remen.getcategory(),remen.getavgturnoverp());
						PiechartDataVO newVO=new PiechartDataVO(remen.getcategory(),remen.getavgvolumep());
						PiechartDataVO RemenVO=new PiechartDataVO(remen.getcategory(),(remen.getavgvolumep()+remen.getavgturnoverp())/2);
						
						newVO.setdata(remen.getavgvolume());
						turnoverVO.setdata(remen.getavgturnover());
						
						DecimalFormat df = new DecimalFormat("0.00");
						double zhishu=(remen.getavgvolumep()+remen.getavgturnoverp())*50;
						if(zhishu>max){
							max=zhishu;
							maxAt=i;
						}
							
						RemenVO.setdata(Double.parseDouble(df.format(zhishu)));
						volumelist.add(newVO);
						turnOverlist.add(turnoverVO);
						Remenlist.add(RemenVO);
						
					}
					for(int i=0;i<Hanglist.size();i++){
						CategoryDetailVO temp=Hanglist.get(i);
						PiechartDataVO numVO=new PiechartDataVO(temp.getname(),temp.getpercent());

						numVO.setdata(temp.getnum());
						numlist.add(numVO);
					}
					
					Hange_num.DataInit(numlist);
					
					
					Hange_num.LabelInit();
					Hange_num.setDanwei("个数");
					Hange_num.setHead("行业股票个数情况表");
					
					Hange_volume.DataInit(volumelist);
					Hange_volume.LabelInit();
					Hange_volume.setDanwei("百股");
					Hange_volume.setHead("行业股票成交量情况表");
					
					Hange_turnOver.DataInit(turnOverlist);
					Hange_turnOver.LabelInit();
					Hange_turnOver.setDanwei("%");
					Hange_turnOver.setHead("行业股票换手率情况表");
					
					Hange_Remen.DataInit(Remenlist);
					Hange_Remen.LabelInit();
					Hange_Remen.setDanwei("热门指数");
					Hange_Remen.setHead("行业股票热门指数情况表");
					Hange_Remen.setZongzhi("100");
					
					remenHangye.setText("统计得最热门行业为："+Remenlist.get(maxAt).getlabel());
					panel_Base_hangye.setVisible(true);
					panel_input_stocks.setVisible(false);
		    		panel_present_stocks.setVisible(false);
		    		panel_function_hangye.setVisible(true);
		    		panel_function.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(null, "网路连接中断，请检查网路！","", JOptionPane.ERROR_MESSAGE);
				}
			}
	
	    });
	    button_3.setBounds(664,94,161,58);
	    panel_input_stocks.add(button_3);

	   

	    
	    panel_input_StocksSearch = new JPanel();	    
	    
	    panel_input_StocksSearch.setVisible(false);//**********
	    
	    panel_input_StocksSearch.setOpaque(false);//透明
	    panel_input_StocksSearch.setBounds(279, 0, 995, 172);
	    contentPane.add(panel_input_StocksSearch);
	    panel_input_StocksSearch.setLayout(null);
	    
	    JLabel lblNewLabel_6 = new JLabel("单位：元");
	    lblNewLabel_6.setForeground(Color.WHITE);
	    lblNewLabel_6.setBounds(817, 63, 72, 37);
	    panel_input_StocksSearch.add(lblNewLabel_6);
	    lblNewLabel_6.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    
	    JLabel lblNewLabel_1 = new JLabel("起始日期");
	    lblNewLabel_1.setForeground(Color.WHITE);
	    lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    lblNewLabel_1.setBounds(41, 34, 93, 36);
	    panel_input_StocksSearch.add(lblNewLabel_1);
	    
	    JLabel label_1 = new JLabel("结束日期");
	    label_1.setForeground(Color.WHITE);
	    label_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_1.setBounds(41, 81, 93, 36);
	    panel_input_StocksSearch.add(label_1);
	    
	    JLabel label_2 = new JLabel("(日期格式：如 2016-01-26)");
	    label_2.setForeground(Color.WHITE);
	    label_2.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_2.setBounds(41, 125, 268, 36);
	    panel_input_StocksSearch.add(label_2);
	    
	    textField_1 = new JTextField();
	    textField_1.setBounds(137, 43, 127, 27);
	    panel_input_StocksSearch.add(textField_1);
	    textField_1.setColumns(10);
	    
	    textField_2 = new JTextField();
	    textField_2.setColumns(10);
	    textField_2.setBounds(137, 90, 127, 27);
	    panel_input_StocksSearch.add(textField_2);
	    
	    JLabel label_3 = new JLabel("开盘价范围");
	    label_3.setForeground(Color.WHITE);
	    label_3.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_3.setBounds(286, 34, 93, 36);
	    panel_input_StocksSearch.add(label_3);
	    
	    JLabel label_4 = new JLabel("收盘价范围");
	    label_4.setForeground(Color.WHITE);
	    label_4.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_4.setBounds(286, 81, 93, 36);
	    panel_input_StocksSearch.add(label_4);
	    
	    textField_3 = new JTextField();
	    textField_3.setColumns(10);
	    textField_3.setBounds(384, 43, 64, 27);
	    panel_input_StocksSearch.add(textField_3);
	    
	    textField_4 = new JTextField();
	    textField_4.setColumns(10);
	    textField_4.setBounds(384, 90, 64, 27);
	    panel_input_StocksSearch.add(textField_4);
	    
	    textField_5 = new JTextField();
	    textField_5.setColumns(10);
	    textField_5.setBounds(470, 43, 64, 27);
	    panel_input_StocksSearch.add(textField_5);
	    
	    textField_6 = new JTextField();
	    textField_6.setColumns(10);
	    textField_6.setBounds(470, 90, 64, 27);
	    panel_input_StocksSearch.add(textField_6);
	    
	    JLabel lblNewLabel_2 = new JLabel("~");
	    lblNewLabel_2.setForeground(Color.WHITE);
	    lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
	    lblNewLabel_2.setBounds(455, 54, 63, 16);
	    panel_input_StocksSearch.add(lblNewLabel_2);
	    
	    JLabel label_5 = new JLabel("~");
	    label_5.setForeground(Color.WHITE);
	    label_5.setFont(new Font("宋体", Font.PLAIN, 18));
	    label_5.setBounds(455, 101, 63, 16);
	    panel_input_StocksSearch.add(label_5);
	    
	    JLabel label_6 = new JLabel("最高价范围");
	    label_6.setForeground(Color.WHITE);
	    label_6.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_6.setBounds(540, 34, 93, 36);
	    panel_input_StocksSearch.add(label_6);
	    
	    JLabel label_7 = new JLabel("最低价范围");
	    label_7.setForeground(Color.WHITE);
	    label_7.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_7.setBounds(540, 81, 93, 36);
	    panel_input_StocksSearch.add(label_7);
	    
	    textField_7 = new JTextField();
	    textField_7.setColumns(10);
	    textField_7.setBounds(636, 43, 64, 27);
	    panel_input_StocksSearch.add(textField_7);
	    
	    JLabel label_8 = new JLabel("~");
	    label_8.setForeground(Color.WHITE);
	    label_8.setFont(new Font("宋体", Font.PLAIN, 18));
	    label_8.setBounds(707, 54, 63, 16);
	    panel_input_StocksSearch.add(label_8);
	    
	    textField_8 = new JTextField();
	    textField_8.setColumns(10);
	    textField_8.setBounds(722, 43, 64, 27);
	    panel_input_StocksSearch.add(textField_8);
	    
	    textField_9 = new JTextField();
	    textField_9.setColumns(10);
	    textField_9.setBounds(636, 90, 64, 27);
	    panel_input_StocksSearch.add(textField_9);
	    
	    JLabel label_9 = new JLabel("~");
	    label_9.setForeground(Color.WHITE);
	    label_9.setFont(new Font("宋体", Font.PLAIN, 18));
	    label_9.setBounds(707, 101, 63, 16);
	    panel_input_StocksSearch.add(label_9);
	    
	    textField_10 = new JTextField();
	    textField_10.setColumns(10);
	    textField_10.setBounds(722, 90, 64, 27);
	    panel_input_StocksSearch.add(textField_10);
	    
	    JLabel label_10 = new JLabel("(日期必须输入，其余参数可不输入)");
	    label_10.setForeground(Color.WHITE);
	    label_10.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_10.setBounds(313, 125, 297, 36);
	    panel_input_StocksSearch.add(label_10);
	    
	    JButton btnNewButton_2 = new JButton(" ");
	    btnNewButton_2.setBounds(849, 94, 123, 58);
	    panel_input_StocksSearch.add(btnNewButton_2);
	    buttonSet(btnNewButton_2,"按钮搜索.png");
	    btnNewButton_2.setFont(new Font("楷体", Font.PLAIN, 18));
	    btnNewButton_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		
	    		String kaipan1=textField_3.getText();
	    		String kaipan2=textField_5.getText();
	    		String shoupan1=textField_4.getText();
	    		String shoupan2=textField_6.getText();
	    		String max1=textField_7.getText();
	    		String max2=textField_8.getText();
	    		String min1=textField_9.getText();
	    		String min2=textField_10.getText();
	    		
	    		boolean isok=true;
	    		
	    		if(StocksSearchInfoChecker.checkisDate(textField_1.getText())){
	    			if(StocksSearchInfoChecker.checkisDate(textField_2.getText())){
	    			if(StocksSearchInfoChecker.checkDateOrder(textField_1.getText(), textField_2.getText())){
	    					
	    			}
	    			else{
	    				JOptionPane.showMessageDialog(null, "起始日期要在结束日期之前！","", JOptionPane.ERROR_MESSAGE);
	    				isok=false;
	    			}
	    				
	    			}
	    			else{
	    				JOptionPane.showMessageDialog(null, "日期输入格式不正确！","", JOptionPane.ERROR_MESSAGE);
	    				isok=false;
	    			}
		    				
			
	    		}	    			
	    		else{
	    			JOptionPane.showMessageDialog(null, "日期输入格式不正确！","", JOptionPane.ERROR_MESSAGE);
	    			isok=false;
	    		}
	    			
	    		
	    		if(isok){
	    			if(StocksSearchInfoChecker.checkNull(kaipan1, kaipan2)){
	    				kaipan1="0";
	    				kaipan2="0";
	    			}
	    			else{
	    				if(!StocksSearchInfoChecker.checkInfoOrder(kaipan1, kaipan2)){
	    					isok=false;
	    					JOptionPane.showMessageDialog(null, "开盘价输入不正确！","", JOptionPane.ERROR_MESSAGE);
	    					
	    				}		
	    			}
	    			
	    		}
	    		if(isok){
	    			if(StocksSearchInfoChecker.checkNull(shoupan1, shoupan2)){
	    				shoupan1="0";
	    				shoupan2="0";
	    			}
	    			else{
	    				if(!StocksSearchInfoChecker.checkInfoOrder(shoupan1, shoupan2)){
	    					isok=false;
	    					JOptionPane.showMessageDialog(null, "收盘价输入不正确！","", JOptionPane.ERROR_MESSAGE);
	    					
	    				}		
	    			}
	    			
	    		}
	    		if(isok){
	    			if(StocksSearchInfoChecker.checkNull(max1, max2)){
	    				max1="0";
	    				max2="0";
	    			}
	    			else{
	    				if(!StocksSearchInfoChecker.checkInfoOrder(max1, max2)){
	    					isok=false;
	    					JOptionPane.showMessageDialog(null, "最高价输入不正确！","", JOptionPane.ERROR_MESSAGE);
	    					
	    				}		
	    			}
	    			
	    		}
	    		if(isok){
	    			if(StocksSearchInfoChecker.checkNull(min1, min2)){
	    				min1="0";
	    				min2="0";
	    			}
	    			else{
	    				if(!StocksSearchInfoChecker.checkInfoOrder(min1, min2)){
	    					isok=false;
	    					JOptionPane.showMessageDialog(null, "最低价输入不正确！","", JOptionPane.ERROR_MESSAGE);
	    					
	    				}		
	    			}
	    			
	    		}
	    		
	    		if(isok){
	    			//********************************************************************************
	    			//往下传递搜索信息
	    			
	    			StocksBLService bl=new StocksBL();
	    			
	    			StocksSearchInfoVO info=new StocksSearchInfoVO(numOfStock,textField_1.getText(),textField_2.getText(),Double.parseDouble(kaipan1),Double.parseDouble(kaipan2),Double.parseDouble(shoupan1),Double.parseDouble(shoupan2),Double.parseDouble(max1),Double.parseDouble(max2),Double.parseDouble(min1),Double.parseDouble(min2));
	    			ArrayList<StocksVO> list=null;
	    		   if(NetTester.NetTest()){
	    			   try {
		    				
		    				list=bl.stocksSearch(info);
		    				
		    				setStocksDetails(list);
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
 
	    		   }
	    		   else{
	    			   JOptionPane.showMessageDialog(null, "网路链接中断，请检查网路！","", JOptionPane.ERROR_MESSAGE);
	    			   
	    		   }
	    			
	    			
	    			
	    			
	    			textField_1.setText("");
	    			textField_2.setText("");
	    			textField_3.setText("");
	    			textField_4.setText("");
	    			textField_5.setText("");
	    			textField_6.setText("");
	    			textField_7.setText("");
	    			textField_8.setText("");
	    			textField_9.setText("");
	    			textField_10.setText("");
	    			
	    			
	    		}
	    		
	    		
	    		
	    	}
	    });
	    
	     panel_input_grails = new JPanel();
	   
	    panel_input_grails.setVisible(false);//***********************
	    
	    panel_input_grails.setOpaque(false);
	    panel_input_grails.setBounds(279, 0, 995, 172);
	    panel_input_grails.setLayout(null);
	    contentPane.add(panel_input_grails);
	    
	    JLabel lblNewLabel_4 = new JLabel("起始日期");
	    lblNewLabel_4.setForeground(Color.WHITE);
	    lblNewLabel_4.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    lblNewLabel_4.setBounds(40, 29, 81, 32);
	    panel_input_grails.add(lblNewLabel_4);
	    
	    JLabel label_11 = new JLabel("结束日期");
	    label_11.setForeground(Color.WHITE);
	    label_11.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_11.setBounds(40, 75, 81, 32);
	    panel_input_grails.add(label_11);
	    
	    textField_11 = new JTextField();
	    textField_11.setBounds(133, 31, 104, 32);
	    panel_input_grails.add(textField_11);
	    textField_11.setColumns(10);
	    
	    textField_12 = new JTextField();
	    textField_12.setColumns(10);
	    textField_12.setBounds(133, 77, 104, 32);
	    panel_input_grails.add(textField_12);
	    
	    JLabel label_12 = new JLabel("开盘价");
	    label_12.setForeground(Color.WHITE);
	    label_12.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_12.setBounds(261, 29, 81, 32);
	    panel_input_grails.add(label_12);
	    
	    JLabel label_13 = new JLabel("收盘价");
	    label_13.setForeground(Color.WHITE);
	    label_13.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_13.setBounds(261, 75, 81, 32);
	    panel_input_grails.add(label_13);
	    
	    textField_13 = new JTextField();
	    textField_13.setColumns(10);
	    textField_13.setBounds(329, 31, 44, 32);
	    panel_input_grails.add(textField_13);
	    
	    JLabel label_14 = new JLabel("~");
	    label_14.setForeground(Color.WHITE);
	    label_14.setFont(new Font("楷体", Font.PLAIN, 18));
	    label_14.setBounds(374, 40, 36, 21);
	    panel_input_grails.add(label_14);
	    
	    textField_14 = new JTextField();
	    textField_14.setColumns(10);
	    textField_14.setBounds(385, 31, 44, 32);
	    panel_input_grails.add(textField_14);
	    
	    textField_15 = new JTextField();
	    textField_15.setColumns(10);
	    textField_15.setBounds(385, 75, 44, 32);
	    panel_input_grails.add(textField_15);
	    
	    JLabel label_15 = new JLabel("~");
	    label_15.setForeground(Color.WHITE);
	    label_15.setFont(new Font("楷体", Font.PLAIN, 18));
	    label_15.setBounds(374, 84, 36, 21);
	    panel_input_grails.add(label_15);
	    
	    textField_16 = new JTextField();
	    textField_16.setColumns(10);
	    textField_16.setBounds(329, 75, 44, 32);
	    panel_input_grails.add(textField_16);
	    
	    textField_17 = new JTextField();
	    textField_17.setColumns(10);
	    textField_17.setBounds(581, 31, 44, 32);
	    panel_input_grails.add(textField_17);
	    
	    JLabel label_16 = new JLabel("~");
	    label_16.setForeground(Color.WHITE);
	    label_16.setFont(new Font("楷体", Font.PLAIN, 18));
	    label_16.setBounds(570, 40, 36, 21);
	    panel_input_grails.add(label_16);
	    
	    textField_18 = new JTextField();
	    textField_18.setColumns(10);
	    textField_18.setBounds(525, 31, 44, 32);
	    panel_input_grails.add(textField_18);
	    
	    JLabel label_17 = new JLabel("最高价");
	    label_17.setForeground(Color.WHITE);
	    label_17.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_17.setBounds(457, 29, 81, 32);
	    panel_input_grails.add(label_17);
	    
	    textField_19 = new JTextField();
	    textField_19.setColumns(10);
	    textField_19.setBounds(581, 74, 44, 32);
	    panel_input_grails.add(textField_19);
	    
	    JLabel label_18 = new JLabel("~");
	    label_18.setForeground(Color.WHITE);
	    label_18.setFont(new Font("楷体", Font.PLAIN, 18));
	    label_18.setBounds(570, 83, 36, 21);
	    panel_input_grails.add(label_18);
	    
	    textField_20 = new JTextField();
	    textField_20.setColumns(10);
	    textField_20.setBounds(525, 74, 44, 32);
	    panel_input_grails.add(textField_20);
	    
	    JLabel label_19 = new JLabel("最低价");
	    label_19.setForeground(Color.WHITE);
	    label_19.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_19.setBounds(457, 72, 81, 32);
	    panel_input_grails.add(label_19);
	    
	    JLabel label_20 = new JLabel("（日期格式如2016-01-01）");
	    label_20.setForeground(Color.WHITE);
	    label_20.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_20.setBounds(78, 118, 242, 32);
	    panel_input_grails.add(label_20);
	    
	    JLabel label_21 = new JLabel("单位（元）");
	    label_21.setForeground(Color.WHITE);
	    label_21.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_21.setBounds(405, 118, 114, 32);
	    panel_input_grails.add(label_21);
	    
	    JButton btnNewButton_3 = new JButton(" ");
	    btnNewButton_3.setFont(new Font("楷体", Font.PLAIN, 16));
	    buttonSet(btnNewButton_3,"按钮搜索.png");
	    btnNewButton_3.setBounds(673, 57, 123, 58);
	    btnNewButton_3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String kaipan1=textField_13.getText();
	    		String kaipan2=textField_14.getText();
	    		String shoupan1=textField_16.getText();
	    		String shoupan2=textField_15.getText();
	    		String max1=textField_18.getText();
	    		String max2=textField_17.getText();
	    		String min1=textField_20.getText();
	    		String min2=textField_19.getText();
	    		
	    		boolean isok=true;
	    		
	    		if(StocksSearchInfoChecker.checkisDate(textField_11.getText())){
	    			if(StocksSearchInfoChecker.checkisDate(textField_12.getText())){
	    			if(StocksSearchInfoChecker.checkDateOrder(textField_11.getText(), textField_12.getText())){
	    					
	    			}
	    			else{
	    				JOptionPane.showMessageDialog(null, "起始日期要在结束日期之前！","", JOptionPane.ERROR_MESSAGE);
	    				isok=false;
	    			}
	    				
	    			}
	    			else{
	    				JOptionPane.showMessageDialog(null, "日期输入格式不正确！","", JOptionPane.ERROR_MESSAGE);
	    				isok=false;
	    			}
		    				
			
	    		}	    			
	    		else{
	    			JOptionPane.showMessageDialog(null, "日期输入格式不正确！","", JOptionPane.ERROR_MESSAGE);
	    			isok=false;
	    		}
	    			
	    		
	    		if(isok){
	    			if(StocksSearchInfoChecker.checkNull(kaipan1, kaipan2)){
	    				kaipan1="0";
	    				kaipan2="0";
	    			}
	    			else{
	    				if(!StocksSearchInfoChecker.checkInfoOrder(kaipan1, kaipan2)){
	    					isok=false;
	    					JOptionPane.showMessageDialog(null, "开盘价输入不正确！","", JOptionPane.ERROR_MESSAGE);
	    					
	    				}		
	    			}
	    			
	    		}
	    		if(isok){
	    			if(StocksSearchInfoChecker.checkNull(shoupan1, shoupan2)){
	    				shoupan1="0";
	    				shoupan2="0";
	    			}
	    			else{
	    				if(!StocksSearchInfoChecker.checkInfoOrder(shoupan1, shoupan2)){
	    					isok=false;
	    					JOptionPane.showMessageDialog(null, "收盘价输入不正确！","", JOptionPane.ERROR_MESSAGE);
	    					
	    				}		
	    			}
	    			
	    		}
	    		if(isok){
	    			if(StocksSearchInfoChecker.checkNull(max1, max2)){
	    				max1="0";
	    				max2="0";
	    			}
	    			else{
	    				if(!StocksSearchInfoChecker.checkInfoOrder(max1, max2)){
	    					isok=false;
	    					JOptionPane.showMessageDialog(null, "最高价输入不正确！","", JOptionPane.ERROR_MESSAGE);
	    					
	    				}		
	    			}
	    			
	    		}
	    		if(isok){
	    			if(StocksSearchInfoChecker.checkNull(min1, min2)){
	    				min1="0";
	    				min2="0";
	    			}
	    			else{
	    				if(!StocksSearchInfoChecker.checkInfoOrder(min1, min2)){
	    					isok=false;
	    					JOptionPane.showMessageDialog(null, "最低价输入不正确！","", JOptionPane.ERROR_MESSAGE);
	    					
	    				}		
	    			}
	    			
	    		}
	    		
	    		if(isok){
	    			//********************************************************************************
	    			//往下传递搜索信息
	    			GrailsSearchVO info=new GrailsSearchVO(textField_11.getText(),textField_12.getText(),Double.parseDouble(kaipan1),Double.parseDouble(kaipan2),Double.parseDouble(shoupan1),Double.parseDouble(shoupan2),Double.parseDouble(max1),Double.parseDouble(max2),Double.parseDouble(min1),Double.parseDouble(min2));
	    			
	    			
	    			setGrailsBase(info);
			
	    			textField_11.setText("");
	    			textField_12.setText("");
	    			textField_13.setText("");
	    			textField_14.setText("");
	    			textField_15.setText("");
	    			textField_16.setText("");
	    			textField_17.setText("");
	    			textField_18.setText("");
	    			textField_19.setText("");
	    			textField_20.setText("");
	    			
	    			
	    		}
	    		
	    		
	    		
	    	}
	    });
	    
	    
	    
	    panel_input_grails.add(btnNewButton_3);
	    
	    JLabel label_22 = new JLabel("（日期必填，其余可不填）");
	    label_22.setForeground(Color.WHITE);
	    label_22.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    label_22.setBounds(621, 118, 242, 32);
	    panel_input_grails.add(label_22);
	    
	    panel_present_grails = new JPanel();
	    panel_present_grails.setOpaque(false);
	    panel_present_grails.setVisible(false);//****************
	    
	    
	    
	     panel_present_stocks = new JPanel();
	     panel_present_stocks.setOpaque(false);
	     panel_present_stocks.setVisible(false);//***********************
	    
	   
	    panel_present_stocks.setBounds(279, 170, 995, 520);
	    contentPane.add(panel_present_stocks);
	    panel_present_stocks.setLayout(null);
	    
	     
	     JScrollPane scrollPane = new JScrollPane();
	     scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	     scrollPane.getViewport().setOpaque(false);
	     scrollPane.setOpaque(false);
	     scrollPane.setBounds(0,0,995,520);
	     panel_present_stocks.add(scrollPane);
	     
	     
	     
	     //*************************************************************************************
	     
	     
	     
	     	 
	     table = new JTable(stocksPresentBaseModel);
	     table.setForeground(Color.WHITE);
	     table.setBackground(Color.WHITE);
	     table.setFillsViewportHeight(true);
	    
	     
	     
	     table.setFont(new Font("微软雅黑", Font.BOLD, 18));
	     table.setDefaultRenderer(Object.class, renderer);
	     table.setOpaque(false);
	     
	     table.setRowSelectionAllowed(true);
	     table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	     scrollPane.setViewportView(table);//重要！
	     
	     scrollPane.setColumnHeaderView(table.getTableHeader());//设置头部（HeaderView部分）  
	        scrollPane.getColumnHeader().setOpaque(false);//再取出头部，并设置为透明  
	        
        JTableHeader header = table.getTableHeader();//获取头部   
//        header.setPreferredSize(new Dimension(30, 26));   
	        header.setOpaque(false);//设置头部为透明  
	        header.getTable().setOpaque(false);//设置头部里面的表格透明  
	        
	        header.setDefaultRenderer(renderer);  
	        TableCellRenderer headerRenderer = header.getDefaultRenderer();   
	        if (headerRenderer instanceof JLabel)   
	        {  
	            ((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);   
	            ((JLabel) headerRenderer).setOpaque(false);   
	        }  
	        
	     table.setBorder(new LineBorder(new Color(0, 0, 0)));
	     table.setRowHeight(40);
	     TableColumnModel   cm   =   table.getColumnModel();     //表格的列模型
	    panel_present_grails.setBounds(279, 170, 995, 520);
	    panel_present_grails.setLayout(null);
	    contentPane.add(panel_present_grails);
	    
	    JScrollPane scrollPane_2 = new JScrollPane();
	    scrollPane_2.setOpaque(false);
	    scrollPane_2.getViewport().setOpaque(false);//将JScrollPane设置为透明  
	  
        
	    scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	    scrollPane_2.setBounds(0, 0, 995, 520);
	    panel_present_grails.add(scrollPane_2);
	    
	    table_2 = new JTable(grailsPresentBaseModel);
	    table_2.setForeground(Color.WHITE);
	    table_2.setBackground(Color.WHITE);
	    table_2.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    table_2.setDefaultRenderer(Object.class, renderer);
	    scrollPane_2.setColumnHeaderView(table_2);
	    table_2.setRowSelectionAllowed(true);
	    table_2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//重要！可以用横滚动条
	    table_2.setFillsViewportHeight(true);//重要！
	    scrollPane_2.setViewportView(table_2);//重要！
	    table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
	    table_2.setRowHeight(40);
	    TableColumnModel   cm_3   =   table_2.getColumnModel();     //表格的列模型
	    for(int i=0;i<5;i++){
	    TableColumn column= cm_3.getColumn(i);//得到第i个列对象   
	    column.setPreferredWidth(200);//将此列的首选宽度设置为 preferredWidth。
	    //如果 preferredWidth 超出最小或最大宽度，则将其调整为合适的界限值。
	    
	    column.setMaxWidth(200);
	    column.setMinWidth(200);
	    }
	    //设置透明
	    scrollPane_2.setColumnHeaderView(table_2.getTableHeader());//设置头部（HeaderView部分）  
        scrollPane_2.getColumnHeader().setOpaque(false);//再取出头部，并设置为透明 
        
	    table_2.setOpaque(false);
scrollPane_2.getViewport().setOpaque(false);
	     scrollPane_2.setOpaque(false);
scrollPane_2.setColumnHeaderView(table_2.getTableHeader());//设置头部（HeaderView部分）  
	        scrollPane_2.getColumnHeader().setOpaque(false);//再取出头部，并设置为透明  
	        
       JTableHeader header_2 = table_2.getTableHeader();//获取头部   
  
	        header_2.setOpaque(false);//设置头部为透明  
	        header_2.getTable().setOpaque(false);//设置头部里面的表格透明  
	        
	        header_2.setDefaultRenderer(renderer);  
	     
	       




	    
	    
	    
	    
	     panel_present_stocks_Details = new JPanel();
	    
	    panel_present_stocks_Details.setVisible(false);//***********************
	    panel_present_stocks_Details.setOpaque(false);
        panel_present_stocks_Details.setForeground(Color.WHITE);
	    panel_present_stocks_Details.setBackground(Color.WHITE);
	    panel_present_stocks_Details.setBounds(279, 170, 995, 520);
	    contentPane.add(panel_present_stocks_Details);
	    panel_present_stocks_Details.setLayout(null);
	    
	    lblNewLabel_3 = new JLabel("的历史交易记录");
	    lblNewLabel_3.setBounds(330, 11, 400, 41);
	    panel_present_stocks_Details.add(lblNewLabel_3);
	    lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 24));
	    lblNewLabel_3.setForeground(Color.WHITE);
	    
	    
	    JScrollPane scrollPane_1 = new JScrollPane();
	    scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	    scrollPane_1.setBounds(0, 54, 995, 466);
	    panel_present_stocks_Details.add(scrollPane_1);
	    
	    table_1 = new JTable(stocksPresentDetailsModel);
	    table_1.setOpaque(false);
	    scrollPane_1.getViewport().setOpaque(false);
	    scrollPane_1.setOpaque(false);
	    scrollPane_1.setColumnHeaderView(table_1.getTableHeader());//设置头部（HeaderView部分）  
	    scrollPane_1.getColumnHeader().setOpaque(false);//再取出头部，并设置为透明  	   	        
	           JTableHeader header_1 = table_1.getTableHeader();//获取头部   	      
	           header_1.setOpaque(false);//设置头部为透明  
	           header_1.getTable().setOpaque(false);//设置头部里面的表格透明  
	   	        
	           header_1.setDefaultRenderer(renderer);  
//	   	        TableCellRenderer headerRenderer_1 = header_1.getDefaultRenderer();   
//	   	        if (headerRenderer_1 instanceof JLabel)   
//	   	        {  
//	   	            ((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);   
//	   	            ((JLabel) headerRenderer).setOpaque(false);   
//	   	        }
	    table_1.setBackground(Color.WHITE);
	    table_1.setForeground(Color.WHITE);
	    table_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
	    table_1.setDefaultRenderer(Object.class, renderer);
	    table_1.setFillsViewportHeight(true);
	    scrollPane_1.setColumnHeaderView(table_1);
	    scrollPane_1.setViewportView(table_1);//重要！让表格完全覆盖滚动层！
	    table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//重要！可以用横滚动条
	    table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
	    table_1.setRowHeight(40);
	    
	    panel_Us = new JPanel();  
	    
	    panel_Us.setBounds(279, 0, 995, 690);
	    panel_Us.setOpaque(false);
	    contentPane.add(panel_Us);
	    panel_Us.setLayout(null);
	    
	    JLabel lblNewLabel_5 = new JLabel("Produced by:       龚臣      毛越\r\n");
	    lblNewLabel_5.setForeground(new Color(255, 255, 255));
	    lblNewLabel_5.setFont(new Font("楷体", Font.BOLD, 30));
	    lblNewLabel_5.setBounds(81, 242, 741, 104);
	    panel_Us.add(lblNewLabel_5);
	    
	    JLabel label_23 = new JLabel("李翔      栾志远\r\n");
	    label_23.setForeground(Color.WHITE);
	    label_23.setFont(new Font("楷体", Font.BOLD, 30));
	    label_23.setBounds(400, 371, 352, 104);
	    panel_Us.add(label_23);
	    
	    JLabel lblanyquantA = new JLabel("欢迎使用AnyQuant A股搜索分析系统\r\n");
	    lblanyquantA.setForeground(Color.WHITE);
	    lblanyquantA.setFont(new Font("楷体", Font.BOLD, 30));
	    lblanyquantA.setBounds(228, 49, 547, 104);
	    panel_Us.add(lblanyquantA);
	   
	    
	    
	    
	  
	    TableColumnModel   cm_1   =   table_1.getColumnModel();     //表格的列模型
	    for(int i=0;i<8;i++){
	    	if(i==0||i==5){
	    		 TableColumn column= cm_1.getColumn(i);//得到第i个列对象   
	    		    column.setPreferredWidth(150);//将此列的首选宽度设置为 preferredWidth。
	    		    //如果 preferredWidth 超出最小或最大宽度，则将其调整为合适的界限值。
	    		    
	    		    column.setMaxWidth(200);
	    		    column.setMinWidth(150);
	    		
	    		
	    	}
	    	else{
	    		TableColumn column= cm_1.getColumn(i);//得到第i个列对象   
    		    column.setPreferredWidth(120);//将此列的首选宽度设置为 preferredWidth。
    		    //如果 preferredWidth 超出最小或最大宽度，则将其调整为合适的界限值。
    		    
    		    column.setMaxWidth(120);
    		    column.setMinWidth(120);
	    		
	    		
	    	}
	    }
	    for(int i=0;i<11;i++){
	    	if(i!=1&&i!=0&&i!=8&&i!=3&&i!=2){ 
	    TableColumn column= cm.getColumn(i);//得到第i个列对象   
	    column.setPreferredWidth(100);//将此列的首选宽度设置为 preferredWidth。
	    //如果 preferredWidth 超出最小或最大宽度，则将其调整为合适的界限值。
	    
	    column.setMaxWidth(100);
	    column.setMinWidth(100);
	    	}
	    	else{
	    		 TableColumn column= cm.getColumn(i);//得到第i个列对象   
	    		    column.setPreferredWidth(150);//将此列的首选宽度设置为 preferredWidth。
	    		    //如果 preferredWidth 超出最小或最大宽度，则将其调整为合适的界限值。
	    		    
	    		    column.setMaxWidth(200);
	    		    column.setMinWidth(150);
	    		
	    	}
	    }
	    //设置表格基本信息
	   
	    
	    
	    
	    
	    //*********************************各组件开始初始化
	    
	    
	    stocksInit();
	    grailsInit();
	}
	
	private void stocksInit(){
		if(NetTester.NetTest()){
			ReadStocks_resolved reader=new ReadStocks_resolved();
			ArrayList<String> list=reader.getStocks();
			for(int i=1;i<list.size();i++){
				addStocksBase(list.get(i));
				
			}
			
		}
		else
			JOptionPane.showMessageDialog(null, "网路链接中断，请检查网路！","", JOptionPane.ERROR_MESSAGE);
		
		
		
		
	}
	
	private boolean addStocksBase(String str){
		//调用下层方法获取股票数据
		//*************************************************************************************
		StocksBLService bl=new StocksBL();	
		StocksVO stocksvo = null;
		boolean ans=true;
		if(NetTester.NetTest()){
			try {
				stocksvo=bl.addStocks(str);
				
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(stocksvo.getName().equals("none")){
				JOptionPane.showMessageDialog(null, "输入的股票不存在！","", JOptionPane.ERROR_MESSAGE);
				ans=false;
			}
			else{
				
				StockNameGetService NameGet=new NameGetter();
				String name=NameGet.getName(str);
				CategoryStatisticsBLService Categorybl=new CategoryStatisticsBL();
				String kind="";
				try {
					kind=Categorybl.GetStockKind(str);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Vector v = new Vector(11);
			   	 v.add(str);
			   	v.add(name);		
			   	v.add(kind);	   	
			   	 v.add(stocksvo.getDate());
			   	v.add(stocksvo.getOpen());
			   	v.add(stocksvo.getClose());
			   	v.add(stocksvo.getHigh());
			   	v.add(stocksvo.getLow());
			   	v.add(stocksvo.getVolume());
			   	v.add(stocksvo.getTurnover());
				v.add(stocksvo.getPb());
			   	stocksPresentBaseModel.addRow(v);
				
				
				
			}
			
			
		}
		else{

             JOptionPane.showMessageDialog(null, "网路链接中断，请检查网路！","", JOptionPane.ERROR_MESSAGE);
             ans=false;
		}
		
		
		return ans;
		
	}

	
	private void setStocksDetails(ArrayList<StocksVO> list){
		//清空表格
		int row=stocksPresentDetailsModel.getRowCount();
		for(int k=0;k<row;k++){
			stocksPresentDetailsModel.removeRow(0);
		}
		
		
		
		for(int i=0;i<list.size();i++){
			StocksVO stocksvo=list.get(i);
			
			Vector v = new Vector(8);
			 v.add(stocksvo.getDate());
			   	v.add(stocksvo.getOpen());
			   	v.add(stocksvo.getClose());
			   	v.add(stocksvo.getHigh());
			   	v.add(stocksvo.getLow());
			   	v.add(stocksvo.getVolume());
			   	v.add(stocksvo.getTurnover());
				v.add(stocksvo.getPb());
				stocksPresentDetailsModel.addRow(v);
				
				
				
		}
		
		
		
	}
	
	
	
	private void grailsInit(){
      if(NetTester.NetTest()){
    	  String today=TimeGetter.getToday();
          String before=TimeGetter.getDayBefore(20);
          GrailsSearchVO VO=new GrailsSearchVO(before,today,0,0,0,0,0,0,0,0);
          setGrailsBase(VO);
      }
      else{
    	  JOptionPane.showMessageDialog(null, "网路链接中断，请检查网路！","", JOptionPane.ERROR_MESSAGE);
      }
      

    }
	
	private void setGrailsBase(GrailsSearchVO VO){
    	 //***********************************************************************************通过下层获取信息
        //ArrayList<GrailsVO>  getGrails(VO)
		GrailsBLService bl=new GrailsBL();
		ArrayList<GrailsVO> list=null;
		if(NetTester.NetTest()){
			try {
				list=bl.getGrails(VO);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	//以下先清空表格的数据
	    	while(grailsPresentBaseModel.getRowCount()>0){
	    		grailsPresentBaseModel.removeRow(grailsPresentBaseModel.getRowCount()-1);
	    	}
	    	
	    	//再添加表格的内容
	    	for(int i=0;i<list.size();i++){
	    		Vector v = new Vector(5);
	    		GrailsVO tempVO=list.get(i);
	    		
	    		
	   	   	v.add(tempVO.getdate());
	   	   	v.add(tempVO.getopen());
	   	   	v.add(tempVO.getclose());
	   	   	v.add(tempVO.gethigh());
	   	   	v.add(tempVO.getlow());
	   	   	
	   	   	grailsPresentBaseModel.addRow(v);
			
		}
		

    		
    	}
		else{
			JOptionPane.showMessageDialog(null, "网路链接中断，请检查网路！","", JOptionPane.ERROR_MESSAGE);
		}
    	
    	
    	
    	
    }
	


    private void buttonSet(JButton btnNewButton,String img){
    	 btnNewButton.setBackground(new Color(255,255,255));  
 	    btnNewButton.setBorder(null); 
 	    btnNewButton.setOpaque(false);
 	   Icon stockWatch=new ImageIcon("Img/"+img);
	    btnNewButton.setIcon(stockWatch);
    	
    	
    	
    }
    private void buttonSet(JButton btnNewButton){
   	 btnNewButton.setBackground(new Color(255,255,255));  
	    btnNewButton.setBorder(null); 
	    btnNewButton.setOpaque(false);
	  
   	
   	
   	
   }
    private void Panel_zhibiao_reboot(){
    	 BIASPanel.setVisible(false);
		 PSYPanel.setVisible(false);
		 AtrPanel.setVisible(false);
		 ObvPanel.setVisible(false);
	      VrPanel.setVisible(false);
		 CCIPanel.setVisible(false);
		 KDJPanel.setVisible(false);
		 DMIPanel.setVisible(false);
		 RSIPanel.setVisible(false);
    }
    }
