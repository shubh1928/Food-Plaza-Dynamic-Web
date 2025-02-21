<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

    String aEmail = (String) session.getAttribute("aEmail"); 
    String uEmail = (String) session.getAttribute("uEmail");  

    if (aEmail != null) {
%>
    <jsp:include page="AdminHeader.jsp"></jsp:include>
    <div id="templatemo_container">
<%
    } else if (uEmail != null) {
%>
    <jsp:include page="UserHeader.jsp"></jsp:include>
    <div id="templatemo_container">
<%
    } else {
%>
	<jsp:include page="Header.jsp"></jsp:include>
	<div id="templatemo_container">
    <h3 align="center" style="color: red">No session found. Please log in.</h3>
<%
    }
%>

<h2 align="center" style="color: green"> Form Successfully Submitted :)</h2>

</div>

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>