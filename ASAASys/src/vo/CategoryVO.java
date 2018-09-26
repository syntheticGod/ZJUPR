package vo;

public class CategoryVO {
	private String id;
	private String name;
	private String category;
	
	public CategoryVO(String id,String name,String category){
		this.id=id;
		this.name=name;
		this.category=category;
	}

	public void setid(String id){
		this.id=id;
	}
	public void setname(String name){
		this.name=name;
	}
	public void setcategory(String category){
		this.category=category;
	}
	
	public String getid(){
		return id;
	}
	
	public String getname(){
		return name;
	}
	
	public String getcategory(){
		return category;
	}
}
