package com.pojo;

public class Cart {
	
	private int cartID;
	private int foodID;
	private String foodName;
	private int quantity;
	private String emailID;
	private float foodPrice;
	private float totalPrice;
	
	public Cart() {
		super();
	}

	public Cart( int foodID, String foodName, int quantity, String emailID, float foodPrice,
			float totalPrice) {
		super();
		this.foodID = foodID;
		this.foodName = foodName;
		this.quantity = quantity;
		this.emailID = emailID;
		this.foodPrice = foodPrice;
		this.totalPrice = totalPrice;
	}

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public int getFoodID() {
		return foodID;
	}

	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public float getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(float foodPrice) {
		this.foodPrice = foodPrice;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Cart: Cart-ID = " + cartID + ", Food-ID = " + foodID + ", Food Name = " + foodName + ", Quantity = " + quantity
				+ ", Email-ID = " + emailID + ", Food Price=" + foodPrice + ", Total Price = " + totalPrice + ".";
	}

}
