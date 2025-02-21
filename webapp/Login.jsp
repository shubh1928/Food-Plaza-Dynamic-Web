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

<jsp:include page="Header.jsp"></jsp:include>

<div id="templatemo_container">

<form name="form" action="login" method="post" onsubmit="return LoginValidation()">

<br>  <h1 style="text-align: center;">Login</h1>
  <table border="1" align="center" style="text-align: center;">
  
  <tr>
  <td>Select:</td>
  <td> <select name="type" id="type">
        <option>Select</option>
        <option value="admin">Admin</option>  
        <option value="user">User</option>  
       </select> 
  </td>
  <td> <span id="selecterror" style="color: red"></span> </td>
  </tr>
  
  <tr>
  <td>EmailID:</td>
  <td> <input type="email" name="email" id="email"/> </td>
  <td> <span id="emailerror" style="color: red"></span> </td>
  </tr>
  
  <tr>
  <td>Password:</td>
  <td> <input type="password" name="pass" id="pass"/> </td>
  <td> <span id="passerror" style="color: red"></span> </td>
  </tr>
  
  </table>
  
  <div style="text-align: center; margin-top: 10px;">
  <input type="submit" value="Login" name="action"/>
  <input type="reset" value="Reset">
  </div>
  
  <br>
  
</form>

</div>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>