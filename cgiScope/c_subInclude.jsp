<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="EUC-KR">
	<title>subInclude</title>
	</head>
	<body>
		<%
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
		%>
		<br>
		<%= "c_subInclude.jsp ::: id >>> : " + id %><br>
		<%= "c_subInclude.jsp ::: ipw >>> : " + pw %>
		<hr>
		<font color=blue>
		�� �κ��� include �±װ� �ִ� �ڸ��� sub.jsp�� ����� ��Ÿ���� �˴ϴ�. 	
		</font>
	</body>
</html>