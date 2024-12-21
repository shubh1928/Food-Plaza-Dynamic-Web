package com.pojo;

public class Customer {
	
	private String customerName;
	private String customerEmailID;
	private String customerPassword;
	private long customerContactNo;
	private String customerAddress;

	public Customer() {
		super();
	}

	public Customer(String customerName, String customerEmailID, String customerPassword, long customerContactNo,
			String customerAddress) {
		super();
		this.customerName = customerName;
		this.customerEmailID = customerEmailID;
		this.customerPassword = customerPassword;
		this.customerContactNo = customerContactNo;
		this.customerAddress = customerAddress;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmailID() {
		return customerEmailID;
	}

	public void setCustomerEmailID(String customerEmailID) {
		this.customerEmailID = customerEmailID;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public long getCustomerContactNo() {
		return customerContactNo;
	}

	public void setCustomerContactNo(long customerContactNo) {
		this.customerContactNo = customerContactNo;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	public String toString() {
		return "Customer: Customer Name = " + customerName + ", Customer Email-ID = " + customerEmailID + ", Customer Password = "
				+ customerPassword + ", Customer ContactNo = " + customerContactNo + ", Customer Address = " + customerAddress
				+ ".";
	}

}
