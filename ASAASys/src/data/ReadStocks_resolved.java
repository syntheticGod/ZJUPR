package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ReadStocks_resolved {

	public void init(){
		ArrayList<String> list=new ArrayList<String>();
		list.add("begin");
		
		
		FileOutputStream filestream1;
		try {
			filestream1 = new FileOutputStream("StocksData.dat");
			try {
				ObjectOutputStream od=new ObjectOutputStream(filestream1);
				od.writeObject(list);
				od.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	
	public ArrayList<String> getStocks(){
		
		ArrayList<String> list=new ArrayList<String>();
		
		try {
			FileInputStream filestream=new FileInputStream("StocksData.dat");
			try {
				ObjectInputStream os=new ObjectInputStream(filestream);
				try {
					Object one=os.readObject();
					os.close();
					list=(ArrayList<String>) one;
					/*
					FileOutputStream filestream1=new FileOutputStream("Loaddata.dat");
					try {
						ObjectOutputStream od=new ObjectOutputStream(filestream1);
						od.writeObject(list);
						od.close();
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
					*/
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	
	}
	
	public void addStock(String str){
		
		
		try {
			FileInputStream filestream=new FileInputStream("StocksData.dat");
			try {
				ObjectInputStream os=new ObjectInputStream(filestream);
				try {
					Object one=os.readObject();
					os.close();
					ArrayList<String> list=(ArrayList<String>) one;
					
						list.add(str);
					
					FileOutputStream filestream1=new FileOutputStream("StocksData.dat");
					try {
						ObjectOutputStream od=new ObjectOutputStream(filestream1);
						od.writeObject(list);
						od.close();
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
					
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public boolean checkStock(String str){
		boolean ans=true;
		
		try {
			FileInputStream filestream=new FileInputStream("StocksData.dat");
			try {
				ObjectInputStream os=new ObjectInputStream(filestream);
				try {
					Object one=os.readObject();
					os.close();
					ArrayList<String> list=(ArrayList<String>) one;
					if(list.contains(str))
						ans=false;
					
					
				
					
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return ans;
	}
	
	
	
	
	
	
	
	
	
	
	public void removeStock(String str){
		try {
			FileInputStream filestream=new FileInputStream("StocksData.dat");
			try {
				ObjectInputStream os=new ObjectInputStream(filestream);
				try {
					Object one=os.readObject();
					os.close();
					ArrayList<String> list=(ArrayList<String>) one;
					list.remove(str);
					
					FileOutputStream filestream1=new FileOutputStream("StocksData.dat");
					try {
						ObjectOutputStream od=new ObjectOutputStream(filestream1);
						od.writeObject(list);
						od.close();
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
					
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
