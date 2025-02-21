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

<jsp:include page="Header.jsp"></jsp:include>

<div id="templatemo_container" class="parent">

<form action="customer" method="post" onsubmit="return AddCustValidation()" class="main">

<table border="2" align="center" style="text-align: center;">
<br>
  <caption> <h1>Add Customer</h1> </caption>
  
  <tr>
  <td>Name:</td>
  <td> <input type="text" name="cname" id="cname"> </td>
  <td> <span id="cnameerror" style="color: red"></span> </td>
  </tr>
 
  <tr>
  <td>EmailId:</td>
  <td> <input type="email" name="email" id="email"> </td>
  <td> <span id="emailerror" style="color: red"></span> </td>
  </tr>
  
  <tr>
  <td>Password:</td>
  <td> <input type="password" name="pass" id="pass"> </td>
  <td> <span id="passerror" style="color: red"></span> </td>
  </tr>  
  
  <tr>
  <td>Address:</td>
  <td> <input type="text" name="adr" id="adr"> </td>
  <td> <span id="adreerror" style="color: red"></span> </td>
  </tr>
  
  <tr>
  <td>ContactNo:</td>
  <td> <input type="number" name="cNo" id="cNo"> </td>
  <td> <span id="cNoerror" style="color: red"></span> </td>
  </tr>

</table>

<div style="text-align: center; margin-top: 10px;">
<input type="submit" value="AddCustomer" name="action">
<input type="reset" value="Clear">
</div>
<br>
</form>

</div>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>