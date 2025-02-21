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
    
    String dpass = (String) session.getAttribute("dpass");
    String opass = (String) session.getAttribute("opass");
    
    String npass = (String) session.getAttribute("npass");
    String cpass = (String) session.getAttribute("cpass");
    
    String empty = (String) session.getAttribute("EmptyMsg1"); 

    if (aEmail != null) {
%>
    <jsp:include page="AdminHeader.jsp"></jsp:include>
    
    <div id="templatemo_container">


<%    } else if (uEmail != null) { %>

    <jsp:include page="UserHeader.jsp"></jsp:include>
    
    <div id="templatemo_container">
    
<%   if(empty.equals("hey")) { %>
	
    <h2 align="center" style="color: red">Cart List Is Empty.</h2>
<%    
    }
%>
    
<% } else { %>

	<jsp:include page="Header.jsp"></jsp:include>
	
	<div id="templatemo_container">
	
    <h3 align="center" style="color: red">No session found. Please log in.</h3>
<%
    }
%>


 <% if ((npass != null && cpass != null) || (dpass != null && opass != null)) { %>


   <% if (!npass.equals(cpass) && npass != null && cpass != null) { %>
   
   <%  npass = null;
       cpass = null; %>
    
    <h3 align="center" style="color: red">New & Confirm Password didn't matched</h3>
    
   <% } else if (!dpass.equals(opass) && dpass != null && opass != null) { %>
   
   <%  dpass = null;
       opass = null; %>
    
    <h3 align="center" style="color: red">You have entered wrong old password</h3>
    
   <% } else { %>
   
   <h2 align="center" style="color: red">Failed To Submit The Form :(</h2>
 
  <% } %>
   
 <% } else {%>
 
    <h2 align="center" style="color: red">Failed To Submit The Form :(</h2>
 
  <% } %>


</div>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>