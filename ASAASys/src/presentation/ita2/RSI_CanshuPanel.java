package presentation.ita2;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class RSI_CanshuPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public RSI_CanshuPanel() {
this.setSize(995, 100);
this.setOpaque(false);
this.setLayout(null);
textField = new JTextField();
textField.setBounds(294, 40, 76, 22);
add(textField);
textField.setColumns(10);
JLabel lblNewLabel = new JLabel("参数设置");
lblNewLabel.setForeground(Color.WHITE);
lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
lblNewLabel.setBounds(42, 34, 84, 33);
add(lblNewLabel);
JLabel lblRsi = new JLabel("RSI1:");
lblRsi.setForeground(Color.WHITE);
lblRsi.setFont(new Font("微软雅黑", Font.BOLD, 18));
lblRsi.setBounds(221, 33, 61, 33);
add(lblRsi);

	}
}
