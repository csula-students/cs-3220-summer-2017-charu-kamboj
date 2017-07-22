package lab4;

public class CreateFoodEntry {
public int id=0;
public String name=null;
public double price=0.0;

public CreateFoodEntry(int id,String name,double price){
	this.id=id;
	this.name=name;
	this.price=price;
}

public int getId(){
	return id;
	
}

public String getName(){
	return name;
	
}
public double getPrice(){
	return price;
	
}

}