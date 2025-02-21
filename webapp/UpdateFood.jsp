<%@page import="com.pojo.Food"%>
<%@page import="com.dao.FoodDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<script type="text/javascript" src="Validation.js"></script>
<link href="templatemo_style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<%

FoodDaoImpl fd = new FoodDaoImpl();

int id = Integer.parseInt(request.getParameter("foodId"));

Food f = fd.searchFoodById(id);

%>

<jsp:include page="AdminHeader.jsp"></jsp:include>

<div id="templatemo_container">

    <form action="food" method="post" onsubmit="return UpdateFoodValidation()" class="main">
       <br>
        <table border="1" align="center" style="text-align: center;">
        
              <caption>Update Food</caption>
              
              <tr>
                  <td>FoodID:</td>
                  <td><input type="number" name="fid" id="fid" value="<%=f.getFoodID()%>"></td>
                  <td><span id="fiderror" style="color: red"></span></td>
              </tr>
              
              <tr>
                  <td>FoodName:</td>
                  <td><input type="text" name="fname" id="fname" value="<%=f.getFoodName()%>"></td>
                  <td><span id="fnameerror" style="color: red"></span></td>
              </tr>
              
              <tr>
                  <td>FoodType:</td>
                  <td><input type="text" name="ftype" id="ftype" value="<%=f.getFoodType()%>"></td>
                  <td><span id="ftypeerror" style="color: red"></span></td>
              </tr>
              
              <tr>
                  <td>Quantity:</td>
                  <td><input type="number" name="fquantity" id="fquan" value="<%=f.getFoodQuantity()%>"></td>
                  <td><span id="fquantityerror" style="color: red"></span></td>
              </tr>
              
              <tr>
                  <td>Price:</td>
                  <td><input type="number" name="fprice" id="fprice" value="<%=f.getFoodPrice()%>"></td>
                  <td><span id="fpriceerror" style="color: red"></span></td>
              </tr>
        
        </table>
        
        <div style="text-align: center; margin-top: 10px;">
        <input type="submit" value="UpdateFood" name="action">
        <input type="reset" value="Clear">
        </div>
        
    <br>
    
    </form>
</div>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>