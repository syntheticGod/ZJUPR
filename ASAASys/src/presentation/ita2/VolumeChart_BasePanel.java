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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

import presentation.ita1.TimeGetter;
import presentation.ita2.KChart_BasePanel.Chart_ImgPanel;
import presentation.ita2.KChart_BasePanel.Chart_LocPanel;
import vo.StocksVO;

import javax.swing.JRadioButton;

public class VolumeChart_BasePanel extends JPanel {
	/**
	 * Create the panel.
	 */
	FeeChart_ImgPanel FeeImgPanel;
	ShoushuChart_ImgPanel ShoushuImgPanel;
    Chart_LocPanel LocPanel;
	JLabel lblNewLabel_1;
	JLabel label_9;
	JLabel label_10;
	JLabel label_11;
	JLabel[] leftlabel; 
	JLabel label;
	JLabel label_1;
	JLabel label_7;
	JLabel lblNewLabel;
	JComboBox comboBox;
	JComboBox comboBox_1;
	JRadioButton rdbtnNewRadioButton;
	JRadioButton radioButton;
	String numOfStocks;
	String nameOfStocks;
	ArrayList<StocksVO> StocksList;
	double Shoushumax;
	double Shoushumin;
	double Feemax;
	double Feemin;
	double ShoushuperXiangSu;
	double FeeperXiangSu;
	int selected;
	int xLoc;
	int yLoc1;
	int yLoc2;
	boolean feeSelected;
	boolean ShoushuSelected;
	
	
	 protected void paintComponent(Graphics g) {
			super.paintComponent(g);//保留该面板上的其他组件
			float lineWidth = 2.0f;
			((Graphics2D)g).setColor(Color.white);
		     
		      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
		      ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		      ((Graphics2D)g).drawLine(750, 50, 830, 50);
		      ((Graphics2D)g).setColor(Color.cyan);
		      ((Graphics2D)g).drawLine(750, 22, 830, 22);
		      
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
	
	
	 class ShoushuChart_ImgPanel extends JPanel {


		
		  
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);//保留该面板上的其他组件
	
			
			for(int i=0;i<StocksList.size()-1;i++){
				StocksVO temp1=StocksList.get(i);
				StocksVO temp2=StocksList.get(i+1);
				double Shoushu1=Double.parseDouble(temp1.getVolume());
				double Shoushu2=Double.parseDouble(temp2.getVolume());
				int x1=(int)(15+i*30);
				int y1=(int)(515-(Shoushu1-Shoushumin)*ShoushuperXiangSu);
				int x2=(int)(45+i*30);
				int y2=(int)(515-(Shoushu2-Shoushumin)*ShoushuperXiangSu);
				float lineWidth = 2.0f;
				((Graphics2D)g).setColor(Color.cyan);
				((Graphics2D)g).setStroke(new BasicStroke(lineWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
				((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			     
			      ((Graphics2D)g).drawLine(x1, y1, x2, y2);
	
			}
	
		
			}
			
			  
		ShoushuChart_ImgPanel() {
			super();
	    this.setSize(921, 530);
	    this.setOpaque(false);
	    setLayout(null);
	  
	    this.setVisible(true);
		}


		
		
	}
	 
	 class FeeChart_ImgPanel extends JPanel {


			
		  
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);//保留该面板上的其他组件
		
				
				for(int i=0;i<StocksList.size()-1;i++){
					StocksVO temp1=StocksList.get(i);
					StocksVO temp2=StocksList.get(i+1);
					
					double volume1=Double.parseDouble(temp1.getVolume());
					double open1=Double.parseDouble(temp1.getOpen());
					double close1=Double.parseDouble(temp1.getClose());
					double Fee1=(volume1*(open1+close1)/2)/100;
					
					double volume2=Double.parseDouble(temp2.getVolume());
					double open2=Double.parseDouble(temp2.getOpen());
					double close2=Double.parseDouble(temp2.getClose());
					double Fee2=(volume2*(open2+close2)/2)/100;
					
					
				
					int x1=(int)(15+i*30);
					int y1=(int)(515-(Fee1-Feemin)*FeeperXiangSu);
					int x2=(int)(45+i*30);
					int y2=(int)(515-(Fee2-Feemin)*FeeperXiangSu);

		
					
					float lineWidth = 2.0f;
					((Graphics2D)g).setColor(new Color(255,255,255));
				     
				      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
				      ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				      ((Graphics2D)g).drawLine(x1, y1, x2, y2);
				}
		
			
				}
				
				  
			FeeChart_ImgPanel() {
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
				if(ShoushuSelected){
					g.setColor(Color.cyan);
					g.fillOval(xLoc-5, yLoc1-5, 10, 10);
					
				}
				
				
				if(feeSelected){
					g.setColor(Color.white);
					g.fillOval(xLoc-5, yLoc2-5, 10, 10);
				}
			
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
					
					selected=x/30;
				
					
					xLoc=(selected)*30+15;
					
					StocksVO tempVO=StocksList.get(selected);
					double volume=Double.parseDouble(tempVO.getVolume());
					double open=Double.parseDouble(tempVO.getOpen());
					double close=Double.parseDouble(tempVO.getClose());
					double Fee=(volume*(open+close)/2)/100;
							
							
					
						yLoc1=(int)(515-(volume-Shoushumin)*ShoushuperXiangSu);//成交手数的y坐标
						yLoc2=(int)(515-(Fee-Feemin)*FeeperXiangSu);
					
				
					
						VolumeChart_BasePanel.this.setInfo(selected);
					
					
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
			 
			 this.addKeyListener(new KeyAdapter(){
			    	public void keyPressed(KeyEvent e){
			    		
			    		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			    			
			    			
			    			
			    			selected++;
			    		
			    			if(selected==31){
			    				selected=30;
			    				 StocksVO tempVO=StocksList.get(30);
			    					
			    					String enddate=TimeGetter.getDayBefore(tempVO.getDate(), -5);
			    					
			    					DataInit(numOfStocks,nameOfStocks,enddate);
			    					if(ShoushuSelected&&(!feeSelected)){
			    						
			    						ShoushulabelInit();
			    					}
			    					else if((!ShoushuSelected)&&feeSelected){
			    						
			    						
			    						FeelabelInit();
			    					}
			    					else if(ShoushuSelected&&feeSelected){
			    						
			    						ShoushulabelInit();
			    						
			    					}
			    				
			    					LocChartReboot();
			    					
				    			
			    			}
			    			
			    			xLoc=(selected)*30+15;
								
			    			StocksVO tempVO=StocksList.get(selected);
							double volume=Double.parseDouble(tempVO.getVolume());
							double open=Double.parseDouble(tempVO.getOpen());
							double close=Double.parseDouble(tempVO.getClose());
							double Fee=(volume*(open+close)/2)/100;
									
									
							
								yLoc1=(int)(515-(volume-Shoushumin)*ShoushuperXiangSu);//成交手数的y坐标
								yLoc2=(int)(515-(Fee-Feemin)*FeeperXiangSu);
	
							
							repaint();
			    		}

			    		else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			    			selected--;
			    			if(selected==-1){
			    				
			    				selected=0;
			    				 StocksVO tempVO=StocksList.get(30);
			    					
			    					String enddate=TimeGetter.getDayBefore(tempVO.getDate(), 5);
			    					
			    					DataInit(numOfStocks,nameOfStocks,enddate);
			    					if(ShoushuSelected&&(!feeSelected)){
			    						
			    						ShoushulabelInit();
			    					}
			    					else if((!ShoushuSelected)&&feeSelected){
			    						
			    						
			    						FeelabelInit();
			    					}
			    					else if(ShoushuSelected&&feeSelected){
			    						
			    						ShoushulabelInit();
			    						
			    					}
			    				
			    					LocChartReboot();
			    					
			    			}
			    				
			    			
			    			xLoc=(selected)*30+15;
							
			    			StocksVO tempVO=StocksList.get(selected);
							double volume=Double.parseDouble(tempVO.getVolume());
							double open=Double.parseDouble(tempVO.getOpen());
							double close=Double.parseDouble(tempVO.getClose());
							double Fee=(volume*(open+close)/2)/100;
									
									
							
								yLoc1=(int)(515-(volume-Shoushumin)*ShoushuperXiangSu);//成交手数的y坐标
								yLoc2=(int)(515-(Fee-Feemin)*FeeperXiangSu);
							
							repaint();
			    		}
			    		
			    		VolumeChart_BasePanel.this.setInfo(selected);

			}
			    });
			 
			 
		 }
	 }
	
	/**
	 * Create the panel.
	 */
	public VolumeChart_BasePanel() {
		selected=0;
		feeSelected=false;
		ShoushuSelected=true;
		
       this.setPreferredSize(new Dimension(995, 690));
       this.setOpaque(false);
       setLayout(null);
       leftlabel=new JLabel[10];
       
       lblNewLabel = new JLabel("股票代码名字");
       lblNewLabel.setForeground(Color.WHITE);
       lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
       lblNewLabel.setBounds(381, 11, 263, 49);
       add(lblNewLabel);

       label = new JLabel("日期");
       label.setForeground(Color.WHITE);
       label.setFont(new Font("微软雅黑", Font.BOLD, 18));
       label.setBounds(130, 71, 126, 39);
       add(label);
       
       label_7 = new JLabel("成交量（百股）：");
       label_7.setForeground(Color.WHITE);
       label_7.setFont(new Font("微软雅黑", Font.BOLD, 18));
       label_7.setBounds(269, 71, 263, 39);
       add(label_7);
       
       //************************************************************************************以上为界面基本布局

       JButton btnNewButton = new JButton("");
       btnNewButton.setBounds(933, 654, 56, 30);
       
       buttonSet(btnNewButton,"向右按钮.png");
       btnNewButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
            StocksVO tempVO=StocksList.get(30);
			
			String enddate=TimeGetter.getDayBefore(tempVO.getDate(), -5);
			
			DataInit(numOfStocks,nameOfStocks,enddate);
			if(ShoushuSelected&&(!feeSelected)){
				
				ShoushulabelInit();
			}
			else if((!ShoushuSelected)&&feeSelected){
				
				
				FeelabelInit();
			}
			else if(ShoushuSelected&&feeSelected){
				
				ShoushulabelInit();
				
			}
		
			LocChartReboot();
			VolumeChart_BasePanel.this.repaint();
			
			
			
			
			
		}
    	     
    	   
       });
       add(btnNewButton);
       
       
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
       
       JButton btnNewButton_1 = new JButton("");

       btnNewButton_1.setBounds(71, 654, 56, 30);
       buttonSet(btnNewButton_1,"向左按钮.png");

       btnNewButton_1.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
	       StocksVO tempVO=StocksList.get(30);
			
			String enddate=TimeGetter.getDayBefore(tempVO.getDate(), 5);
			
			DataInit(numOfStocks,nameOfStocks,enddate);
			if(ShoushuSelected&&(!feeSelected)){
				
				ShoushulabelInit();
			}
			else if((!ShoushuSelected)&&feeSelected){
				
				
				FeelabelInit();
			}
			else if(ShoushuSelected&&feeSelected){
				
				ShoushulabelInit();
				
			}
		
			LocChartReboot();
			VolumeChart_BasePanel.this.repaint();
			
		}  
    	   
       });
       add(btnNewButton_1);
       
       for(int i=0;i<10;i++){
    	   leftlabel[i]=new JLabel("111111");
    	   leftlabel[i].setForeground(Color.WHITE);
    	   leftlabel[i].setFont(new Font("微软雅黑", Font.BOLD, 13));
    	   leftlabel[i].setBounds(0, 614-(int)(55.5*i), 73, 30);
    	   add(leftlabel[i]);
       }

       
       
       FeeImgPanel = new FeeChart_ImgPanel();
       FeeImgPanel.setBounds(74, 114, 921, 530);
       FeeImgPanel.setVisible(false);
       add(FeeImgPanel);
       ShoushuImgPanel = new ShoushuChart_ImgPanel();
       ShoushuImgPanel.setBounds(74, 114, 921, 530);
       add(ShoushuImgPanel);
       
       
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
						
						DataInit(numOfStocks,nameOfStocks,TimeGetter.getToday());
						if(ShoushuSelected&&(!feeSelected)){
							
							ShoushulabelInit();
						}
						else if((!ShoushuSelected)&&feeSelected){
							
							
							FeelabelInit();
						}
						else if(ShoushuSelected&&feeSelected){
							
							ShoushulabelInit();
							
						}
					

						VolumeChart_BasePanel.this.repaint();
						
					}//选择的是当月
					else{			
						
						String endday=TimeGetter.getDayBefore(temp, -33);
						
						
						DataInit(numOfStocks,nameOfStocks,endday);
                        if(ShoushuSelected&&(!feeSelected)){
							
							ShoushulabelInit();
						}
						else if((!ShoushuSelected)&&feeSelected){
							
							
							FeelabelInit();
						}
						else if(ShoushuSelected&&feeSelected){
							
							ShoushulabelInit();
							
						}
                        VolumeChart_BasePanel.this.repaint();
	
					}//选择的不是当月
					
					
				}
				
				
				
			}//日期调整结束
			
			
			
		}
  
       });
       add(btnNewButton_2);
       
       label_1 = new JLabel("成交金额（万元）：");
       label_1.setForeground(Color.WHITE);
       label_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
       label_1.setBounds(544, 71, 299, 39);
       add(label_1);
       
       rdbtnNewRadioButton = new JRadioButton("成交量",true);
       rdbtnNewRadioButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(rdbtnNewRadioButton.isSelected())
				ShoushuSelected=true;		
			else
				ShoushuSelected=false;
			
			if(ShoushuSelected&&(!feeSelected)){
				ShoushuImgPanel.setVisible(true);
				FeeImgPanel.setVisible(false);
				ShoushulabelInit();
			}
			else if((!ShoushuSelected)&&feeSelected){
				ShoushuImgPanel.setVisible(false);
				FeeImgPanel.setVisible(true);
				
				FeelabelInit();
			}
			else if(ShoushuSelected&&feeSelected){
				ShoushuImgPanel.setVisible(true);
				FeeImgPanel.setVisible(true);
				ShoushulabelInit();
				
			}
			else{
				
				ShoushuImgPanel.setVisible(false);
				FeeImgPanel.setVisible(false);
				
			}
		}
    	   
    	   
    	   
       });
       rdbtnNewRadioButton.setOpaque(false);
       rdbtnNewRadioButton.setFont(new Font("微软雅黑", Font.BOLD, 13));
       rdbtnNewRadioButton.setForeground(Color.WHITE);
       rdbtnNewRadioButton.setBounds(661, 11, 72, 25);
       add(rdbtnNewRadioButton);
       
       radioButton = new JRadioButton("成交金额",false);
       
       radioButton.setOpaque(false);
       radioButton.setForeground(Color.WHITE);
       radioButton.setFont(new Font("微软雅黑", Font.BOLD, 13));
       radioButton.setBounds(661, 39, 84, 25);
       radioButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(radioButton.isSelected())
				feeSelected=true;		
			else
				feeSelected=false;
			
			if(ShoushuSelected&&(!feeSelected)){
				ShoushuImgPanel.setVisible(true);
				FeeImgPanel.setVisible(false);
				ShoushulabelInit();
			}
			else if((!ShoushuSelected)&&feeSelected){
				ShoushuImgPanel.setVisible(false);
				FeeImgPanel.setVisible(true);
				
				FeelabelInit();
			}
			else if(ShoushuSelected&&feeSelected){
				ShoushuImgPanel.setVisible(true);
				FeeImgPanel.setVisible(true);
				ShoushulabelInit();
				
			}
			else{
				
				ShoushuImgPanel.setVisible(false);
				FeeImgPanel.setVisible(false);
				
			}
		}
   
       });
       add(radioButton);
      
	}
	
	public void DataInit(String numOfStock,String nameOfStock,String date){
		nameOfStocks=nameOfStock;
		numOfStocks=numOfStock;
		
		
		lblNewLabel.setText(nameOfStocks+"(hs"+numOfStocks+")");
		
		StocksList=TimePusher_ita2.getStocksBefore(numOfStocks, date, 31);
		
		
		for(int i=0;i<31;i++){
			StocksVO tempVO=StocksList.get(i);
			double volume=Double.parseDouble(tempVO.getVolume());
			double open=Double.parseDouble(tempVO.getOpen());
			double close=Double.parseDouble(tempVO.getClose());
			double Fee=(volume*(open+close)/2)/100;
			if(i!=0){
				
				if(Shoushumax<volume)
					Shoushumax=volume;
				if(Shoushumin>volume)
					Shoushumin=volume;
				if(Feemax<Fee)
					Feemax=Fee;
				if(Feemin>Fee)
					Feemin=Fee;
				
				
			}
			else{
				Shoushumax=volume;
				Shoushumin=volume;
				Feemax=Fee;
				Feemin=Fee;
			}
	
			
		}
		ShoushuperXiangSu=500/(Shoushumax-Shoushumin);
		FeeperXiangSu=500/(Feemax-Feemin);
		LocChartReboot();
	}
	
	public void ShoushulabelInit(){
		leftlabel[0].setText(String.valueOf((int)Shoushumin));
		double x=(Shoushumax-Shoushumin)/9;
		for(int i=1;i<10;i++){
			DecimalFormat df = new DecimalFormat("0");
			 
			String db = df.format(Shoushumin+i*x);
			leftlabel[i].setText(db);
		
		}
		
		
		
		lblNewLabel_1.setText(StocksList.get(5).getDate());
		label_9.setText(StocksList.get(11).getDate());
		label_11.setText(StocksList.get(17).getDate());
		label_10.setText(StocksList.get(23).getDate());
	}
	
	public void FeelabelInit(){
		DecimalFormat d = new DecimalFormat("0.00");
		leftlabel[0].setText(d.format(Feemin));
		
		double x=(Feemax-Feemin)/9;
		for(int i=1;i<10;i++){
			DecimalFormat df = new DecimalFormat("0.00");
			 
			String db = df.format(Feemin+i*x);
			leftlabel[i].setText(db);
		
		}
		
		
		
		lblNewLabel_1.setText(StocksList.get(5).getDate());
		label_9.setText(StocksList.get(11).getDate());
		label_11.setText(StocksList.get(17).getDate());
		label_10.setText(StocksList.get(23).getDate());
	}
	
	
	
	void setInfo(int select){
		StocksVO temp=StocksList.get(select);
		label.setText(temp.getDate());
		double volume=Double.parseDouble(temp.getVolume());
		double open=Double.parseDouble(temp.getOpen());
		double close=Double.parseDouble(temp.getClose());
		double Fee=(volume*(open+close)/2)/100;
		
		DecimalFormat df = new DecimalFormat("0.00");
		 
		String Feestr = df.format(Fee);
		
		label_1.setText("成交金额（万元）："+Feestr);
		
		label_7.setText("成交量（百股）："+temp.getVolume());
	}
	void LocChartReboot(){
		xLoc=2000;
		yLoc1=2000;
		yLoc2=2000;
	}
	private void buttonSet(JButton btnNewButton,String img){
   	 btnNewButton.setBackground(new Color(255,255,255));  
	    btnNewButton.setBorder(null); 
	    btnNewButton.setOpaque(false);
	   Icon stockWatch=new ImageIcon("Img/"+img);
	    btnNewButton.setIcon(stockWatch);
   	
   	
   	
   }
}
