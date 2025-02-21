package com.controller;

import java.io.IOException;
import java.util.List;

import com.dao.FoodDaoImpl;
import com.pojo.Food;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/food")
public class FoodServlet extends HttpServlet{
	
	FoodDaoImpl foodobj = new FoodDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String email1 = (String) session.getAttribute("email");
		String pass1 = (String) session.getAttribute("pass");
		String aEmail = (String) session.getAttribute("aEmail");
		
		String action = req.getParameter("action");
		String ftype = req.getParameter("ftype");
		String fname = req.getParameter("fname");
		int fquantity = Integer.parseInt(req.getParameter("fquantity")); 
		float fprice = Float.parseFloat(req.getParameter("fprice"));
		
		if (action != null && action.equals("AddFood")) {
			
			boolean b = foodobj.addFood(new Food(ftype,fname,fquantity,fprice));
			
			if (b) {
				resp.sendRedirect("Success.jsp");
			}
			else {
				resp.sendRedirect("Failed.jsp");
			}
			
		}
		
		if (action != null && action.equals("UpdateFood")) {
			
			int fid = Integer.parseInt(req.getParameter("fid"));

			Food f = new Food(ftype,fname,fquantity,fprice);
			f.setFoodID(fid);
			
			boolean b = foodobj.updateFoodById(f);
			
			if (b) {
				resp.sendRedirect("food");
			}
			else {
				resp.sendRedirect("Failed.jsp");
			}

		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		String action = req.getParameter("action");

		if (action != null && action.equals("delete")) {

			int foodId = Integer.parseInt(req.getParameter("foodId"));
			boolean b = foodobj.deleteFoodById(foodId);

			if (b) {
				resp.sendRedirect("food");
			} else {
				resp.sendRedirect("Failed.jsp");
			}

		}
		else
		{

			String email1 = (String)session.getAttribute("email");

			List<Food> l = foodobj.getAllFood();

			if (l != null && !(l.isEmpty())) {
				session.setAttribute("flist", l);
				resp.sendRedirect("FoodList.jsp");
			}
			else {
				resp.sendRedirect("Failed.jsp");
			}

		}


	}
	
}
