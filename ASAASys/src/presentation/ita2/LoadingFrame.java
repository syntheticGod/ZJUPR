package presentation.ita2;

import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.awt.event.MouseAdapter;  
import java.awt.event.MouseEvent;  
import java.awt.event.MouseMotionAdapter;  
  
import javax.swing.ImageIcon;  
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JLayeredPane;  
import javax.swing.JPanel;

public class LoadingFrame extends JFrame {  
    
    public static void main(String[] args) {  
    	LoadingFrame j = new LoadingFrame();  
        j.setVisible(true);  
    }  
      
    private static final long serialVersionUID = 1L;  
    //用于处理拖动事件，表示鼠标按下时的坐标，相对于JFrame  
    int xOld = 0;  
    int yOld = 0;  
      
    public LoadingFrame() {  
        this.setLayout(null);  
  
        //处理拖动事件  
        this.addMouseListener(new MouseAdapter() {  
            @Override  
            public void mousePressed(MouseEvent e) {  
                xOld = e.getX();  
                yOld = e.getY();  
            }  
        });  
        this.addMouseMotionListener(new MouseMotionAdapter() {  
            @Override  
            public void mouseDragged(MouseEvent e) {  
                int xOnScreen = e.getXOnScreen();  
                int yOnScreen = e.getYOnScreen();  
                int xx = xOnScreen - xOld;  
                int yy = yOnScreen - yOld;  
                LoadingFrame.this.setLocation(xx, yy);  
            }  
        });  
  
        //JLayeredPane用于添加两个图层的，一个用于背景，一个用于界面  
        JLayeredPane layeredPane = new JLayeredPane();  
        layeredPane.setBounds(0, 0, 340, 338);  
        this.add(layeredPane);  
          
        //背景Panel  
        JPanel bgPanel = new JPanel();  
        bgPanel.setBounds(0, 0, 340, 338);  
        layeredPane.add(bgPanel);  
          
        //背景图片，添加到背景Panel里面  
        JLabel bgLabel = new JLabel(new ImageIcon("Img/Loading.png"));  
        bgPanel.add(bgLabel);  
          


          
        this.setBounds(600,400,340,338);  
        this.setUndecorated(true);  
    }  
}  