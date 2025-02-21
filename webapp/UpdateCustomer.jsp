<%@page import="com.dao.CustomerDaoImpl"%>
<%@page import="com.pojo.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="Validation.js"></script>
</head>
<body>

<jsp:include page="UserHeader.jsp"></jsp:include>

<%
Customer cust = new Customer();

String uEmail = (String)session.getAttribute("uEmail");

String emailId = request.getParameter("emailId");

CustomerDaoImpl cobj = new CustomerDaoImpl();

cust = cobj.searchCustomerById(emailId);

%>

<div id="templatemo_container">

<form action="customer" method="post" onsubmit="return UpdateCustValidation()" class="main">
<br>
  <table border="1" style="margin: 0 auto; text-align: center;">
  
    <caption> <h1> Edit Profile </h1> </caption>
    
    <tr>
        <td>Name:</td>
        <td> <input type="text" name="cname" id="cname" value="<%=cust.getCustomerName()%>"> </td>
        <td> <span id="cnameerror" style="color: red"></span> </td>
    </tr>
    
    <tr>
        <td>EmailId:</td>
        <td> <input type="email" name="email" id="email" value="<%=emailId%>"> </td>
        <td> <span id="emailerror" style="color: red"></span> </td>
    </tr>
    
    <tr>
        <td>Password:</td>
        <td> <input type="password" name="pass" id="pass" value="<%=cust.getCustomerPassword()%>"> </td>
        <td> <span id="passeerror" style="color: red"></span> </td>
    </tr>
    
    <tr>
        <td>Contact No.:</td>
        <td> <input type="number" name="cNo" id="cNo" value="<%=cust.getCustomerContactNo()%>"> </td>
        <td> <span id="cNoerror" style="color: red"></span> </td>
    </tr>
    
     <tr>
        <td>Address:</td>
        <td> <input type="text" name="adr" id="adr" value="<%=cust.getCustomerAddress()%>"> </td>
        <td> <span id="adrerror" style="color: red"></span> </td>
    </tr>
  
  </table>
  
<div style="text-align: center; margin-top: 10px;">
<input type="submit" value="UpdateCustomer" name="action">
<input type="reset" value="Clear">
</div>

</form>
<br>
</div>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>