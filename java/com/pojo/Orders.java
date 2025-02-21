package com.pojo;

public class Orders {
	
	private int orderID;
	private String orderName;
	private String emailID;
	private String orderDate;
	private float totalPrice;
	
	public Orders() {
		super();
	}

	public Orders(int orderID, String orderName, String emailID, String orderDate, float totalPrice) {
		super();
		this.orderID = orderID;
		this.orderName = orderName;
		this.emailID = emailID;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Orders: Order-ID = " + orderID + ", Order Name = " + orderName + ", Email-ID = " + emailID + ", Order Date = "
				+ orderDate + ", Total Price = " + totalPrice + ".";
	}

}
