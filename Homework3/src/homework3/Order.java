package homework3;

import java.util.List;

public class Order {

	public enum Status {
		IN_QUEUE, IN_PROGRESS, COMPLETED
	}

	public final int id;
	public final CreateFoodEntry items;
	public final String customerName;
	public String status;
	

	public Order (int id, CreateFoodEntry cart, String customerName, String status) {
		this.id = id;
		this.items = cart;
		this.customerName = customerName;
		this.status = status;
		
		
	}
	
	public int getId() {
		return id;
	}

	public CreateFoodEntry getItems() {
		return items;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getStatus() {
		return status;
	}

	
}