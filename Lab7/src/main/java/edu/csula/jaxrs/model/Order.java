package edu.csula.jaxrs.model;



public class Order {

	

	public int id;
	public String customerName;
	public String status;

    public enum Status {
		IN_QUEUE, IN_PROGRESS, COMPLETED
	}

	public Order () {
		
	}

	public Order (int id, String customerName, String status) {
		this.id = id;
		this.customerName = customerName;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}



	public String getCustomerName() {
		return customerName;
	}

	public String getStatus() {
		return status;
	}


}