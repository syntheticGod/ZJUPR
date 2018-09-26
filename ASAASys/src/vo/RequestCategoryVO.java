package vo;

public class RequestCategoryVO {
      private String id;
      private String name;
      
      public RequestCategoryVO(String id,String name){
    	  this.id=id;
    	  this.name=name;
    	  
      }
      
      public void setid(String id){
    	  this.id=id;
      }
      
      public void setname(String name){
    	  this.name=name;
      }
      
      
      public String getid(){
    	  return id;
      }
      
      public String getname(){
    	  return name;
      }
      
}
