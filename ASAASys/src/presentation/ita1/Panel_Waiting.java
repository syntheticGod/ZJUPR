package presentation.ita1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel_Waiting extends JPanel {

	/**
	 * Create the panel.
	 */
	public Panel_Waiting() {
		JPanel WaitPanel = new JPanel();
	    
		WaitPanel.setSize( 1274, 690);
		WaitPanel.setOpaque(false);		
		WaitPanel.setLayout(null);
	    
		
		
		JLabel lblNewLabel_5 = new JLabel("获取数据中，请稍候……");
	    lblNewLabel_5.setForeground(new Color(255, 255, 255));
	    lblNewLabel_5.setFont(new Font("楷体", Font.BOLD, 30));
	    lblNewLabel_5.setBounds(420, 202, 508, 101);
	    WaitPanel.add(lblNewLabel_5);
	    
//		JLabel imag=new JLabel(new ImageIcon("Drive.gif"));
//		   imag.setBounds(0, 0, 320, 240);
//		   WaitPanel.add(imag);
	    
	}

}
