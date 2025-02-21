<%@page import="java.util.Iterator"%>
<%@page import="com.pojo.Food"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String uEmail = (String) session.getAttribute("uEmail");
String aEmail = (String) session.getAttribute("aEmail");
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

<div id="templatemo_container" class="parent">

<div class="child">
     <form>
          <table border="1" style="margin: 0 auto; text-align: center;">
          
                <caption>
                   <br> <h1>LOGOUT</h1>
                </caption>
               
                <tr>
                    
                    <c:if test="${uEmail == null && aEmail != null}">
                         <th colspan="2">Sure You Want To Logout?</th>
                    </c:if>
                    
                     <c:if test="${uEmail != null && aEmail == null}">
                         <th colspan="2">Sure You Want To Logout?</th>
                    </c:if>
                    
                </tr>
       
                <tr>
                    
                    <c:if test="${uEmail == null && aEmail != null}">
                         <td><a href="AdminLogin.jsp">No</a></td>
                         <td><a href="login">YES</a></td>
                    </c:if>
                    
                    <c:if test="${uEmail != null && aEmail == null}">
                        <td><a href="UserLogin.jsp">NO</a></td>
                        <td><a href="login">YES</a></td>
                    </c:if>
                    
                </tr>
                
          </table>  
        <br>     
     </form>
</div>

</div>
     
     <jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>