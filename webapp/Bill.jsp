
<%@page import="com.pojo.Orders"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script src="Validation.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String uEmail = (String)session.getAttribute("uEmail");
String aEmail = (String)session.getAttribute("aEmail");
%>

<c:if test="${uEmail == null && aEmail == null}">
     <jsp:include page="Header.jsp"></jsp:include>
</c:if>

<c:if test="${uEmail != null && aEmail == null}">
     <jsp:include page="UserHeader.jsp"></jsp:include>
</c:if>

<c:if test="${uEmail == null && aEmail != null}">
     <jsp:include page="AdminHeader.jsp"></jsp:include>
</c:if>

<div id="templatemo_container">

    <form class="main">
    
    
    <%
    Orders od = (Orders)request.getAttribute("order");
    %>
    <br>
    &nbsp;&nbsp;&nbsp;OrderId:<%=od.getOrderID()%>  <br>
    &nbsp;&nbsp;&nbsp;EmailId:<%=od.getEmailID()%>  <br>
    &nbsp;&nbsp;&nbsp;TotalPrice:<%=od.getTotalPrice()%>  <br>
    &nbsp;&nbsp;&nbsp;Date:<%=od.getOrderDate()%>
  
    </form>
  <br>
</div>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>