<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="a.b.c.cgitest.EmpVO" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="EUC-KR">
	<title>dispatcherSelect.jsp</title>
	</head>
		<body>
		<h3>dispatcherSelect.jsp</h3>
		<hr>
		<%
			Object obj = request.getAttribute("nCnt");
			if (obj == null) return;
			
			int nCnt = ((Integer)obj).intValue();
			
			if (1 == nCnt){
				System.out.println("�α��� ���� >>> : " + nCnt);	
		%>
			<script>
				alert("�α��� ����");
				location.href="/testYjs/cgiTest/jspTest_01.jsp";
			</script>
		<% 		
			}
		%>
		</body>
</html>