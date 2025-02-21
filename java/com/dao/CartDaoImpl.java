package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Cart;
import com.pojo.Food;
import com.utility.DataConnect;

public class CartDaoImpl implements CartDao {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public boolean addCart(Cart cart) {
		
		try {
			
			con = DataConnect.getConnection();
			ps = con.prepareStatement("insert into Cart (foodID,foodName,quantity,emailID,foodPrice,totalPrice) values (?,?,?,?,?,?);");
			
			ps.setInt(1, cart.getFoodID());
			ps.setString(2, cart.getFoodName());
			ps.setInt(3, cart.getQuantity());
			ps.setString(4, cart.getEmailID());
			ps.setFloat(5, cart.getFoodPrice());
			ps.setFloat(6, cart.getTotalPrice());
			
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
	public List<Cart> ShowCart(String emailID) {
		
		List<Cart> l = new ArrayList<Cart>();
		
		try {

			con = DataConnect.getConnection();
			ps = con.prepareStatement("select * from Cart where emailID = ?;");			
			ps.setString(1, emailID);
			
			rs = ps.executeQuery();

			while(rs.next()) {
				
				Cart cart = new Cart();

				cart.setCartID(rs.getInt("cartID"));
				cart.setFoodID(rs.getInt("foodID"));
				cart.setFoodName(rs.getString("foodName"));
				cart.setQuantity(rs.getInt("quantity"));
				cart.setEmailID(rs.getString("emailID"));
				cart.setFoodPrice(rs.getFloat("foodPrice"));
				cart.setTotalPrice(rs.getFloat("totalPrice"));

				l.add(cart);
				
			}
			
			   if (l.isEmpty()) {
		            return null;
		        }

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public boolean deleteCart(int cartID) {

		try {

			con = DataConnect.getConnection();
			ps = con.prepareStatement("delete from Cart where cartID = ?;");

			ps.setInt(1, cartID);
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
	public boolean clearCart(String emailID) {
		
		try {

			con = DataConnect.getConnection();
			ps = con.prepareStatement("delete from Cart where emailID = ?;");

			ps.setString(1, emailID);
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
	public boolean searchCart(String foodName) {

		try {

			con = DataConnect.getConnection();
			ps = con.prepareStatement("select * from Cart where foodName = ?;");

			ps.setString(1, foodName);

			rs = ps.executeQuery();

			while(rs.next()) {
				
				return true;
				
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateQun(Cart cart) {

		try {

			con = DataConnect.getConnection();
			ps = con.prepareStatement("update Cart set foodID = ?, foodName = ?, quantity = ?, emailID = ?, foodPrice = ?, totalPrice = ? where cartID = ?;");

			ps.setInt(1, cart.getFoodID());
			ps.setString(2, cart.getFoodName());
			ps.setInt(3, cart.getQuantity());
			ps.setString(4, cart.getEmailID());
			ps.setFloat(5, cart.getFoodPrice());
			ps.setFloat(6, cart.getTotalPrice());
			ps.setInt(7, cart.getCartID());

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
