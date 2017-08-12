package homework4;

import java.util.Date;
import java.util.List;

public class Order {

	public enum Status{
		IN_QUEUE,IN_PROGRESS,COMPLETED
	}
	
	public int id; 
	public List<CreateFoodEntry> items;
	public String customer_name;
	public String status;
	public Date order_time;
	
	public Order(int id, List<CreateFoodEntry> items,String customer_name,String status,Date time){
	
		this.id=id;
		this.items=items;
		this.customer_name=customer_name;
		this.status=status;
		this.order_time=time;
	}
	
	public int getID(){
		return id;
		
	}
	public List<CreateFoodEntry> getItems() {
		return items;
}
	
	public  String getCustomerName(){
		return customer_name;
	}
	
	public String getstatus(){
		return status;
		
	}
	
	public Date getOrdertime(){
		return order_time;
	}
	
}

