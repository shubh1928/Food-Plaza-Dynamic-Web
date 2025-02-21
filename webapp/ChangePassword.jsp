<%@page import="com.dao.CustomerDaoImpl"%>
<%@page import="com.pojo.Customer"%>
<%@page import="com.pojo.Food"%>
<%@page import="com.dao.FoodDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddToCart</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="Validation.js"></script>
<script type="text/javascript" src="cart.js"></script>
<script src="Validation.js" ></script>
<script type="text/javascript"></script>
</head>
<body>

<%
String uEmail = (String) session.getAttribute("uEmail");
String aEmail = (String) session.getAttribute("aEmail");

String uPass = (String) session.getAttribute("pass");
String aPass = (String) session.getAttribute("aPass");
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

<%
Customer cust = new Customer();

CustomerDaoImpl cobj = new CustomerDaoImpl();

cust = cobj.searchCustomerById(uEmail);

%>

<div id="templatemo_container" class="parent">

<form action="cpservlet" method="post" onsubmit="return ChangePassValidation()" class="main">
<br>
<table border="2" style="margin: 0 auto; text-align: center;">

  <caption> <h1>Change Password</h1> </caption>
  
  <tr>
  
  <td>EmailID:</td>
  
  <c:if test="${uEmail != null && aEmail == null}">
    <td> <input type="email" name="email" value="<%=uEmail%>" id="email"> </td>
    <td> <span id="emailerror" style="color: red"></span> </td>
  </c:if>
  
  <c:if test="${uEmail == null && aEmail != null}">
    <td> <input type="email" name="email" value="<%=aEmail%>" id="email"> </td>
    <td> <span id="emailerror" style="color: red"></span> </td>
</c:if>
  
  </tr>

  <tr>
  <td>Old Password:</td>
  
    <c:if test="${uEmail != null && aEmail == null}">
     <td> <input type="password" name="opass" id="opass" data-old="<%=cust.getCustomerPassword()%>"> </td>
     <td> <span id="opasserror" style="color: red"></span> </td>
    </c:if>
    
    <c:if test="${uEmail == null && aEmail != null}">
     <td> <input type="password" name="opass" id="opass" data-old="<%=aPass%>"> </td>
     <td> <span id="opasserror" style="color: red"></span> </td>
    </c:if>
    
  </tr>
  
  <tr>
  <td>New Password:</td>
  <td> <input type="password" name="npass" id="npass"> </td>
  <td> <span id="npasserror" style="color: red"></span> </td>
  </tr>
  
  <tr>
  <td>Confirm Password:</td>
  <td> <input type="password" name="cpass" id="cpass"> </td>
  <td> <span id="cpasserror" style="color: red"></span> </td>
  </tr>  
  
</table>

<div style="text-align: center; margin-top: 10px;">
<input type="submit" value="Changepass" name="action">
<input type="reset" value="Clear">
</div>

</form>
<br>
</div>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>