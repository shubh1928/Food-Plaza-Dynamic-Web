package com.dao;

import java.util.List;

import com.pojo.Orders;

public interface OrderDao {
	
	Orders placeOrder(String emailID);
	List<Orders> showOrder();

}
