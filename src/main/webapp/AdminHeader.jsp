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
String aEmail = (String)session.getAttribute("aEmail");
%>

<div id="templatemo_container">

    <div id="templatemo_header">
    
        <div id="site_title"></div>
    
    </div>
    
<!--  end of header  -->

    <div id="templatemo_menu">
    
    <ul >  
    <li><a href="AddFood.jsp"><b>Add Food</b></a></li>
    <li><a href="food"><b>Food List</b></a></li>
    <li><a href="customer"><b>Customer List</b></a></li>
    <li><a href="feedback"><b>FeedBack List</b></a></li>
    <li><a href="ChangePassword.jsp"><b>Change Password</b></a></li>
    <li><a href="login"><b>Logout</b></a></li>
    </ul>
    
    </div>

</div>

</body>
</html>