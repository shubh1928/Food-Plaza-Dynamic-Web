package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.CartDaoImpl;
import com.pojo.Cart;
import com.pojo.Customer;
import com.pojo.Food;

public class CartTest {

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cartID, foodID, quantity;
		String foodName, emailID;
		float foodPrice, totalPrice;
		
		CartDaoImpl  cartobj = new CartDaoImpl();
		List<Cart> l = new ArrayList<>();
		
		
		
		while(true) {
			
			System.out.println("\n1.Add\n2.Update\n3.Delete\n4.Search\n5.ShowAllData\n6.Clear Cart\n7.Exit");

			System.out.print("\nEnter the choice: ");
			int choice = sc.nextInt();
//			System.out.println();
			
			boolean b;

			switch(choice) { 
			
			case 1 :
				
				System.out.print("\nHow many data you want to add: ");
				int num = sc.nextInt();
				System.out.println();
				
				for(int i = 1; i <= num; i++) {
					
					System.out.print("Enter Food ID: ");
					foodID = sc.nextInt();
					
					System.out.print("\nEnter Food Name: ");
					foodName = br.readLine();
					
					System.out.print("\nEnter Food Quantity: ");
					quantity = sc.nextInt();
					
					System.out.print("\nEnter Your Email-ID: ");
					emailID = br.readLine();
					
					System.out.print("\nEnter Food Price: ");
					foodPrice = sc.nextFloat();
					
					totalPrice = quantity * foodPrice;
					
					b = cartobj.addCart(new Cart(foodID,foodName,quantity,emailID,foodPrice,totalPrice));
					
					if(b) {
						System.out.print("\n" + foodName + " added to cart successfully.\n\n");
					}
					else {
						System.out.print("\nFailed to add in cart.\n");
					}
					
				}
				
				break;
				
			case 2 :
				
				System.out.print("\nEnter the food id: ");
				foodID = sc.nextInt();
		      	
				System.out.print("\nEnter the food name: ");
				foodName = br.readLine();
				
				System.out.print("\nEnter the food quantity: ");
				quantity = sc.nextInt();
				
				System.out.print("\nEnter the email-id: ");
				emailID = br.readLine();
				
				System.out.print("\nEnter the food price: ");					
				foodPrice = sc.nextFloat();
				
		      	totalPrice = quantity * foodPrice;
		      	
		      	System.out.print("\nEnter the cart id: ");					
				cartID = sc.nextInt();

		      	Cart cartToUpdate = new Cart(foodID,foodName,quantity,emailID,foodPrice,totalPrice);
		      	cartToUpdate.setCartID(cartID); 
		      	b = cartobj.updateQun(cartToUpdate);
			
				if(b) {
					System.out.println("Cart ID: " + cartID + " with " + foodName + " updated successfully.");
				}
				else {
					System.out.println("Failed to update cart.\n");
				}
				
				break;
				
			case 3 :
				
				System.out.print("\nEnter the Cart Id: ");
				cartID = sc.nextInt();
				System.out.println();

				b = cartobj.deleteCart(cartID);

				if(b) {
					System.out.print("\nCart Id: " + cartID + " deleted successfully.\n");
				}
				else {
					System.out.println("Failed to delete.\n");
				}
				
				break;
				
			case 4 :
				
				System.out.print("\nEnter the Food name for search: ");
				foodName = br.readLine();
				System.out.println();

				
				boolean isAvailable = cartobj.searchCart(foodName);

				if(isAvailable) {

					System.out.println(foodName + " is available in the cart.");
//					b = cartobj.searchCart();

				}

				else {

					System.out.println(foodName +  " Not Available.");

				}
				
				break;
				
			case 5 :
				
				System.out.print("\nEnter the email-id to see cart: ");
				emailID = br.readLine();

				l = cartobj.ShowCart(emailID);

				if (l == null) {
					System.out.println("No data found for the given email ID: " + emailID);
				} 
				
				else {
					
					System.out.println("\nShowing your cart: ");
					Iterator<Cart> ci = l.iterator();
					
					while(ci.hasNext()) {
						
						System.out.println(ci.next());
						
					}
				}

				break;
				
			case 6 :
				
				System.out.print("\nEnter the Email-Id to clear cart: ");
				emailID = br.readLine();
				System.out.println();

				b = cartobj.clearCart(emailID);

				if(b) {
					System.out.print("Cart for Email-Id: " + emailID + " cleared successfully.\n");
				}
				else {
					System.out.println("Failed to clear.\n");
				}
				
				break;
				
			case 7 : 
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
