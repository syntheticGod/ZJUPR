package presentation.ita2;

import presentation.ita1.UI;

public class FrWaitThread extends Thread{ 
	   private LoadingFrame f;
       private boolean end;
	public void run() {
        end=false;
		for(int i=0;i<10000;i++){
			if(i==0){
				f=new LoadingFrame();
				f.setVisible(true);
			}
			else{
				try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();  
                }
				if(end){
					f.dispose();
					break;
				}
				
				
			}
			
		 
			
			
			
			
		}
  
}
	public void setend(){
		end=true;
	}
	
	
}
