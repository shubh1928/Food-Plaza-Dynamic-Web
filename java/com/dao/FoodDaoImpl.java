package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Cart;
import com.pojo.Food;
import com.utility.DataConnect;

public class FoodDaoImpl implements FoodDao{
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public boolean addFood(Food food) {
		
		try {
			
			con = DataConnect.getConnection();
			ps = con.prepareStatement("insert into Food (foodType, foodName, foodQuantity, foodPrice) values (?,?,?,?);");
			
			ps.setString(1, food.getFoodType());
			ps.setString(2, food.getFoodName());
			ps.setInt(3, food.getFoodQuantity());
			ps.setFloat(4, food.getFoodPrice());
			
			int row = ps.executeUpdate();
			
			if(row > 0) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateFoodById(Food food) {
		
		try {
			
			con = DataConnect.getConnection();
			ps = con.prepareStatement("update Food set foodType = ?, foodName = ?, foodQuantity = ?, foodPrice = ? where foodID = ?;");
			
			ps.setString(1, food.getFoodType());
			ps.setString(2, food.getFoodName());
			ps.setInt(3, food.getFoodQuantity());
			ps.setFloat(4, food.getFoodPrice());
			ps.setInt(5, food.getFoodID());
			
			int row = ps.executeUpdate();
			
			if(row > 0) {
				return true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		
		return false;
	}

	@Override
	public boolean deleteFoodById(int foodId) {
		
		try {
			
			con = DataConnect.getConnection();
			ps = con.prepareStatement("delete from Food where foodID = ?;");
			
			ps.setInt(1, foodId);
			int row = ps.executeUpdate();
			
			if(row > 0) {
				return true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Food> getAllFood() {
		
		List<Food> l = new ArrayList<Food>();
		
		try {
			
			con = DataConnect.getConnection();
			ps = con.prepareStatement("select * from Food;");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Food food = new Food();
				
				food.setFoodID(rs.getInt("foodID"));
				food.setFoodName(rs.getString("foodName"));
				food.setFoodQuantity(rs.getInt("foodQuantity"));
				food.setFoodType(rs.getString("foodType"));
				food.setFoodPrice(rs.getFloat("foodPrice"));
				
				l.add(food);
			}		
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public Food searchFoodById(int foodId) {
		
		Food food = null;
		
		try {
			
			con = DataConnect.getConnection();
			ps = con.prepareStatement("select * from Food where foodID = ?;");
			
			ps.setInt(1, foodId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				food = new Food();
				
				food.setFoodName(rs.getString("foodName"));
				food.setFoodID(rs.getInt("foodID"));
				food.setFoodQuantity(rs.getInt("foodQuantity"));
				food.setFoodType(rs.getString("foodType"));
				food.setFoodPrice(rs.getFloat("foodPrice"));

			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return food;
	}
	
	@Override
	public boolean updateFoodQun(Food food) {

		try {

			con = DataConnect.getConnection();
			ps = con.prepareStatement("update Food set foodQuantity = ? where foodID = ?;");

			ps.setInt(1, food.getFoodQuantity());
			ps.setInt(2, food.getFoodID());

			int row = ps.executeUpdate();

			if(row > 0) {
				return true;
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
