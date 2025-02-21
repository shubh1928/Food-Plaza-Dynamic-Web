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

String uEmail = (String)session.getAttribute("uEmail");
session.setAttribute("email", uEmail);

%>

<jsp:include page="UserHeader.jsp"/>
<jsp:include page="index1.jsp"/>
<jsp:include page="Footer.jsp"/>

</body>
</html>