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
session.setAttribute("aEmail", aEmail);

%>

<jsp:include page="AdminHeader.jsp"/>
<jsp:include page="index1.jsp"/>
<jsp:include page="Footer.jsp"></jsp:include>


</body>
</html>