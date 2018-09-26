package presentation.ita2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentation.ita1.Panel_Waiting;

public class TestFr extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFr frame = new TestFr();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestFr() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel WaitPanel = new JPanel();
		WaitPanel.setBounds(0, 0, 1274, 690);
		contentPane.add(WaitPanel);
		
		
		WaitPanel.setSize( 1274, 690);
		WaitPanel.setOpaque(false);		
		WaitPanel.setLayout(null);
	    
		
		
		JLabel lblNewLabel_5 = new JLabel("获取数据中，请稍候……");
	    lblNewLabel_5.setForeground(new Color(255, 255, 255));
	    lblNewLabel_5.setFont(new Font("楷体", Font.BOLD, 30));
	    lblNewLabel_5.setBounds(420, 202, 508, 101);
	    WaitPanel.add(lblNewLabel_5);
	    
	
	}
}
