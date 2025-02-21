<%@page import="java.util.Iterator"%>
<%@page import="com.pojo.Food"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String uEmail = (String) session.getAttribute("uEmail");
String aEmail = (String) session.getAttribute("aEmail");

List<Food> l = (List)session.getAttribute("flist");
%>

<c:if test="${uEmail == null && aEmail == null}">
     <jsp:include page="Header.jsp"></jsp:include>
</c:if>

<c:if test="${uEmail != null && aEmail == null}">
     <jsp:include page="UserHeader.jsp"></jsp:include>
</c:if>

<c:if test="${uEmail == null && aEmail != null}">
     <jsp:include page="AdminHeader.jsp"></jsp:include>
</c:if>

<div id="templatemo_container" class="parent">

<div class="child">
     <form>
          <table border="1" style="margin: 0 auto; text-align: center;">
          
                <caption>
                   <br> <h1>Food List</h1>
                </caption>
               
                <tr>
                    <th>FoodId</th>
                    <th>FoodName</th>
                    <th>FoodType</th>
                    <th>AvailableQuantity</th>
                    <th>Price(1 per item)</th>
                    
                    <c:if test="${uEmail == null && aEmail != null}">
                         <th colspan="2">Action</th>
                    </c:if>
                    
                    <c:if test="${uEmail != null && aEmail == null}">
                         <th colspan="1">Add To Cart</th>
                    </c:if>
                    
                </tr>
                
                <%
                
                Iterator <Food> itr = l.iterator();
                
                while(itr.hasNext()){
                	Food f = itr.next();
              
                %>
                
                <tr>
                    <td><%=f.getFoodID()%></td>
                    <td><%=f.getFoodName()%></td>
                    <td><%=f.getFoodType()%></td>
                    <td><%= (f.getFoodQuantity() == 0) ? "Out of Stock" : f.getFoodQuantity() %></td>
                    <td><%=f.getFoodPrice()%></td>
                    
                    <c:if test="${uEmail == null && aEmail != null}">
                         <td><a href="UpdateFood.jsp?foodId=<%=f.getFoodID()%>">Edit</a></td>
                         <td><a href="food?action=delete&foodId=<%=f.getFoodID()%>">Delete</a></td>
                    </c:if>
                    
                    
                  <c:if test="${uEmail != null && aEmail == null}">
                        
                    <td>
                        <% if (f.getFoodQuantity() > 0) { %>
                           <a href="AddToCart.jsp?foodId=<%= f.getFoodID() %>&fName=<%= f.getFoodName() %>">Add</a>
                        <% } else { %>
                              N/A
                        <% } %>
                    </td>
                    
                 </c:if>
                    
                </tr>
                
                <% } %>
                
          </table>  
        <br>     
     </form>
</div>

</div>
     
     <jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>