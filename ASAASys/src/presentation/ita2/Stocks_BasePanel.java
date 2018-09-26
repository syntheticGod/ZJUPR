package presentation.ita2;

import java.awt.Dimension;

import javax.swing.JPanel;

import presentation.ita1.TimeGetter;

public class Stocks_BasePanel extends JPanel {

	String numOfStock;
	String nameOfStock;
	
	
	
	
	
	
	
	
	
	/**
	 * Create the panel.
	 */
	public Stocks_BasePanel() {
//		VolumeChartPanel.DataInit(numOfStock, nameOfStock, TimeGetter.getToday());
//		VolumeChartPanel.ShoushulabelInit();
//		VolumeChartPanel.setVisible(true);
//		panel_input_stocks.setVisible(false);
//		panel_present_stocks.setVisible(false);	
		this.setPreferredSize(new Dimension(995, 690));
	       this.setOpaque(false);
	       setLayout(null);
		
		
		
		
		
		
	}

	
	
	public void DataInit(String numOfStock,String nameOfStock){
		this.nameOfStock=numOfStock;
		this.nameOfStock=nameOfStock;
		
	}
}
