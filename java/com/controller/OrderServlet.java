package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.CartDaoImpl;
import com.dao.FoodDaoImpl;
import com.dao.OrderDaoImpl;
import com.pojo.Food;
import com.pojo.Orders;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/order")
public class OrderServlet extends HttpServlet{
	
		OrderDaoImpl od = new OrderDaoImpl();
		CartDaoImpl cd = new CartDaoImpl();
		Food ofood = new Food();
		FoodDaoImpl ofd = new FoodDaoImpl();
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			HttpSession session = req.getSession();
			
			String email = (String)session.getAttribute("uEmail");
			
			int ofid = (Integer) session.getAttribute("oID");       
            int oquan = (Integer) session.getAttribute("oQ");       
           
            ofood = ofd.searchFoodById(ofid);
            
			Orders o = od.placeOrder(email);
			
			if (o != null) {
				
				boolean b = cd.clearCart(email);
				
				if (b) {
					
					int oprevQuan = ofood.getFoodQuantity();
					System.out.println("previous quantity - "+oprevQuan);
					session.setAttribute("dfquan", oprevQuan);
					
					if(oprevQuan >= oquan) {
					
					int oupdatedQuan = oprevQuan - oquan;
					
					ofood = new Food(oupdatedQuan);
					ofood.setFoodID(ofid);
					ofd.updateFoodQun(ofood);
					
					}
					else {
						
						
						  resp.setContentType("text/html");
						    PrintWriter out = resp.getWriter();
						    out.println("<html>");
						    out.println("<head><title>Out of Stock</title></head>");
						    out.println("<body>");
						    out.println("<h3 style='color:red;'>This food is currently out of stock.</h3>");
						    out.println("</body>");
						    out.println("</html>");
						
						resp.sendRedirect("Failed.jsp");
					}
					
					req.setAttribute("order", o);
					req.getRequestDispatcher("Bill.jsp").forward(req, resp);
					
				}
				
			}
			else {
				
				resp.sendRedirect("Failed.jsp");
				
			}
			
		}

}
