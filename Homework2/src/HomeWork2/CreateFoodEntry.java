package homework2;

public class CreateFoodEntry {
	public  int id;
	public  String name; 
	public  String description;
	public  String img_url;
	public  double price;
	
	
	public CreateFoodEntry(int id,String name,String description,String img_url,double price){
		this.id=id;
		this.name=name;
		this.description=description;
		this.img_url=img_url;
		this.price=price;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name; 
	}
	
	public String getDescription(){
	
		return description;
	}
	
	public String getImg_url(){
		return img_url;
	}
	
	public double getPrice(){
		return price;
	}

}