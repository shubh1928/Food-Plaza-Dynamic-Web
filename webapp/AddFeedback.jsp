<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="Validation.js"></script>
<link href="templatemo_style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<jsp:include page="UserHeader.jsp"></jsp:include>

<div id="templatemo_container" class="parent">

<form action="feedback" method="post" onsubmit="return AddFeedValidation()" class="main">
<br>
<table border="2" style="margin: 0 auto; text-align: center;">

  <caption> <h1>Add Feedback</h1> </caption>
  
  <tr>
  <td>Name:</td>
  <td> <input type="text" name="uname" id="uname"> </td>
  <td> <span id="unameerror" style="color: red"></span> </td>
  </tr>
  
  <tr>
  <td>EmailId:</td>
  <td> <input type="email" name="email" id="email"> </td>
  <td> <span id="emailerror" style="color: red"></span> </td>
  </tr>
  
  <tr>
  <td>Review:</td>
  <td> <input type="text" name="review" id="review"> </td>
  <td> <span id="reviewerror" style="color: red"></span> </td>
  </tr>  
  
  <tr>
  <td>Rank:</td>
  <td> <input type="number" name="rank" id="rank"> </td>
  <td> <span id="rankerror" style="color: red"></span> </td>
  </tr>
  
  <tr>
  <td>Suggestion:</td>
  <td> <input type="text" name="sugge" id="sugge"> </td>
  <td> <span id="suggeerror" style="color: red"></span> </td>
  </tr>

</table>

<div style="text-align: center; margin-top: 10px;">
<input type="submit" value="AddFeedback" name="action">
<input type="reset" value="Clear">
</div>

</form>
<br>
</div>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>