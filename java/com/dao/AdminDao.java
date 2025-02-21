package com.dao;

public interface AdminDao {
	
	boolean adminLogin(String adminEmailID, String adminPassword);
	boolean adminChangePassword(String adminEmailID, String adminPassword);
	boolean userLogin(String customerEmailID, String customerPassword);
	boolean userChangePassword(String customerEmailID, String customerPassword);

}
