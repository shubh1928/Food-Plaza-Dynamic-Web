package com.dao;

import java.util.List;

import com.pojo.Cart;

public interface CartDao {
	
	boolean addCart(Cart cart);
	List<Cart>ShowCart(String emailID);
	boolean deleteCart(int cartID);
	boolean clearCart(String emailID);
	boolean searchCart(String foodName);
	boolean updateQun(Cart cart);

}
