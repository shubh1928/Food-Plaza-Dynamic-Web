package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.OrderDaoImpl;
import com.pojo.Orders;

public class OrderTest {
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		OrderDaoImpl orderobj = new OrderDaoImpl();
		
		String emailID;
		int choice;
		
		while(true) {
			
			System.out.println("\n----- Order -----");
			System.out.println("1.Place Order\n2.Show Order\n3.Exit");
			System.out.print("\nEnter Choice: ");
			
			choice = sc.nextInt();
			
			switch(choice) {
			
			case 1: 
				
				System.out.print("\nEnter An Existing EmailID: ");
				emailID = br.readLine();
				
				Orders o = orderobj.placeOrder(emailID);
				
				if(o != null) {
					
					System.out.println(o);
					
				}
				else {
					
					System.out.print("\nFailed to place order.");
					
				}
				
				break;
				
			case 2: 
				
				System.out.print("\nShowing Orders: ");
				
				List<Orders> l = orderobj.showOrder();
				
				Iterator<Orders> oi = l.iterator();
				
				while(oi.hasNext()) {
					System.out.println(oi.next());
				}
				
				break;
				
			case 3:
				
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
