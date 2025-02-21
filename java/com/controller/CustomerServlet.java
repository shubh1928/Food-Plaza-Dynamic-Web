package com.controller;

import java.io.IOException;
import java.util.List;

import com.dao.CustomerDaoImpl;
import com.pojo.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
	
CustomerDaoImpl custobj = new CustomerDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String email1 = (String) session.getAttribute("email");
		String pass1 = (String) session.getAttribute("pass");
		
		String action = req.getParameter("action");
		String name = req.getParameter("cname");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		String adr = req.getParameter("adr");
		long cNo =  Long.parseLong(req.getParameter("cNo"));
		
		if (action != null && action.equals("AddCustomer")) {
			
			boolean b = custobj.addCustomer(new Customer(name,email,pass,cNo,adr));
			
			if (b) {
				resp.sendRedirect("Success.jsp");
			}
			else {
				resp.sendRedirect("Failed.jsp");
			}
			
		}
		
		if (action != null && action.equals("UpdateCustomer")) {
			
			boolean b = custobj.updateCustomerById(new Customer(name, email1, pass1, cNo, adr));
			
			if (b) {
				resp.sendRedirect("Success.jsp");
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
		
		if (action != null && action.equals("delete") ) {
			
			String emiailId = req.getParameter("emailId");
			boolean b = custobj.deleteCustomerById(emiailId);
			
			if (b) {
				resp.sendRedirect("customer");
			} else {
				resp.sendRedirect("Failed.jsp");
			}
			
		}
		else {
			
			List<Customer> l = custobj.getAllCustomer();
			
			if (l != null && !(l.isEmpty())) {
				
				session.setAttribute("cslist", l);
				resp.sendRedirect("CustomerList.jsp");
				
			} else {
				
				resp.sendRedirect("Failed.jsp");

			}
			
		}
		
	}

}
