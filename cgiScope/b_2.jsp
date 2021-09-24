<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="EUC-KR">
	<title>b_2</title>
	</head>
	<body>
		<h3>b_2</h3>
		<hr>
		<%
			String key = String.valueOf(request.getAttribute("key")); 
			out.println("key >>> : " + key + "<br>");
			
			String key1 = String.valueOf(session.getAttribute("key1")); 
			out.println("key1 >>> : " + key1 + "<br>");
			
			String key2 = String.valueOf(application.getAttribute("key2")); 
			out.println("key2 >>> : " + key2);
		%>
	</body>
</html>