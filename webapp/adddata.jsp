<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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

int quan = Integer.parseInt(request.getParameter("q"));
String fname = request.getParameter("fname");
float price = Float.parseFloat(request.getParameter("price"));
int updateQuan = 0;
float total = 0;

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project1","root","9475@Gopale");

PreparedStatement ps = con.prepareStatement("select * from Cart where foodName = ?");

ps.setString(1, fname);

ResultSet rs = ps.executeQuery();

if(rs.next()){
	
	int quan1 = rs.getInt("quantity");
	
	updateQuan = quan + quan1;
	
}

if(updateQuan>0){
	
	total = updateQuan * price;
	
	PreparedStatement ps1 = con.prepareStatement("update Cart set quantity = ?, totalPrice = ? where foodName = ?;");
	
	ps1.setInt(1, updateQuan);
	ps1.setFloat(2, total);
	ps1.setString(3, fname);
	
	int row = ps1.executeUpdate();
	
}

%>


</body>
</html>