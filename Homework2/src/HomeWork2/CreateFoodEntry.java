package HomeWork2;

public class CreateFoodEntry {
	public final int id;
	public final String name; 
	public final String description;
	public final String img_url;
	public final int price;
	
	
	public CreateFoodEntry(int id,String name,String description,String img_url,int price){
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
	
	public int getPrice(){
		return price;
	}

}
