package presentation.ita2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.json.JSONException;

import presentation.ita1.TimeGetter;
import presentation.ita2.BIAS_BasePanel.Chart_ImgPanel;
import presentation.ita2.BIAS_BasePanel.Chart_LocPanel;
import vo.BIASVO;
import vo.RSIVO;
import businesslogic.StocksBL.StocksStatisticsBL;
import businesslogic.StocksBL.StocksStatisticsBL2;
import bussinesslogicservice.StocksBLService.StocksStatisticsBLService;

public class RSI_BasePanel extends JPanel {


	Chart_ImgPanel ImgPanel;

    Chart_LocPanel LocPanel;
	JLabel lblNewLabel_1;
	JLabel label_9;
	JLabel label_10;
	JLabel label_11;
	JLabel[] leftlabel; 
	JLabel label_DATE;
	JLabel LB1;
	JLabel LB2;
	JLabel LB3;
	JComboBox comboBox;
	JComboBox comboBox_1;
	String numOfStocks;
	
	ArrayList<RSIVO> list1;
	ArrayList<RSIVO> list2;
	ArrayList<RSIVO> list3;
	double datamax;
	double datamin;
	double perXiangSu;
	
	int selected;
	int xLoc;
	int yLoc1;
	int yLoc2;
	int yLoc3;
	private JLabel label;
	
	
	 protected void paintComponent(Graphics g) {
			super.paintComponent(g);//保留该面板上的其他组件
			float lineWidth = 2.0f;
			((Graphics2D)g).setColor(Color.cyan);
		     
		      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
		      ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		      ((Graphics2D)g).drawLine(595, 40, 640, 40);
		      ((Graphics2D)g).setColor(Color.white);
		      ((Graphics2D)g).drawLine(725, 40, 770, 40);
		      ((Graphics2D)g).setColor(Color.yellow);
		      ((Graphics2D)g).drawLine(858, 40, 903, 40);
		      
		      //以下为画出网格
		      lineWidth = 1.0f;
		      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
		      ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		      ((Graphics2D)g).setColor(new Color(255,251,240,80));
		      for(int i=0;i<5;i++){
		    	  ((Graphics2D)g).drawLine(74, (int)(629-111*i), 995, (int)(629-111*i));  
		      }
		      for(int i=0;i<10;i++){
		    	  ((Graphics2D)g).drawLine(146+111*i,114,146+111*i,644);  
		      }
		      
		      
	 }
	
	
	 class Chart_ImgPanel extends JPanel {


		
		  
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);//保留该面板上的其他组件
	
			
			for(int i=0;i<list1.size()-1;i++){
				RSIVO temp1=list1.get(i);
				RSIVO temp2=list1.get(i+1);
				double Shoushu1=Double.parseDouble(temp1.getData());
				double Shoushu2=Double.parseDouble(temp2.getData());
				int x1=(int)(1+i*18);
				int y1=(int)(515-(Shoushu1-datamin)*perXiangSu);				
				int x2=(int)(19+i*18);
				int y2=(int)(515-(Shoushu2-datamin)*perXiangSu);
				
				float lineWidth = 2.0f;
				((Graphics2D)g).setColor(Color.cyan);
				((Graphics2D)g).setStroke(new BasicStroke(lineWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
				((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			     
			      ((Graphics2D)g).drawLine(x1, y1, x2, y2);
	
			}
	
			for(int i=0;i<list2.size()-1;i++){
				RSIVO temp1=list2.get(i);
				RSIVO temp2=list2.get(i+1);
				double Shoushu1=Double.parseDouble(temp1.getData());
				double Shoushu2=Double.parseDouble(temp2.getData());
				int x1=(int)(1+i*18);
				int y1=(int)(515-(Shoushu1-datamin)*perXiangSu);
				int x2=(int)(19+i*18);
				int y2=(int)(515-(Shoushu2-datamin)*perXiangSu);
				float lineWidth = 2.0f;
				((Graphics2D)g).setColor(Color.white);
				((Graphics2D)g).setStroke(new BasicStroke(lineWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
				((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			     
			      ((Graphics2D)g).drawLine(x1, y1, x2, y2);
	
			}
			for(int i=0;i<list3.size()-1;i++){
				RSIVO temp1=list3.get(i);
				RSIVO temp2=list3.get(i+1);
				double Shoushu1=Double.parseDouble(temp1.getData());
				double Shoushu2=Double.parseDouble(temp2.getData());
				int x1=(int)(1+i*18);
				int y1=(int)(515-(Shoushu1-datamin)*perXiangSu);
				int x2=(int)(19+i*18);
				int y2=(int)(515-(Shoushu2-datamin)*perXiangSu);
				float lineWidth = 2.0f;
				((Graphics2D)g).setColor(Color.yellow);
				((Graphics2D)g).setStroke(new BasicStroke(lineWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
				((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			     
			      ((Graphics2D)g).drawLine(x1, y1, x2, y2);
	
			}
			
			}
			
			  
		Chart_ImgPanel() {
			super();
	    this.setSize(921, 530);
	    this.setOpaque(false);
	    setLayout(null);
	  
	    this.setVisible(true);
		}


		
		
	}
	 
	
	 
	 
	 
	/**
	 * 
	 * 
	 * @author gc
	 *         负责图片交互、锁定位置的图层
	 */
	 class Chart_LocPanel extends JPanel{
		 protected void paintComponent(Graphics g) {
				super.paintComponent(g);//保留该面板上的其他组件
				
					g.setColor(Color.cyan);
					g.fillOval(xLoc-5, yLoc1-5, 10, 10);
					g.setColor(Color.white);
					g.fillOval(xLoc-5, yLoc2-5, 10, 10);
					g.setColor(Color.yellow);
					g.fillOval(xLoc-5, yLoc3-5, 10, 10);
				
				
			
			
		 }
		 
		 Chart_LocPanel(){
				super();
			    this.setSize(921, 530);
			    this.setOpaque(false);
			    setLayout(null);
			  
			    this.setVisible(true);
			 
			    this.addMouseListener(new MouseListener(){
   
				 
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					int x=e.getX();			
					
					if(x<=10)
						selected=0;
					else			
					selected=1+(x-10)/18;
				
					
					xLoc=(selected)*18+1;
					
					RSIVO temp1=list1.get(selected);
					double data1=Double.parseDouble(temp1.getData());
					RSIVO temp2=list2.get(selected);
					double data2=Double.parseDouble(temp2.getData());
					RSIVO temp3=list3.get(selected);
					double data3=Double.parseDouble(temp3.getData());
					
						yLoc1=(int)(515-(data1-datamin)*perXiangSu);//成交手数的y坐标
						yLoc2=(int)(515-(data2-datamin)*perXiangSu);
						yLoc3=(int)(515-(data3-datamin)*perXiangSu);
				
					
						RSI_BasePanel.this.setInfo(selected);
					
					
					Chart_LocPanel.this.requestFocus();
					repaint();
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				 
 
			 });
			 

			 
			 
		 }
	 }
	
	
	
	/**
	 * Create the panel.
	 */
	public RSI_BasePanel() {
		selected=0;
		
		
       this.setPreferredSize(new Dimension(995, 690));
       this.setOpaque(false);
       setLayout(null);
       leftlabel=new JLabel[10];
       
       

       label_DATE = new JLabel("日期");
       label_DATE.setForeground(Color.WHITE);
       label_DATE.setFont(new Font("微软雅黑", Font.BOLD, 18));
       label_DATE.setBounds(130, 71, 126, 39);
       add(label_DATE);
       
       LB1 = new JLabel("RSI6：");
       LB1.setForeground(Color.CYAN);
       LB1.setFont(new Font("微软雅黑", Font.BOLD, 18));
       LB1.setBounds(269, 71, 155, 39);
       add(LB1);
       
       //************************************************************************************以上为界面基本布局

    
       
       
       lblNewLabel_1 = new JLabel("日期11111");
       lblNewLabel_1.setForeground(Color.WHITE);
       lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 13));
       lblNewLabel_1.setBounds(200, 655, 84, 25);
       add(lblNewLabel_1);
       
        label_9 = new JLabel("日期11111");
       label_9.setForeground(Color.WHITE);
       label_9.setFont(new Font("微软雅黑", Font.BOLD, 13));
       label_9.setBounds(381, 655, 84, 25);
       add(label_9);
       
       label_10 = new JLabel("日期11111");
       label_10.setForeground(Color.WHITE);
       label_10.setFont(new Font("微软雅黑", Font.BOLD, 13));
       label_10.setBounds(744, 655, 84, 25);
       add(label_10);
       
       label_11 = new JLabel("日期11111");
       label_11.setForeground(Color.WHITE);
       label_11.setFont(new Font("微软雅黑", Font.BOLD, 13));
       label_11.setBounds(562, 655, 84, 25);
       add(label_11);
       
       
       
       for(int i=0;i<10;i++){
    	   leftlabel[i]=new JLabel("111111");
    	   leftlabel[i].setForeground(Color.WHITE);
    	   leftlabel[i].setFont(new Font("微软雅黑", Font.BOLD, 13));
    	   leftlabel[i].setBounds(0, 614-(int)(55.5*i), 73, 30);
    	   add(leftlabel[i]);
       }

       
       
       ImgPanel = new Chart_ImgPanel();
       ImgPanel.setBounds(74, 114, 921, 530);
       
       add(ImgPanel);
    
       
       
       LocPanel=new Chart_LocPanel();
       LocPanel.setOpaque(false);
       LocPanel.setBounds(74, 114, 921, 530);
       add(LocPanel);
       
       int yearToday=TimeGetter.getYear();   
       String yearImpl[]=new String[yearToday-2010+1];
       for(int i=0;i<yearToday-2010+1;i++){
    	   yearImpl[i]=String.valueOf(2010+i);

       }
       
       
       comboBox = new JComboBox(yearImpl);
      
       comboBox.setEditable(false);
       comboBox.setBounds(24, 29, 72, 30);
       comboBox.setOpaque(false);
       comboBox.setForeground(Color.WHITE);
       comboBox.setFont(new Font("微软雅黑", Font.BOLD, 14));
       add(comboBox);
       
       JLabel lblNewLabel_2 = new JLabel("年");
       lblNewLabel_2.setForeground(Color.WHITE);
       lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 18));
       lblNewLabel_2.setBounds(99, 32, 29, 28);
       add(lblNewLabel_2);
       
       
      
       String monthImpl[]=new String[12];
       for(int i=0;i<12;i++){
    	   monthImpl[i]=String.valueOf(1+i);

       }
       
       
       comboBox_1 = new JComboBox(monthImpl);
       comboBox_1.setOpaque(false);
       comboBox_1.setEditable(false);
       comboBox_1.setForeground(Color.WHITE);
       comboBox_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
       comboBox_1.setBounds(120, 29, 50, 31);
       add(comboBox_1);
       
       JLabel label_12 = new JLabel("月");
       label_12.setForeground(Color.WHITE);
       label_12.setFont(new Font("微软雅黑", Font.BOLD, 18));
       label_12.setBounds(176, 32, 29, 28);
       add(label_12);
       
       LB2 = new JLabel("RSI12：");
       LB2.setForeground(Color.WHITE);
       LB2.setFont(new Font("微软雅黑", Font.BOLD, 18));
       LB2.setBounds(436, 71, 155, 39);
       add(LB2);
       
       LB3 = new JLabel("RSI24：");
       LB3.setForeground(Color.YELLOW);
       LB3.setFont(new Font("微软雅黑", Font.BOLD, 18));
       LB3.setBounds(616, 71, 155, 39);
       add(LB3);
       
       JLabel lblbias = new JLabel("相对强弱指标(RSI)");
       lblbias.setForeground(Color.WHITE);
       lblbias.setFont(new Font("微软雅黑", Font.BOLD, 22));
       lblbias.setBounds(336, 11, 192, 49);
       add(lblbias);
       
       JLabel lblBias = new JLabel("RSI6");
       lblBias.setForeground(Color.WHITE);
       lblBias.setFont(new Font("微软雅黑", Font.BOLD, 16));
       lblBias.setBounds(535, 20, 56, 39);
       add(lblBias);
       
       JLabel lblBias_2 = new JLabel("RSI12");
       lblBias_2.setForeground(Color.WHITE);
       lblBias_2.setFont(new Font("微软雅黑", Font.BOLD, 16));
       lblBias_2.setBounds(660, 20, 72, 39);
       add(lblBias_2);
       
       JLabel lblBias_1 = new JLabel("RSI24");
       lblBias_1.setForeground(Color.WHITE);
       lblBias_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
       lblBias_1.setBounds(785, 20, 65, 39);
       add(lblBias_1);
       
       label = new JLabel("(%)");
       label.setForeground(Color.WHITE);
       label.setFont(new Font("微软雅黑", Font.BOLD, 18));
       label.setBounds(34, 71, 56, 39);
       add(label);
       
       JButton btnNewButton_2 = new JButton("");
       btnNewButton_2.setBounds(200, 26, 75, 36);
       buttonSet(btnNewButton_2,"查看按钮.png");
       btnNewButton_2.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			int year=2010+comboBox.getSelectedIndex();
			int month=1+comboBox_1.getSelectedIndex();
			if(year==2009||month==0){
				JOptionPane.showMessageDialog(null, "请先选择时间！","", JOptionPane.ERROR_MESSAGE);
			}
			else{
				String temp=String.valueOf(year)+"-"+String.valueOf(month)+"-"+"01";
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date tempdate=null;
				
				
				try {
					tempdate = sdf.parse(temp);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(tempdate.after(new Date())){
					JOptionPane.showMessageDialog(null, "请选择今天之前的日期！","", JOptionPane.ERROR_MESSAGE);
					
				}
				else{
					Calendar c=Calendar.getInstance();
					if(c.get(Calendar.MONTH)+1==month&&c.get(Calendar.YEAR)==year){
						
						DataInit(numOfStocks,TimeGetter.getToday());
						labelInit();
					

						RSI_BasePanel.this.repaint();
						
					}//选择的是当月
					else{			
						
						String endday=TimeGetter.getDayBefore(temp, -48);
						
						
						DataInit(numOfStocks,endday);
						labelInit();
						

						RSI_BasePanel.this.repaint();
	
					}//选择的不是当月
					
					
				}
				
				
				
			}//日期调整结束
			
			
			
		}
  
       });
       add(btnNewButton_2);
       
       
	}
	
	public void DataInit(String numOfStock,String date){
		
		numOfStocks=numOfStock;
		
		StocksStatisticsBL2 bl=new StocksStatisticsBL2();
		
		
		try {
			list1=bl.ComputeRSI(numOfStock,50, 6, date);
			list2=bl.ComputeRSI(numOfStock,50, 12, date);
			list3=bl.ComputeRSI(numOfStock,50, 24, date);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		for(int i=0;i<50;i++){
			RSIVO tempVO1=list1.get(i);
			RSIVO tempVO2=list2.get(i);
			RSIVO tempVO3=list3.get(i);
			double Data1=Double.parseDouble(tempVO1.getData());
			double Data2=Double.parseDouble(tempVO2.getData());
			double Data3=Double.parseDouble(tempVO3.getData());
			if(i!=0){
				
				if(datamax<Data1)
					datamax=Data1;
				if(datamax<Data2)
					datamax=Data2;
				if(datamax<Data3)
					datamax=Data3;
				if(datamin>Data1)
					datamin=Data1;
				if(datamin>Data2)
					datamin=Data2;
				if(datamin>Data3)
					datamin=Data3;
				
				
				
			}
			else{
				datamax=Data1;
				datamin=Data1;
			}
	
			
		}
		perXiangSu=500/(datamax-datamin);
		
		LocChartReboot();
	}
	
	public void labelInit(){
		DecimalFormat df = new DecimalFormat("0.00");
		 
		String temp = df.format(datamin);
		leftlabel[0].setText(String.valueOf(temp));
		
		
		double x=(datamax-datamin)/9;
		for(int i=1;i<10;i++){
			
			 
			String db = df.format(datamin+i*x);
			leftlabel[i].setText(db);
		
		}
		
		
		
		lblNewLabel_1.setText(list1.get(9).getDate());
		label_9.setText(list1.get(19).getDate());
		label_11.setText(list1.get(29).getDate());
		label_10.setText(list1.get(39).getDate());
	}
	

	
	
	
	void setInfo(int select){
		
		RSIVO tempVO1=list1.get(select);
		RSIVO tempVO2=list2.get(select);
		RSIVO tempVO3=list3.get(select);
		
		
		label_DATE.setText(tempVO1.getDate());
		
//		
//		DecimalFormat df = new DecimalFormat("0.00");
//		 
//		String Feestr = df.format(Fee);
		
		LB1.setText("RSI6："+tempVO1.getData()+"%");
		LB2.setText("RSI12："+tempVO2.getData()+"%");
		LB3.setText("RSI24："+tempVO3.getData()+"%");
	}
	void LocChartReboot(){
		xLoc=2000;
		yLoc1=2000;
		yLoc2=2000;
		yLoc3=2000;
	}
	 private void buttonSet(JButton btnNewButton,String img){
    	 btnNewButton.setBackground(new Color(255,255,255));  
 	    btnNewButton.setBorder(null); 
 	    btnNewButton.setOpaque(false);
 	   Icon stockWatch=new ImageIcon(img);
	    btnNewButton.setIcon(stockWatch);
    	
    	
    	
    }
}
