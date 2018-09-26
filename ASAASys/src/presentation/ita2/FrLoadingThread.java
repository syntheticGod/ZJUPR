package presentation.ita2;

import presentation.ita1.UI;

public 	class FrLoadingThread extends Thread{ 
	   

	public void run() {
		FrWaitThread f=new FrWaitThread();
		f.start();
		UI frame = new UI();		
        f.setend();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();  
        }
        frame.setVisible(true);
}
}
