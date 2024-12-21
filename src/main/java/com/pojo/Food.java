package com.pojo;

public class Food {
	
//	instance variables
	private int foodID;
	private String foodType;
	private String foodName;
	private int foodQuantity;
	private float foodPrice;
	
	public Food() {
		super();
	}
	
// constructor
	public Food(String foodType, String foodName, int foodQuantity, float foodPrice) {
		super();
		this.foodType = foodType;
		this.foodName = foodName;
		this.foodQuantity = foodQuantity;
		this.foodPrice = foodPrice;
	}

	public int getFoodID() {
		return foodID;
	}

	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getFoodQuantity() {
		return foodQuantity;
	}

	public void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
	}

	public float getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(float foodPrice) {
		this.foodPrice = foodPrice;
	}

	@Override
	public String toString() {
		return "Food: Food-ID = " + foodID + ", Food Type = " + foodType + ", Food Name = " + foodName + ", Food Quantity = "
				+ foodQuantity + ", Food Price = " + foodPrice + ".";
	}

}
