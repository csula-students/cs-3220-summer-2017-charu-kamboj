package lab6;

public class CreateFoodEntry {

	final int id; 
	final String foodName;
	final String imgurl;
	final String description;
	final double price;
	
	public CreateFoodEntry(int id, String item, String image, String description, double price) {

		this.id = id;
		this.foodName = item;
		this.description = description;
		this.imgurl = image;
		this.price = price;
		
	}
	
	public int getId(){
		return id; 
	}
	
	public String getName(){
		return foodName;
	}
	
	public String getImage(){
		return imgurl;
	}
	
	public String getDesc(){
		return description;
	}
	public double getPrice(){
		return price;
		
	}
	
	
}
