<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="EUC-KR">
	<title>a_1.jsp</title>
	</head>
	<body>
		<h3>a_1.jsp</h3>
		<%= new Date() %>
		<hr>
		<%
			String mid = request.getParameter("mid");
			String mpw = request.getParameter("mpw");
			out.println("mid >>> : " + mid + "<br>");
			out.println("mpw >>> : " + mpw + "<br>");
			System.out.println("mid >>> : " + mid);
			System.out.println("mpw >>> : " + mpw);

			if(true){
		%>
		<script>
			location.href="/testYjs/cgiScope/a_2.jsp?mid=<%=mid%> &mpw=<%=mpw%>";	
		</script>	
			<!-- dead code warning -->
			<form action="/testYjs/cgiScope/a_2.jsp" method="GET">
			���̵�    <input type="text" name="mid" value="<%=mid%>"><br>
			�н����� <input type="text" name="mpw" value="<%=mpw%>"><br>
			<input type="submit" value="������">
			</form>
		<%
			}
		%>
	</body>
</html>