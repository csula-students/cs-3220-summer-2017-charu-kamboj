package homework2;

import java.util.Date;

public class Orders {
	public static int Id=0;
	public final CreateFoodEntry food;
	public static String customer_name=null;
	public static  Date date=null;
	//public final String s=null;
	enum statuses {
		IN_QUEUE,
		IN_PROGRESS,
		COMPLETED
	}
	
	private String s;
	
	
	 Orders(int Id,CreateFoodEntry items, String customer,String s,Date d){
		this.Id=Id;
		this.food=items;
		this.customer_name=customer;
		this.date=d;
		this.s=s;
		
	}
	 
	 public int getID(){
		 return Id;
	 }
	 
	 public CreateFoodEntry getFood(){
		 return food;
	 }
	public String getName(){
		return customer_name;
	}
	public String getinprogresstatus(){
		return statuses.IN_PROGRESS.toString();
	}
	public String getinqueuestatus(){
		return statuses.IN_QUEUE.toString();
	}
	public String getcompleteStatus(){
		return statuses.COMPLETED.toString();
	}
	public void setStatus(String status) {
		this.s = status;
}
	public String getStatus(){
		return s;
	}
	
	public Date getDate(){
		return date;
	}
	
}
