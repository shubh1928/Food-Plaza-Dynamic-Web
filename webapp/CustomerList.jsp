<%@page import="java.util.Iterator"%>
<%@page import="com.pojo.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css"/>
<script src="Validation.js"></script>
</head>
<body>

<% List<Customer> l = (List)session.getAttribute("cslist"); %>

<jsp:include page="AdminHeader.jsp"></jsp:include>

<div id="templatemo_container">

<form class="main">
<br>
<table border="2" style="margin: 0 auto; text-align: center;">

     <caption> <h1>Customer List</h1> </caption>
     
     <tr>
         <th>Name</th>
         <th>EmailId</th>
         <th>Password</th>
         <th>Address</th>
         <th>ContactNo</th>
         <th colspan="2">Action</th>
     </tr>
     
     <% 
     Iterator<Customer> itr = l.iterator();
     
     while(itr.hasNext()){
    	 Customer cs = itr.next();     
     %>
     
     <tr>
         <td><%=cs.getCustomerName()%></td>
         <td><%=cs.getCustomerEmailID()%></td>
         <td><%=cs.getCustomerPassword()%></td>
         <td><%=cs.getCustomerContactNo()%></td>
         <td><%=cs.getCustomerAddress()%></td>
         <td><a href="customer?action=delete&emailId=<%=cs.getCustomerEmailID()%>">Delete</a> </td>
     </tr>
     
     <%}%>
     
</table>

</form>
<br>
</div>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>