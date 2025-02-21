<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<%
String uEmail = (String)session.getAttribute("email");
session.setAttribute("uEmail", uEmail);
%>

<div id="templatemo_container">

    <div id="templatemo_header">
    
        <div id="site_title"></div>
    
    </div>
    
<!--  end of header  -->

    <div id="templatemo_menu">
    
    <ul >  
    <li><a href="food"><b>Food List</b></a></li>
    <li><a href="cart"><b>Cart List</b></a></li>
    <li><a href="AddFeedback.jsp"><b>Add Feedback</b></a></li>
    <li><a href="ChangePassword.jsp"><b>Change Password</b></a></li>
    <li><a href="UpdateCustomer.jsp?emailId=<%=uEmail%>"><b>Edit Profile</b></a></li>
    <li><a href="Logout.jsp"><b>Logout</b></a></li>
    </ul>
    
    </div>

</div>

</body>
</html>