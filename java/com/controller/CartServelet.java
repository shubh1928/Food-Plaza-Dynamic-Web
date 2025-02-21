package com.controller;

import java.io.IOException;
import java.util.List;

import com.dao.CartDaoImpl;
import com.dao.FoodDaoImpl;
import com.pojo.Cart;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/cart")
public class CartServelet extends HttpServlet{

	CartDaoImpl cd = new CartDaoImpl();
	FoodDaoImpl fd = new FoodDaoImpl(); // Added for food-related operations
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String uEmail = (String) session.getAttribute("uEmail");
		String action = req.getParameter("action");
		
		if (action != null && action.equals("delete")) {
			
			int cartId = Integer.parseInt(req.getParameter("cartId"));	
			
			boolean b = cd.deleteCart(cartId);
			
			if (b) {
				resp.sendRedirect("cart");
			} else {
				resp.sendRedirect("Failed.jsp");
			}
			
		}
		else {

			List<Cart> cl = cd.ShowCart(uEmail);

			if (cl != null && !(cl.isEmpty())) {

				session.setAttribute("cllist", cl);
				resp.sendRedirect("CartList.jsp");

			} else {
				session.setAttribute("EmptyMsg1", "hey");
				resp.sendRedirect("CFailed.jsp");

			}
			
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String action = req.getParameter("action");
		String fName = (String) session.getAttribute("fName");
		
		if (action != null && action.equals("AddToCart")) {
			
			int fid = Integer.parseInt(req.getParameter("fid"));
			String fname = req.getParameter("fname");
			int quan = Integer.parseInt(req.getParameter("quan"));
			String email = req.getParameter("email");			
			float fprice = Float.parseFloat(req.getParameter("fprice"));
			float tprice = Float.parseFloat(req.getParameter("tprice"));
			
			session.setAttribute("oID", fid);
			session.setAttribute("oQ", quan);
			
			CartDaoImpl cobj = new CartDaoImpl();
			
			boolean b = cobj.searchCart(fName);
			
			if (!b) {
				
				boolean b1 = cd.addCart(new Cart(fid,fname,quan,email,fprice,tprice));
				
				if (b1) {
					resp.sendRedirect("cart");
				}
				else {
					resp.sendRedirect("Failed.jsp");
				}
				
			}
			else {
				resp.sendRedirect("cart");
			}
			
		}		
		
	}

}
