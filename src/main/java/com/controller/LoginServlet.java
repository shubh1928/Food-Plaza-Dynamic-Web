package com.controller;

import java.io.IOException;

import com.dao.AdminDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	AdminDaoImpl ad = new AdminDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String action = req.getParameter("action");
		String type = req.getParameter("type");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		if (action!=null && action.equals("Login")) {
			
			boolean b = ad.adminLogin(email, pass);
			
			if (b) {
				session.setAttribute("aEmail", email);
				resp.sendRedirect("AdminLogin.jsp");
			}
			else {
				resp.sendRedirect("Failed.jsp");
			}
			
		}
		
		if (type.equals("user")) {
			
			boolean b = ad.userLogin(email, pass);
			
			if (b) {
				session.setAttribute("pass", pass);
				session.setAttribute("uEmail", email);
				resp.sendRedirect("UserLogin.jsp");
			}
			else {
				resp.sendRedirect("Failed.jsp");
			}
		}
		
		
	}
	
}
