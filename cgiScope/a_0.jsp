<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset=EUC-KR>
	<title>a_0.jsp</title>
	</head>
	<body>
		<h3>a_0.jsp</h3>
		<%= new Date() %> 
		<hr>
		<form action="/testYjs/cgiScope/a_1.jsp" method="GET">
		���̵�    <input type="text" name="mid"><br>
		��й�ȣ <input type="text" name="mpw"><br>
		<input type="submit" value="������">
		</form>
	</body>
</html>