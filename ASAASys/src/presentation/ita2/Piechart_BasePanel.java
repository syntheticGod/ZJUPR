package presentation.ita2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ita2.Atr_BasePanel.Chart_LocPanel;
import vo.AtrVO;
import vo.PiechartDataVO;
import javax.swing.SwingConstants;

public class Piechart_BasePanel extends JPanel {
     private ArrayList<PiechartDataVO> datalist;
	 private double beginpoint[];
	 private double endpoint[];
	 private JLabel label[];
	 private Piechart_ImgPanel imgPanel;
	 private Piechart_LocPanel locPanel;
	 private Piechart_LabelPanel labelPanel;
	 private JLabel label_hangye;
	 private JLabel label_1;
	 private JLabel label_2;
	 private JLabel label_3;
	 private JLabel label_4;
	 private int selected;
	 private JLabel label_5;
	 private Color color[];
	 
	 /**
	  * 提示标志前的带颜色小方块
	  */
	 protected void paintComponent(Graphics g) {
			super.paintComponent(g);//保留该面板上的其他组件
			
			((Graphics2D)g).setColor(Color.cyan);
		     
		      
		      ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		      for(int i=0;i<datalist.size();i++){
		    	  if(0<=i&&i<10){
		    		  ((Graphics2D)g).setColor(color[i]);
			    	  g.fillRect(55, 60+(int)(53.3*i), 35, 35);
		    	  }
		    	  else if(10<=i&&i<20){
		    		  ((Graphics2D)g).setColor(color[i]);
			    	  g.fillRect(755, 60+(int)(53.3*(i-10)), 35, 35);

		    	  }
  
		      }
			
		}
	 
	 
	 
	 class loc{
		 double x;
		 double y;
		 int yangshi;
		 loc(double x,double y,int yangshi){
			 this.x=x;
			 this.y=y;
			 this.yangshi=yangshi;
		 }
         void setx(double x){
        	 this.x=x;
        	 
         }
         
         void sety(double y){
        	 this.y=y;
        	 
         }
         void setyangshi(int yangshi){
        	 this.yangshi=yangshi;
         }
	 }
	 
	 class Piechart_LabelPanel extends JPanel{
		 Piechart_LabelPanel(){
			    super();
			    
			    this.setOpaque(false);
			    setLayout(null);
			  
			    this.setVisible(true);
			 
		 }
		 
	 }
	 
	 class Piechart_ImgPanel extends JPanel{
		/*
		 protected void paintComponent(Graphics g) {
				super.paintComponent(g);//保留该面板上的其他组件
				
				((Graphics2D)g).setColor(Color.cyan);
			     
			      
			      ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g.fillArc(0, 0, 400, 400, 0, 350);//里面的值为“直径”
				
			}测试用绘图
		 */
		 
		 protected void paintComponent(Graphics g) {
				super.paintComponent(g);//保留该面板上的其他组件
				
				((Graphics2D)g).setColor(Color.cyan);
			     
			      
			      ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				
			      for(int i=0;i<datalist.size();i++){
			    	  if(i==selected)  
			    	  ((Graphics2D)g).setColor(new Color(color[i].getRed(),color[i].getGreen(),color[i].getBlue(),200));
			    	  else
			    		  ((Graphics2D)g).setColor(color[i]);
			    	  g.fillArc(0, 0, 400, 400, (int)beginpoint[i], (int)endpoint[i]-(int)beginpoint[i]);
			    	  
			      }
			 
				
			}
		 
		 Piechart_ImgPanel(){
			    super();
			    
			    this.setOpaque(false);
			    setLayout(null);
			  
			    this.setVisible(true);
			 
		 }


				
			  
				
	 }
	 
	 class Piechart_LocPanel extends JPanel{
		
		 
		 protected void paintComponent(Graphics g) {
				super.paintComponent(g);//保留该面板上的其他组件

		 }
		 
		 Piechart_LocPanel(){
				super();
			    this.setSize(400, 400);
			    this.setOpaque(false);
			    setLayout(null);
			  
			    this.setVisible(true);
			 
			    this.addMouseListener(new MouseListener(){

				 
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					double x=e.getX()-200;			
					double y=e.getY()-200;	
					double length=Math.sqrt(x*x+y*y);
					double angle=Math.acos(x/length)/Math.PI*180;
					if(y>0)
						angle=360-angle;
					
					for(int i=0;i<datalist.size();i++){
						if(beginpoint[i]<=angle&&endpoint[i]>=angle){
							setInfo(i);
							selected=i;
							break;
						}
						
						
					}
					
					Piechart_LocPanel.this.requestFocus();
					Piechart_BasePanel.this.repaint();
					
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
	public Piechart_BasePanel() {
		//颜色列表初始化
		color=new Color[20];
//		for(int i=0;i<20;i++){
//			if(i%2==0)
//			color[i]=new Color(255-i*12,0+i*12,128+i/2*12);
//			else
//		    color[i]=new Color(0+i*12,255-i*12,128-(i+1)/2*12);
//	
//		}
		color[0]=Color.blue;
		color[1]=Color.black;
		color[2]=Color.cyan;
		color[3]=Color.gray;
		color[4]=Color.green;
		color[5]=Color.magenta;
		color[6]=Color.orange;
		color[7]=Color.pink;
		color[8]=Color.red;
		color[9]=Color.white;
		color[10]=Color.yellow;
		color[11]=new Color(221,160,221);
		color[12]=new Color(100,149,237);
		color[13]=new Color(0,250,154);
		color[14]=new Color(255,215,0);
		color[15]=new Color(255,222,173);
		color[16]=new Color(255,69,0);
		color[17]=new Color(255,228,181);
		color[18]=new Color(173,255,47);
		color[19]=new Color(173,216,230);
		
		selected=-1;
		 this.setPreferredSize(new Dimension(995, 600));
	       this.setOpaque(false);
	       setLayout(null);
	       labelPanel=new Piechart_LabelPanel();
		   labelPanel.setBounds(0, 0, 995, 600);
		   add(labelPanel);
	       imgPanel =new Piechart_ImgPanel();
	       imgPanel.setBounds(292, 95, 400, 400);
		   add(imgPanel);
		   locPanel =new Piechart_LocPanel();
		   locPanel.setBounds(292, 95, 400, 400);
		   add(locPanel);
		   
		   label_hangye = new JLabel("行业");
		   label_hangye.setHorizontalAlignment(SwingConstants.CENTER);
		   label_hangye.setForeground(Color.WHITE);
		   label_hangye.setFont(new Font("微软雅黑", Font.BOLD, 20));
		   label_hangye.setBounds(104, 558, 115, 31);
		   add(label_hangye);
		   
		   label_1 = new JLabel("值：",JLabel.CENTER);
		   label_1.setForeground(Color.WHITE);
		   label_1.setFont(new Font("微软雅黑", Font.BOLD, 20));
		   label_1.setBounds(364, 558, 225, 31);
		   add(label_1);
		   
		   label_2 = new JLabel("百分比：");
		   label_2.setHorizontalAlignment(SwingConstants.CENTER);
		   label_2.setForeground(Color.WHITE);
		   label_2.setFont(new Font("微软雅黑", Font.BOLD, 20));
		   label_2.setBounds(601, 558, 120, 31);
		   add(label_2);
		   
		   label_3 = new JLabel("总计：");
		   label_3.setForeground(Color.WHITE);
		   label_3.setFont(new Font("微软雅黑", Font.BOLD, 20));
		   label_3.setBounds(733, 558, 225, 31);
		   add(label_3);
		   
		   label_4 = new JLabel("单位");
		   label_4.setHorizontalAlignment(SwingConstants.CENTER);
		   label_4.setForeground(Color.WHITE);
		   label_4.setFont(new Font("微软雅黑", Font.BOLD, 20));
		   label_4.setBounds(256, 558, 96, 31);
		   add(label_4);
		   
		   label_5 = new JLabel("表名",JLabel.CENTER);
		   label_5.setForeground(Color.WHITE);
		   label_5.setFont(new Font("微软雅黑", Font.BOLD, 20));
		   label_5.setBounds(322, 11, 377, 31);
		   add(label_5);
		   
		  
		   
		   label=new JLabel[20];
		   for(int i=0;i<10;i++){
	    	   label[i]=new JLabel("");
	    	   label[i].setForeground(Color.WHITE);
	    	   label[i].setFont(new Font("微软雅黑", Font.BOLD, 18));
	    	   label[i].setBounds(100, 60+(int)(53.3*i), 150, 35);
	    	   add(label[i]);
	       }
		   
		   for(int i=10;i<20;i++){
	    	   label[i]=new JLabel("");
	    	   label[i].setForeground(Color.WHITE);
	    	   label[i].setFont(new Font("微软雅黑", Font.BOLD, 18));
	    	   label[i].setBounds(800, 60+(int)(53.3*(i-10)), 150, 35);
	    	   add(label[i]);
	       }
		   
		   
	}

	
	public void DataInit(ArrayList<PiechartDataVO> datalist){
		this.datalist=datalist;
		beginpoint=new double[datalist.size()];
		endpoint=new double[datalist.size()];
		double tempPoint=0;
		for(int i=0;i<datalist.size();i++){
			beginpoint[i]=tempPoint;
			endpoint[i]=tempPoint+360*datalist.get(i).getbili();
			tempPoint=endpoint[i];
			label[i].setText(datalist.get(i).getlabel());
		}
		selected=-1;
	}
	/**
	 * 比例标识符初始化
	 * 
	 * 
	 * 
	 */
	public void LabelInit(){
		DecimalFormat df = new DecimalFormat("0.0%");
		labelPanel.removeAll();
		
		 
		for(int i=0;i<datalist.size();i++){
			loc Labelloc=getLabelLoc(beginpoint[i],endpoint[i]);

			
			JLabel bililabel=new JLabel(df.format(datalist.get(i).getbili()),Labelloc.yangshi);
			bililabel.setForeground(Color.WHITE);
			bililabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
			bililabel.setBounds((int)Labelloc.x, (int)Labelloc.y, 55, 20);
			labelPanel.add(bililabel);
		}
	    	double zongzhi=0;
			for(int k=0;k<datalist.size();k++){
				zongzhi+=datalist.get(k).getdata();
				
			}
			df = new DecimalFormat("0.00");
			label_3.setText("共计："+df.format(zongzhi));
		
		repaint();
	}
	/**
	 * 设置单位
	 * @param str 单位的名字，不用带括号
	 */
	public void setDanwei(String str){
		label_4.setText("("+str+")");
	}
	/**
	 * 设置表名
	 * @param str 表名
	 */
	public void setHead(String str){
		label_5.setText(str);
	}
	public void setZongzhi(String str){
		label_3.setText("总计："+str);
	}
	/**
	 * 给监听标志设置值
	 */
	private void setInfo(int i){
		label_hangye.setText(datalist.get(i).getlabel());
		DecimalFormat df = new DecimalFormat("0.0%");
		label_1.setText(String.valueOf(datalist.get(i).getdata()));
		label_2.setText(df.format(datalist.get(i).getbili()));
		
	}
	
	private loc getLabelLoc(double beginpoint,double endpoint ){
		double mid=(beginpoint+endpoint)/2;
		double hudu=mid/180*Math.PI;
		loc Loc=new loc(0,0,0);
		
		//文本框长为55，宽为20，字号15
		if(0<=mid&&mid<=90){
			double x=492+200*Math.cos(hudu);
			double y=295-200*Math.sin(hudu);
			Loc.setx(x);
			Loc.sety(y-20);
			Loc.setyangshi(SwingConstants.LEFT);
		}
		else if(90<mid&&mid<=180){
			double x=492+200*Math.cos(hudu);
			double y=295-200*Math.sin(hudu);
			Loc.setx(x-55);
			Loc.sety(y-20);
			Loc.setyangshi(SwingConstants.RIGHT);
		}
        else if(180<mid&&mid<=270){
        	double x=492+200*Math.cos(hudu);
			double y=295-200*Math.sin(hudu);
			Loc.setx(x-55);
			Loc.sety(y);
			Loc.setyangshi(SwingConstants.RIGHT);
		}
        else if(270<mid&&mid<=360){
        	double x=492+200*Math.cos(hudu);
			double y=295-200*Math.sin(hudu);
			Loc.setx(x);
			Loc.sety(y);
			Loc.setyangshi(SwingConstants.LEFT);
		}
		
		return Loc;
	}
}
