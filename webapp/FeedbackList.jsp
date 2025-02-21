<%@page import="java.util.Iterator"%>
<%@page import="com.pojo.Feedback"%>
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
String aEmail = (String) session.getAttribute("aEmail");
String uEmail = (String) session.getAttribute("uEmail");

List<Feedback> l = (List)session.getAttribute("fblist");
%>
     <jsp:include page="AdminHeader.jsp"></jsp:include>

<div id="templatemo_container" class="parent">

<div class="child">
<br>
     <form>
          <table border="1" style="margin: 0 auto; text-align: center;">
          
                <caption>
                 <h1>Feedback List</h1>
                </caption>
                
                <tr>
                    <th>Customer Name</th>
                    <th>Customer Email-ID</th>
                    <th>Review</th>
                    <th>Rank</th>
                    <th>Suggestion</th>
                    
                </tr>

                
                 <%
                
                Iterator <Feedback> itr = l.iterator();
                
                while(itr.hasNext()){
                  Feedback fb = itr.next();
              
                %>
                
                <tr>
                    <td><%=fb.getName()%></td>
                    <td><%=fb.getEmailId()%></td>
                    <td><%=fb.getReview()%></td>
                    <td><%=fb.getRank()%></td>
                    <td><%=fb.getSuggestion()%></td>
                    
                </tr>
                
                <% } %>
                
          </table>
          
     </form>

</div>

<br>

</div>


<jsp:include page="Footer.jsp"></jsp:include>


</body>
</html>