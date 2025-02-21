package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.FoodDaoImpl;
import com.pojo.Food;

public class FoodTest {

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int foodID, foodQuantity;
		String foodName, foodType;
		float foodPrice;
		
		FoodDaoImpl foodobj = new FoodDaoImpl();
		List<Food> l = new ArrayList<>();
		
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
				
				for(int i = 1; i <= num; i++)
				{
					System.out.print("Enter the food type: ");
					foodType = br.readLine();
					
					System.out.print("\nEnter the food name: ");
					foodName = br.readLine();
					
					System.out.print("\nEnter the food quantity: ");
					foodQuantity = sc.nextInt();
					
					System.out.print("\nEnter the food price: ");					
					float price = sc.nextFloat();
					foodPrice = foodQuantity * price;
					
					b = foodobj.addFood(new Food(foodType,foodName,foodQuantity,foodPrice));
					
					if(b) {
						System.out.println("\n"+ foodName + " added successfully.\n");
					}
					else {
						System.out.println("\nFailed to add.");
					}
					
				}
				
				break;
				
			case 2 : 
					
		    	System.out.print("\nEnter the food type: ");
				foodType = br.readLine();
		      	
				System.out.print("\nEnter the food name: ");
				foodName = br.readLine();
				
				System.out.print("\nEnter the food quantity: ");
				foodQuantity = sc.nextInt();
				
				System.out.print("\nEnter the food price: ");					
				foodPrice = sc.nextFloat();
				
				System.out.print("\nEnter the food id: ");
		      	foodID = sc.nextInt();

		      	Food foodToUpdate = new Food(foodType,foodName,foodQuantity,foodPrice);
		      	foodToUpdate.setFoodID(foodID); 
		      	b = foodobj.updateFoodById(foodToUpdate);
			
				if(b) {
					System.out.println(foodName + " updated successfully.");
				}
				else {
					System.out.println("Failed to update.");
				}	

				break;

			case 3 : 

				System.out.print("\nEnter the food id: ");
				foodID = sc.nextInt();
				System.out.println();

				b = foodobj.deleteFoodById(foodID);

				if(b) {
					System.out.print("\nID " + foodID + " deleted successfully.");
				}
				else {
					System.out.println("Failed to delete.");
				}

				break;

			case 4 : 
				
				System.out.print("Enter the Food ID for search: ");
				foodID = sc.nextInt();
				System.out.println();
				
				Food food = new Food();
				food = foodobj.searchFoodById(foodID);
				
				if(food != null) {
					
					System.out.println(food);
					
				}
				
				else {
					
					System.out.println("Item Not Available");
					
				}
				
				break;
				
			case 5 :
				
				System.out.println("showing the menu: ");
				
				l = foodobj.getAllFood();
				
				Iterator<Food> fi = l.iterator();

				while(fi.hasNext()) {
					System.out.println(fi.next());
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
