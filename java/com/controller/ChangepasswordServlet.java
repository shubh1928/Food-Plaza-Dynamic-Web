package com.controller;

import java.io.IOException;

import com.dao.AdminDaoImpl;
import com.pojo.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cpservlet")
public class ChangepasswordServlet extends HttpServlet{
	
	AdminDaoImpl aobj = new AdminDaoImpl();
	Customer co = new Customer();
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			HttpSession session = req.getSession();
			
			String email = req.getParameter("email");
			
			String aEmail = (String) session.getAttribute("aEmail");
			String uEmail = (String) session.getAttribute("uEmail");
			
			String npass = req.getParameter("npass"); //new password 
			String cpass = req.getParameter("cpass"); //confirm password 
			
			String opass = req.getParameter("opass");  //old password
			String dpass = (String) session.getAttribute("dpass");
			
			String action = req.getParameter("action");
			
			if (action != null && action.equals("Changepass")) {
				
				if (email.equals(aEmail)) 
				{
					if(opass.equals(dpass) && npass.equals(cpass)) {
					
					boolean b = aobj.adminChangePassword(email, cpass);
					
					if (b) 
					{
						session.setAttribute("aEmail", aEmail);
						resp.sendRedirect("Success.jsp");
					}
					else 
					{
						resp.sendRedirect("Failed.jsp");
					}
					
					}
					else 
					{
						session.setAttribute("npass", npass);
						session.setAttribute("cpass", cpass);
						
						session.setAttribute("opass", opass);
						session.setAttribute("dpass", dpass);
						
						req.getRequestDispatcher("CFailed.jsp").include(req, resp);
//						resp.sendRedirect("CFailed.jsp");						
					}
					
				}
				
				
				
				if (email.equals(uEmail)) {
					
					if(opass.equals(dpass) && npass.equals(cpass)) {

					boolean b = aobj.userChangePassword(email, cpass);

					if (b)
					{
						session.setAttribute("uEmail", uEmail);
						resp.sendRedirect("Success.jsp");
					}
					else 
					{
						resp.sendRedirect("Failed.jsp");
					}

				}
					else 
					{
						session.setAttribute("npass", npass);
						session.setAttribute("cpass", cpass);
						
						session.setAttribute("opass", opass);
						session.setAttribute("dpass", dpass);
						
						req.getRequestDispatcher("CFailed.jsp").include(req, resp);
//						resp.sendRedirect("CFailed.jsp");
					}
					
				}
				
			
			}
			
			
		}

}
