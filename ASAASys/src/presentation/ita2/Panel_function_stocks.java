package presentation.ita2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel_function_stocks extends JPanel {

	/**
	 * Create the panel.
	 */
	public Panel_function_stocks() {

		JPanel panel_function_stocks= new JPanel();
		panel_function_stocks.setVisible(false);
	    panel_function_stocks.setForeground(Color.WHITE);
	    panel_function_stocks.setBounds(0, 170, 279, 520);
	    
	    panel_function_stocks.setLayout(null);
	    panel_function_stocks.setOpaque(false);//透明
	    
	    JButton Button_Stock1 = new JButton("交易记录");
	    Button_Stock1.setFont(new Font("楷体", Font.BOLD, 24));
	    Button_Stock1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	
	    	}
	    });
	    Button_Stock1.setBounds(61, 24, 160, 46);
	    panel_function_stocks.add(Button_Stock1);
		
	    JButton Button_Stock2 = new JButton("各项指标");
	    Button_Stock2.setFont(new Font("楷体", Font.BOLD, 24));
	    Button_Stock2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	
	    	}
	    });
	    Button_Stock2.setBounds(61, 83, 160, 46);
	    panel_function_stocks.add(Button_Stock2);
	    
	    JButton Button_Stock3 = new JButton("K线图");
	    Button_Stock3.setFont(new Font("楷体", Font.BOLD, 24));
	    Button_Stock3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	
	    	}
	    });
	    Button_Stock3.setBounds(61, 142, 160, 46);
	    panel_function_stocks.add(Button_Stock3);
	    
	    JButton Button_Stock4 = new JButton("成交量图");
	    Button_Stock4.setFont(new Font("楷体", Font.BOLD, 24));
	    Button_Stock4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	
	    	}
	    });
	    Button_Stock4.setBounds(61, 201, 160, 46);
	    panel_function_stocks.add(Button_Stock4);
	    
	    JButton Button_Stock5 = new JButton("返回");
	    Button_Stock5.setFont(new Font("楷体", Font.BOLD, 24));
	    Button_Stock5.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	
	    	}
	    });
	    Button_Stock5.setBounds(61, 260, 160, 46);  
	    panel_function_stocks.add(Button_Stock5);
	}
	

	
}
