package presentation.ita2;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Color;
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

import javax.swing.JButton;

import vo.StocksVO;

import javax.swing.JComboBox;

import presentation.ita1.TimeGetter;

public class KChart_BasePanel extends JPanel {

	Chart_ImgPanel ImgPanel;
    Chart_LocPanel LocPanel;
    MA_ImgPanel MaPanel;
	JLabel lblNewLabel_1;
	JLabel label_9;
	JLabel label_10;
	JLabel label_11;
	JLabel[] leftlabel; 
	JLabel label;
	JLabel label_1;
	JLabel label_2;
	JLabel label_3;
	JLabel label_4;
	JLabel label_5;
	JLabel label_6;
	JLabel label_7;
	JLabel lblMa_2;
	JLabel lblMa_1;
	JLabel lblMa;
	JLabel lblNewLabel;
	JComboBox comboBox;
	JComboBox comboBox_1;
	String numOfStocks;
	String nameOfStocks;
	ArrayList<StocksVO> StocksList;
	ArrayList<StocksVO> totalList;
	ArrayList<Double> ma5List;
	ArrayList<Double> ma10List;
	ArrayList<Double> ma20List;
	double max;
	double min;
	double perXiangSu;
	int selected;
	int xLoc;
	int yLoc;
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);//保留该面板上的其他组件

	      
	      //以下为画出网格
	      float lineWidth = 1.0f;
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
	
			
			for(int i=0;i<StocksList.size();i++){
				StocksVO temp=StocksList.get(i);
				int xbegin=16+i*16;
				
				double open=Double.parseDouble(temp.getOpen());
				double close=Double.parseDouble(temp.getClose());
				double high=Double.parseDouble(temp.getHigh());
				double low=Double.parseDouble(temp.getLow());
				int length=0;
				if(open>close){
					
					g.setColor(Color.green);
					length=(int)((open-close)*perXiangSu);
					int ybegin=(int)(515-(open-min)*perXiangSu);
					g.fillRect(xbegin, ybegin, 10, length);
					int maxbegin=(int)(515-(high-min)*perXiangSu);
					int minbegin=(int)(515-(low-min)*perXiangSu);
					
					g.drawLine(xbegin+5, maxbegin, xbegin+5, ybegin);
					g.drawLine(xbegin+5, ybegin+length, xbegin+5, minbegin);
				}
					
				else{
					
					g.setColor(Color.red);
					
					length=(int)((close-open)*perXiangSu);
					int ybegin=(int)(515-(close-min)*perXiangSu);
					g.drawRect(xbegin, ybegin, 10, length);
					int maxbegin=(int)(515-(high-min)*perXiangSu);
					int minbegin=(int)(515-(low-min)*perXiangSu);
					
					g.drawLine(xbegin+5, maxbegin, xbegin+5, ybegin);
					g.drawLine(xbegin+5, ybegin+length, xbegin+5, minbegin);
				}
					
	
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
	
	 class MA_ImgPanel extends JPanel {


		
		  
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);//保留该面板上的其他组件
	
			
			for(int i=0;i<55;i++){
				double prema5=ma5List.get(i);
				double prema10=ma10List.get(i);
				double prema20=ma20List.get(i);
				double ma5=ma5List.get(i+1);
				double ma10=ma10List.get(i+1);
				double ma20=ma20List.get(i+1);		
				
				int xbegin=21+i*16;
				

				int length=0;
				
				float lineWidth = 2.0f;
				((Graphics2D)g).setColor(Color.blue);
			     
			      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
			      ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			      
			      int y1=(int)(515-(prema5-min)*perXiangSu);
			      int y2=(int)(515-(ma5-min)*perXiangSu);
			      int y3=(int)(515-(prema10-min)*perXiangSu);
			      int y4=(int)(515-(ma10-min)*perXiangSu);		      
			      int y5=(int)(515-(prema20-min)*perXiangSu);
			      int y6=(int)(515-(ma20-min)*perXiangSu);	      
					g.drawLine(xbegin, y1, xbegin+16, y2);
					((Graphics2D)g).setColor(Color.white);
					g.drawLine(xbegin, y3, xbegin+16, y4);
					((Graphics2D)g).setColor(Color.yellow);
					g.drawLine(xbegin, y5, xbegin+16, y6);
					
	
			}
	
		
			}
			
			  
		MA_ImgPanel() {
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
				g.setColor(Color.white);
				g.drawLine(0, yLoc, 921, yLoc);
				g.drawLine(xLoc, 0, xLoc, 530);
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
					
					selected=(x-13)/16;
					if(selected==56)
						selected=55;
					
					xLoc=(selected)*16+21;
					
					StocksVO tempVO=StocksList.get(selected);
					double open=Double.parseDouble(tempVO.getOpen());
					double close=Double.parseDouble(tempVO.getClose());
							
							
					if(open>close){
						yLoc=(int)(515-(open-min)*perXiangSu);
		
					}
					else{
						
						yLoc=(int)(515-(close-min)*perXiangSu);
						
					}
					
					KChart_BasePanel.this.setInfo(selected);
					
					
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
			    		
			    			if(selected==56){
			    				selected=55;
			    				  StocksVO tempVO=StocksList.get(55);
			    					
			    					String enddate=TimeGetter.getDayBefore(tempVO.getDate(), -12);
			    					
			    					DataInit(numOfStocks,nameOfStocks,enddate);
			    					labelInit();		
				    			
			    			}
			    			
			    				xLoc=(selected)*16+21;
								
								StocksVO tempVO=StocksList.get(selected);
								double open=Double.parseDouble(tempVO.getOpen());
								double close=Double.parseDouble(tempVO.getClose());
										
										
								if(open>close){
									yLoc=(int)(515-(open-min)*perXiangSu);
					
								}
								else{
									
									yLoc=(int)(515-(close-min)*perXiangSu);
									
								}
			    				
			    				
			    			
			    						
			    				
			    			
							
								KChart_BasePanel.this.repaint();
			    		}

			    		else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			    			selected--;
			    			if(selected==-1){
			    				StocksVO tempVO=StocksList.get(55);
			    				
			    				String enddate=TimeGetter.getDayBefore(tempVO.getDate(), 12);
			    				
			    				DataInit(numOfStocks,nameOfStocks,enddate);
			    				labelInit();
			    				
			    				
			    				
			    				selected=0;
			    			}
			    				
			    			
			    			xLoc=(selected)*16+21;
							
							StocksVO tempVO=StocksList.get(selected);
							double open=Double.parseDouble(tempVO.getOpen());
							double close=Double.parseDouble(tempVO.getClose());
									
									
							if(open>close){
								yLoc=(int)(515-(open-min)*perXiangSu);
				
							}
							else{
								
								yLoc=(int)(515-(close-min)*perXiangSu);
								
							}
							
							KChart_BasePanel.this.repaint();
			    		}
			    		
			    		KChart_BasePanel.this.setInfo(selected);

			}
			    });
			 
			 
		 }
	 }
	
	/**
	 * Create the panel.
	 */
	public KChart_BasePanel() {
		selected=0;
	
		
       this.setPreferredSize(new Dimension(995, 690));
       this.setOpaque(false);
       setLayout(null);
       leftlabel=new JLabel[10];
       
       lblNewLabel = new JLabel("股票代码名字");
       lblNewLabel.setForeground(Color.WHITE);
       lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
       lblNewLabel.setBounds(299, 11, 263, 49);
       add(lblNewLabel);

       label = new JLabel("日期");
       label.setForeground(Color.WHITE);
       label.setFont(new Font("微软雅黑", Font.BOLD, 18));
       label.setBounds(12, 71, 126, 39);
       add(label);
       
       label_1 = new JLabel("开：");
       label_1.setForeground(Color.WHITE);
       label_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
       label_1.setBounds(141, 71, 91, 39);
       add(label_1);
       
       label_2 = new JLabel("收：");
       label_2.setForeground(Color.WHITE);
       label_2.setFont(new Font("微软雅黑", Font.BOLD, 18));
       label_2.setBounds(240, 71, 91, 39);
       add(label_2);
       
       label_3 = new JLabel("高：");
       label_3.setForeground(Color.WHITE);
       label_3.setFont(new Font("微软雅黑", Font.BOLD, 18));
       label_3.setBounds(335, 71, 91, 39);
       add(label_3);
       
       label_4 = new JLabel("低：");
       label_4.setForeground(Color.WHITE);
       label_4.setFont(new Font("微软雅黑", Font.BOLD, 18));
       label_4.setBounds(430, 71, 91, 39);
       add(label_4);
       
       label_5 = new JLabel("换：");
       label_5.setForeground(Color.WHITE);
       label_5.setFont(new Font("微软雅黑", Font.BOLD, 18));
       label_5.setBounds(525, 71, 121, 39);
       add(label_5);
       
       label_6 = new JLabel("净：");
       label_6.setForeground(Color.WHITE);
       label_6.setFont(new Font("微软雅黑", Font.BOLD, 18));
       label_6.setBounds(650, 71, 121, 39);
       add(label_6);
       
       label_7 = new JLabel("成交量：");
       label_7.setForeground(Color.WHITE);
       label_7.setFont(new Font("微软雅黑", Font.BOLD, 18));
       label_7.setBounds(777, 71, 206, 39);
       add(label_7);
       
      
       
       //************************************************************************************以上为界面基本布局

       JButton btnNewButton = new JButton("");
       btnNewButton.setBounds(933, 654, 56, 30);
       
       buttonSet(btnNewButton,"向右按钮.png");
       btnNewButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
            StocksVO tempVO=StocksList.get(55);
			
			String enddate=TimeGetter.getDayBefore(tempVO.getDate(), -12);
			
			DataInit(numOfStocks,nameOfStocks,enddate);
			labelInit();
			KChart_BasePanel.this.repaint();
			
			
			
			
			
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
			
	       StocksVO tempVO=StocksList.get(55);
			
			String enddate=TimeGetter.getDayBefore(tempVO.getDate(), 12);
			
			DataInit(numOfStocks,nameOfStocks,enddate);
			labelInit();
			KChart_BasePanel.this.repaint();
			
		}  
    	   
       });
       add(btnNewButton_1);
       
       for(int i=0;i<10;i++){
    	   leftlabel[i]=new JLabel("111111");
    	   leftlabel[i].setForeground(Color.WHITE);
    	   leftlabel[i].setFont(new Font("微软雅黑", Font.BOLD, 13));
    	   leftlabel[i].setBounds(12, 614-(int)(55.5*i), 57, 30);
    	   add(leftlabel[i]);
       }
       
       

       
       
   
		
		
       
      
       
       
       ImgPanel = new Chart_ImgPanel();
       ImgPanel.setBounds(74, 114, 921, 530);
       add(ImgPanel);
       LocPanel=new Chart_LocPanel();
       LocPanel.setOpaque(false);
       LocPanel.setBounds(74, 114, 921, 530);
       add(LocPanel);
        MaPanel=new MA_ImgPanel();
        MaPanel.setBounds(74, 114, 921, 530);
        add(MaPanel);
        
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
						System.out.println(TimeGetter.getToday());
						DataInit(numOfStocks,nameOfStocks,TimeGetter.getToday());
						labelInit();
						KChart_BasePanel.this.repaint();
						
					}//选择的是当月
					else{			
						
						String endday=TimeGetter.getDayBefore(temp, -55);
						
						
						DataInit(numOfStocks,nameOfStocks,endday);
						labelInit();
						KChart_BasePanel.this.repaint();
	
					}//选择的不是当月
					
					
				}
				
				
				
			}//日期调整结束
			
			
			
		}
  
       });
       add(btnNewButton_2);
       
       lblMa = new JLabel("MA5：");
       lblMa.setForeground(Color.BLUE);
       lblMa.setFont(new Font("微软雅黑", Font.BOLD, 18));
       lblMa.setBounds(574, 19, 130, 39);
       add(lblMa);
       
       lblMa_1 = new JLabel("MA10：");
       lblMa_1.setForeground(Color.WHITE);
       lblMa_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
       lblMa_1.setBounds(707, 19, 130, 39);
       add(lblMa_1);
       
       lblMa_2 = new JLabel("MA20：");
       lblMa_2.setForeground(Color.YELLOW);
       lblMa_2.setFont(new Font("微软雅黑", Font.BOLD, 18));
       lblMa_2.setBounds(840, 19, 130, 39);
       add(lblMa_2);
	}
	
	public void DataInit(String numOfStock,String nameOfStock,String date){
		 StocksList=new ArrayList<StocksVO>();			
		 ma5List=new ArrayList<Double>();
		 ma10List=new ArrayList<Double>();
		 ma20List=new ArrayList<Double>();
		nameOfStocks=nameOfStock;
		numOfStocks=numOfStock;
		
		
		lblNewLabel.setText(nameOfStocks+"(hs"+numOfStocks+")");
		
		totalList= TimePusher_ita2.getStocksBefore(numOfStocks, date, 75);
		
		
		
		
		//PreList
		for(int i=19;i<75;i++){
			StocksList.add(totalList.get(i));
		}
		
		
		for(int i=0;i<56;i++){
			StocksVO tempVO=StocksList.get(i);
			if(i!=0){
				if(max<Double.parseDouble(tempVO.getHigh()))
					 max=Double.parseDouble(tempVO.getHigh());
					if(min>Double.parseDouble(tempVO.getLow()))
					  min=Double.parseDouble(tempVO.getLow());
				
				
				
			}
			else{
				 max=Double.parseDouble(tempVO.getHigh());
				 min=Double.parseDouble(tempVO.getLow());
				
			}		
		}
		
		for(int i=0;i<56;i++){
			
			double ma5=0;
			double ma10=0;
			double ma20=0;
			
			for(int k=0;k<5;k++){
				ma5+=Double.parseDouble(totalList.get(i+19-k).getClose());
				
			}
			for(int k=0;k<10;k++){
				ma10+=Double.parseDouble(totalList.get(i+19-k).getClose());
			}
			for(int k=0;k<20;k++){
				ma20+=Double.parseDouble(totalList.get(i+19-k).getClose());
			}
			ma5=ma5/5;
			ma10=ma10/10;
			ma20=ma20/20;
			if(ma5>max)
				max=ma5;
			if(ma5<min)
			    min=ma5;
			if(ma10>max)
				max=ma10;
			if(ma10<min)
			    min=ma10;
			if(ma20>max)
				max=ma20;
			if(ma20<min)
			    min=ma20;
			
			
			ma5List.add(ma5);
			ma10List.add(ma10);
			ma20List.add(ma20);
		}
		
		
		
		perXiangSu=500/(max-min);
		LocChartReboot();
	}
	
	public void labelInit(){
		leftlabel[0].setText(String.valueOf(min));
		double x=(max-min)/9;
		for(int i=1;i<10;i++){
			DecimalFormat df = new DecimalFormat("0.00");
			 
			String db = df.format(min+i*x);
			leftlabel[i].setText(db);
		
		}
		
		
		
		lblNewLabel_1.setText(StocksList.get(9).getDate());
		label_9.setText(StocksList.get(20).getDate());
		label_11.setText(StocksList.get(31).getDate());
		label_10.setText(StocksList.get(43).getDate());
	}
	
	void setInfo(int select){
		DecimalFormat df = new DecimalFormat("0.00");
		 
		
		
		StocksVO temp=StocksList.get(select);
	
		
		label.setText(temp.getDate());
		label_1.setText("开："+temp.getOpen());
		label_2.setText("收："+temp.getClose());
		label_3.setText("高："+temp.getHigh());
		label_4.setText("低："+temp.getLow());
		label_5.setText("换："+df.format(Double.parseDouble(temp.getTurnover()))+"%");
		label_6.setText("净："+df.format(Double.parseDouble(temp.getPb()))+"%");
		label_7.setText("成交量："+temp.getVolume());
		lblMa.setText("MA5："+df.format(ma5List.get(select)));
		lblMa_1.setText("MA10："+df.format(ma10List.get(select)));
		lblMa_2.setText("MA20："+df.format(ma20List.get(select)));
	}
	void LocChartReboot(){
		xLoc=2000;
		yLoc=2000;
		
	}
	 private void buttonSet(JButton btnNewButton,String img){
    	 btnNewButton.setBackground(new Color(255,255,255));  
 	    btnNewButton.setBorder(null); 
 	    btnNewButton.setOpaque(false);
 	   Icon stockWatch=new ImageIcon("Img/"+img);
	    btnNewButton.setIcon(stockWatch);
    	
    	
    	
    }
}
