package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.dao.AdminDaoImpl;
import com.pojo.Admin;

public class AdminTest {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String adminEmailID, adminPassword, customerEmailID, customerPassword;

		AdminDaoImpl adminobj = new AdminDaoImpl();
		List<Admin> l = new ArrayList<>();

		while(true) {

			System.out.println("\n1.Admin Login\n2.Change Admin Password\n3.User Login\n4.Change User Password\n5.Exit");

			System.out.print("\nEnter the choice: ");
			int choice = sc.nextInt();
			System.out.println();

			boolean b;

			switch(choice) {

			case 1 :

				System.out.print("Enter Admin Email-id: ");
				adminEmailID = br.readLine();
				
				System.out.print("Enter Admin Password: ");
				adminPassword = br.readLine();
				
				b = adminobj.adminLogin(adminEmailID, adminPassword);
				
				if(b) {
					System.out.println("\nLogin successfully.");
				}
				else {
					System.out.println("\nFailed to Login.");
				}	
				
				break;

			case 2 : 

				System.out.print("Enter Admin's Existing Email-id: ");
				adminEmailID = br.readLine();
				
				System.out.print("Enter Admin's New Password: ");
				adminPassword = br.readLine();
				
				b = adminobj.adminChangePassword(adminEmailID, adminPassword);
				
				if(b) {
					System.out.println("\nPassword Changed successfully.");
				}
				else {
					System.out.println("\nFailed to Change Password.");
				}	
				
				break;
				
			case 3 : 
				
				System.out.print("Enter Customer  Email-id: ");
				customerEmailID = br.readLine();
				
				System.out.print("Enter Customer Password: ");
				customerPassword = br.readLine();
				
				b = adminobj.userLogin(customerEmailID, customerPassword);
				
				if(b) {
					System.out.println("\nLogin successfully.");
				}
				else {
					System.out.println("\nFailed to Login.");
				}	
				
				break;
			
			case 4 : 

				System.out.print("Enter Customer's Existing Email-id: ");
				customerEmailID = br.readLine();
				
				System.out.print("Enter Customer's New Password: ");
				customerPassword = br.readLine();
				
				b = adminobj.userChangePassword(customerEmailID, customerPassword);
				
				if(b) {
					System.out.println("\nPassword Changed successfully.");
				}
				else {
					System.out.println("\nFailed to Change Password.");
				}
				
				break;

			case 5 : 

				System.out.print("Exiting the program. Thank you!");
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
