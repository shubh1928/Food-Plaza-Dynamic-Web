package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Customer;
import com.pojo.Food;
import com.utility.DataConnect;

public class CustomerDaoImpl implements CustomerDao {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public boolean addCustomer(Customer customer) {
		
		try {
			
			con = DataConnect.getConnection();
			ps = con.prepareStatement("insert into Customer (customerName,customerEmailID,customerPassword,customerContactNo,customerAddress) values (?,?,?,?,?);");

			ps.setString(1, customer.getCustomerName());
			ps.setString(2, customer.getCustomerEmailID());
			ps.setString(3, customer.getCustomerPassword());
			ps.setLong(4, customer.getCustomerContactNo());
			ps.setString(5, customer.getCustomerAddress());

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
	public boolean updateCustomerById(Customer customer) {

		try {

			con = DataConnect.getConnection();
			ps = con.prepareStatement("update Customer set customerName = ?, customerEmailID = ? , customerPassword = ?, customerContactNo = ?, customerAddress = ? where customerEmailID = ?;");

			ps.setString(1, customer.getCustomerName());
			ps.setString(2, customer.getCustomerEmailID());
			ps.setString(3, customer.getCustomerPassword());
			ps.setLong(4, customer.getCustomerContactNo());
			ps.setString(5, customer.getCustomerAddress());
			ps.setString(6, customer.getCustomerName());

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
	public boolean deleteCustomerById(String customerEID) {
		
		try {

			con = DataConnect.getConnection();
			ps = con.prepareStatement("delete from Customer where customerEmailID = ?;");

			ps.setString(1, customerEID);
			int row = ps.executeUpdate();

			if(row>0) {
				return true;
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Customer> getAllCustomer() {

		List<Customer> l = new ArrayList<Customer>();

		try {

			con = DataConnect.getConnection();
			ps = con.prepareStatement("select * from Customer;");
			rs = ps.executeQuery();

			while(rs.next()) {

				Customer customer = new Customer();

				customer.setCustomerName(rs.getString("customerName"));
				customer.setCustomerEmailID(rs.getString("customerEmailID"));
				customer.setCustomerPassword(rs.getString("customerPassword"));
				customer.setCustomerContactNo(rs.getLong("customerContactNo"));
				customer.setCustomerAddress(rs.getString("customerAddress"));

				l.add(customer);

			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public Customer searchCustomerById(String customerEID) {
		
		Customer customer = null;
		
		try {
			

			con = DataConnect.getConnection();
			ps = con.prepareStatement("select * from Customer where customerEmailID = ?;");

			ps.setString(1, customerEID);

			rs = ps.executeQuery();

			while(rs.next()) {

				customer = new Customer();

				customer.setCustomerName(rs.getString("customerName"));
				customer.setCustomerEmailID(rs.getString("customerEmailID"));
				customer.setCustomerPassword(rs.getString("customerPassword"));
				customer.setCustomerContactNo(rs.getLong("customerContactNo"));
				customer.setCustomerAddress(rs.getString("customerAddress"));

			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return customer;
	}

}
