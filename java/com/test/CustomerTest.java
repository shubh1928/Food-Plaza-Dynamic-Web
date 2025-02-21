package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.dao.CustomerDaoImpl;
import com.pojo.Customer;

public class CustomerTest {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String customerName, customerEmailID, customerPassword, customerAddress;
		long customerContactNo;

		CustomerDaoImpl customerobj = new CustomerDaoImpl();
		List<Customer> l = new ArrayList<>();

		while(true) {

			System.out.println("\n1.Add\n2.Update\n3.Delete\n4.Search\n5.ShowAllData\n6.Exit");

			System.out.print("\nEnter the choice: ");
			int choice = sc.nextInt();
			System.out.println();

			boolean b;

			switch(choice) {

			case 1 :

				System.out.print("How many data you want to add: ");
				int num = sc.nextInt();
				System.out.println();

				for(int i = 1; i <= num; i++) {

					System.out.print("Enter Customer Name: ");
					customerName = br.readLine();

					System.out.print("\nEnter Customer E-mail ID: ");
					customerEmailID = br.readLine();

					System.out.print("\nEnter Customer Password: ");
					customerPassword = br.readLine();

					System.out.print("\nEnter Customer ContactNo.: ");
					customerContactNo = sc.nextLong();

					System.out.print("\nEnter Customer Address: ");
					customerAddress = br.readLine();

					b = customerobj.addCustomer(new Customer(customerName,customerEmailID,customerPassword,customerContactNo,customerAddress));

					if(b) {
						System.out.print("\n" + customerName + " added successfully.\n");
					}
					else {
						System.out.print("\nFailed to add.");
					}
				}

				break;

			case 2 :

				System.out.print("Enter the customer name: ");
				customerName = br.readLine();

				System.out.print("\nEnter the customer EmailID: ");
				customerEmailID = br.readLine();

				System.out.print("\nEnter the customer password: ");
				customerPassword = br.readLine();

				System.out.print("\nEnter the customer contactNo.: ");					
				customerContactNo = sc.nextLong();

				System.out.print("\nEnter the cutomer address: ");
				customerAddress = br.readLine();

				b = customerobj.updateCustomerById(new Customer(customerName,customerEmailID,customerPassword,customerContactNo,customerAddress));

				if(b) {
					System.out.print("\n" + customerName + " updated successfully.\n");
				}
				else {
					System.out.print("\nFailed to update.");
				}

				break;

			case 3 :

				System.out.print("\nEnter the customer Email-Id: ");
				customerEmailID = br.readLine();
				System.out.println();

				b = customerobj.deleteCustomerById(customerEmailID);

				if(b) {
					System.out.print("\nEmail-Id: " + customerEmailID + " deleted successfully.");
				}
				else {
					System.out.println("Failed to delete.");
				}

				break;

			case 4 : 

				System.out.print("Enter the Customer Email-Id for search: ");
				customerEmailID = br.readLine();
				System.out.println();

				Customer customer = new Customer();
				customer = customerobj.searchCustomerById(customerEmailID);

				if(customer != null) {

					System.out.println(customer);

				}

				else {

					System.out.println("Customer Not Present.");

				}

				break;

			case 5 :

				System.out.println("showing the List of Customer's: ");

				l = customerobj.getAllCustomer();

				Iterator<Customer> ci = l.iterator();

				while(ci.hasNext()) {
					System.out.println(ci.next());
				}

				break;

			case 6 : 
				
				System.out.println("\nExiting the program. Thank you!");
				sc.close();  
				System.exit(0);  
				
				break;

			default :

				System.out.println("You entered something wrong!!!");

				break;

			}

		}

	}

}
