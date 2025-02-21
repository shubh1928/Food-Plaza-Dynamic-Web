package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnect {
	
	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project1","root","9475@Gopale");	
		}
		catch(Exception e) {
			System.out.println("Something is wrong while loading driver class or connection.");
		}
		
		return con;
		
	}

}
