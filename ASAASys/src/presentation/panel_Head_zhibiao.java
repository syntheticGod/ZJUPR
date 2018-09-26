package presentation;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;

public class panel_Head_zhibiao extends JPanel {

	/**
	 * Create the panel.
	 */
	public panel_Head_zhibiao() {
this.setSize(995, 70);
setLayout(null);
JComboBox comboBox = new JComboBox();
comboBox.setForeground(Color.WHITE);
comboBox.setFont(new Font("微软雅黑", Font.BOLD, 13));
comboBox.setModel(new DefaultComboBoxModel(new String[] {"乖离率", "心理线", "均幅指标", "能量潮", "容量比率", "顺势指标", "趋向指标", "随机指标", "相对强弱指标"}));
comboBox.setBounds(38, 26, 84, 33);
comboBox.setOpaque(false);
add(comboBox);
	}
}
