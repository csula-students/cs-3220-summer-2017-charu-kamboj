package lab4;

import java.util.List;

public class Order {

	public enum Status {
		IN_QUEUE, IN_PROGRESS, COMPLETED
	}

	public final int id;
	public final List<CreateFoodEntry> items;
	public final String customerName;
	public String status;
	

	public Order (int id, List<CreateFoodEntry> items, String customerName, String status) {
		this.id = id;
		this.items = items;
		this.customerName = customerName;
		this.status = status;
		
		
	}
	
	public int getId() {
		return id;
	}

	public List<CreateFoodEntry> getItems() {
		return items;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getStatus() {
		return status;
	}

	
}