<%@page import="java.util.Iterator"%>
<%@page import="com.pojo.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% List<Cart> cl = (List)session.getAttribute("cllist"); %>

<jsp:include page="UserHeader.jsp"></jsp:include>

<div id="templatemo_container">

     <form action="order" method="post" onsubmit="CartListValidation()" class="main">
          <table border="1" style="margin: 0 auto; text-align: center;">
          
                <caption>
                   <br> <h1>Cart List</h1>
                </caption>
               
     <tr>
         <th>Cart-ID</th>
         <th>Food-ID</th>
         <th>Food-Name</th>
         <th>Quantity</th>
         <th>Email-ID</th>
         <th>Food-Price</th>
         <th>Total-Price</th>
          <th colspan="1">Cancel</th>
     </tr>
     
     <% 
     Iterator<Cart> itr = cl.iterator();
     
     while(itr.hasNext()){
    	 Cart ca = itr.next();     
     %>
     
     <tr>
         <td><%=ca.getCartID()%></td>
         <td><%=ca.getFoodID()%></td>
         <td><%=ca.getFoodName()%></td>
         <td><%=ca.getQuantity()%></td>
         <td><%=ca.getEmailID()%></td>
         <td><%=ca.getFoodPrice()%></td>
         <td><%=ca.getTotalPrice()%></td>
         <td><a href="cart?action=delete&cartId=<%=ca.getCartID()%>">Delete</a> </td>
     </tr>
     
     <%}%>
     
</table>

<div style="text-align: center; margin-top: 10px;">
<input type="submit" value="Place Order" name="action">
</div>

</form>
<br>
</div>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>