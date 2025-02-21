<%@page import="com.pojo.Food"%>
<%@page import="com.dao.FoodDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddToCart</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="Validation.js"></script>
<script type="text/javascript" src="Cart.js"></script>
<script src="Validation.js"></script>
<script type="text/javascript"></script>
</head>
<body>

<%
FoodDaoImpl fd = new FoodDaoImpl();

Food food = new Food();

int fid=Integer.parseInt(request.getParameter("foodId"));
out.print(fid);

food = fd.searchFoodById(fid);

String emailId = (String)session.getAttribute("uEmail");
String fName = request.getParameter("fName");

session.setAttribute("fName", fName);
%>

<jsp:include page="UserHeader.jsp"></jsp:include>

<div id="templatemo_container">

<form action="cart" method="post" onsubmit="return AddCartValidation()" class="main">

  <table border="1" style="margin: 0 auto; text-align: center;">
  
<br>    <caption><h1>AddToCart</h1></caption>
    
    <tr>
        <td>Existing FoodId:</td>
        <td> <input type="number" name="fid" id="fid" value="<%=food.getFoodID()%>"> </td>
        <td> <span id="fiderror" style="color: red"></span> </td>
    </tr>
    
    <tr>
        <td>EmailId:</td>
        <td> <input type="email" name="email" id="email" value="<%=emailId%>"> </td>
        <td> <span id="emailerror" style="color: red"></span> </td>
    </tr>
    
    <tr>
        <td>FoodName:</td>
        <td> <input type="text" name="fname" id="fname" value="<%=food.getFoodName()%>"> </td>
        <td> <span id="fnameerror" style="color: red"></span> </td>
    </tr>
    
    <tr>
        <td>Quantity:</td>
        <td> <input type="number" name="quan" id="quan" data-quantity="<%=food.getFoodQuantity()%>" 
                    onkeyup="searchdata(this.value)"> </td>
        <td> <span id="quanerror" style="color: red"></span> </td>
    </tr>
    
    <tr>
        <td>FoodPrice:</td>
        <td> <input type="number" name="fprice" id="fprice" value="<%=food.getFoodPrice()%>"> </td>
        <td> <span id="fpriceerror" style="color: red"></span> </td>
    </tr>
    
    <tr>
        <td>TotalPrice:</td>
        <td> <input type="number" name="tprice" id="tprice" onclick="total()" onmouseover="total()"> </td>
        <td> <span id="fpriceerror" style="color: red"></span> </td>
    </tr>
  
  </table>

<div style="text-align: center; margin-top: 10px;">
<input type="submit" value="AddToCart" name="action">
<input type="reset" value="Clear">
</div>

</form>
<br>
</div>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>