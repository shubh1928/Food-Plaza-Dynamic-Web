<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="Validation.js"></script>
<link href="templatemo_style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<jsp:include page="AdminHeader.jsp"></jsp:include>

<div id="templatemo_container" class="parent">

<form action="food" method="post" onsubmit="return AddFoodValidation()" class="main">
 
<table border="2" style="margin: 0 auto; text-align: left;">

  <caption> <h1>Add Food</h1> </caption>
  
  <br>
  
  <tr>
  <td>Food Type:</td>
  <td> <input type="text" name="ftype" id="ftype"> </td>
  <td> <span id="ftypeerror" style="color: red"></span> </td>
  </tr>
  
  <tr>
  <td>Food Name:</td>
  <td> <input type="text" name="fname" id="fname"> </td>
  <td> <span id="fnameerror" style="color: red"></span> </td>
  </tr>  
  
  <tr>
  <td>Food Quantity:</td>
  <td> <input type="number" name="fquantity" id="fquantity"> </td>
  <td> <span id="fquantityerror" style="color: red"></span> </td>
  </tr>
  
  <tr>
  <td>Food Price:</td>
  <td> <input type="number" name="fprice" id="fprice"> </td>
  <td> <span id="fpriceerror" style="color: red"></span> </td>
  </tr>

</table>

<div style="text-align: center; margin-top: 10px;">
<input type="submit" value="AddFood" name="action">
<input type="reset" value="Clear">
</div>

</form>
<br>
</div>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>