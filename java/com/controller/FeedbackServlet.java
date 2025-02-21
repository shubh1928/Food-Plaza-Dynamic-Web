package com.controller;

import java.io.IOException;
import java.util.List;

import com.dao.FeedbackDaoimpl;
import com.pojo.Feedback;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet{
 
 FeedbackDaoimpl feedobj = new FeedbackDaoimpl();
 
 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
  HttpSession session = req.getSession();
  
  String email1 = (String) session.getAttribute("email");
  String uEmail = (String) session.getAttribute("uEmail");
  String pass1 = (String) session.getAttribute("pass");
  
  String action = req.getParameter("action");
  String name = req.getParameter("uname");
  String email = req.getParameter("email");
  String review = req.getParameter("review");
  int rank = Integer.parseInt(req.getParameter("rank")); 
  String suggestion = req.getParameter("sugge");
  
  if (action != null && action.equals("AddFeedback")) {
   
   boolean b = feedobj.addFeedback(new Feedback(name,email,review,rank, suggestion));
   
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

   List<Feedback> l = feedobj.getAllFeedback();
   
   if (l != null && !(l.isEmpty())) {
    
    session.setAttribute("fblist", l);
    resp.sendRedirect("FeedbackList.jsp");
    
   } else {
    
    resp.sendRedirect("Failed.jsp");

   }
  
 }
 
}