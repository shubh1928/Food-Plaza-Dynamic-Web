package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.utility.DataConnect;

public class AdminDaoImpl implements AdminDao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public boolean adminLogin(String adminEmailID, String adminPassword) {
		
		try {
			
			con = DataConnect.getConnection();
			ps = con.prepareStatement("select * from Admin where adminEmailID = ? AND adminPassword = ?;");
			
			ps.setString(1, adminEmailID);
			ps.setString(2, adminPassword);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();			
		}
		
		return false;
	}

	@Override
	public boolean adminChangePassword(String adminEmailID, String adminPassword) {

		try {

			con = DataConnect.getConnection();
			ps = con.prepareStatement("update Admin set adminPassword = ? where adminEmailID = ?;");

			ps.setString(1, adminPassword);
			ps.setString(2, adminEmailID);

			int row = ps.executeUpdate();

			if(row > 0) {
				return true;
			}
			else {
				return false;
			}

		}
		catch(Exception e) {
			e.printStackTrace();			
		}

		return false;
	}

	@Override
	public boolean userLogin(String customerEmailID, String customerPassword) {
		
		try {
			
			con = DataConnect.getConnection();
			ps = con.prepareStatement("select * from Customer where customerEmailID = ? AND customerPassword = ?;");
			
			ps.setString(1, customerEmailID);
			ps.setString(2, customerPassword);
			
			rs = ps.executeQuery();

			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean userChangePassword(String customerEmailID, String customerPassword) {
		
		try {
			
			con = DataConnect.getConnection();
			ps = con.prepareStatement("update Customer set customerPassword = ? where customerEmailID = ?;");
			
			ps.setString(1, customerPassword);
			ps.setString(2, customerEmailID);
			
			int row = ps.executeUpdate();

			if(row > 0) {
				return true;
			}
			else {
				return false;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}

}
