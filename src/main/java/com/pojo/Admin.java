package com.pojo;

public class Admin {
	
	private String adminEmailID;
	private String adminPassword;
	
	public Admin(String adminEmailID, String adminPassword) {
		super();
		this.adminEmailID = adminEmailID;
		this.adminPassword = adminPassword;
	}

	public String getAdminEmailID() {
		return adminEmailID;
	}

	public void setAdminEmailID(String adminEmailID) {
		this.adminEmailID = adminEmailID;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Admin: Admin Email-ID = " + adminEmailID + ", Admin Password = " + adminPassword + ".";
	}

}
