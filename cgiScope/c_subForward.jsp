<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="EUC-KR">
	<title>subForward</title>
	</head>
	<body>
		<%
			String xxx = request.getParameter("parameter_key");
			String mid = request.getParameter("mid");
			String mpw = request.getParameter("mpw");
			out.println("c_subForward.jsp :::  xxx >>> : " + xxx + "<br>");
			out.println("c_subForward.jsp :::  mid >>> : " + mid + "<br>");
			out.println("c_subForward.jsp :::  mpw >>> : " + mpw + "<br>");
			System.out.println("c_subForward.jsp :::  xxx >>> : " + xxx);
			System.out.println("c_subForward.jsp :::  mid >>> : " + mid);
			System.out.println("c_subForward.jsp :::  mpw >>> : " + mpw);	
		%>
		<h2>forward Action Tag</h2>
		<hr><font color="blue">
		������ �ִ� c_actionForward.jsp�� ����� ������ �ʽ��ϴ�.<br>
		forward �±״� ������ �Ӽ� ���Ϸ� ��� �ѱ�ϴ�.<br>
		
		�� �κ��� forward �±װ� �ִ� �ڸ��� 
		c_subForward.jsp�� ������� ��� �˴ϴ�.<br>
		
		
		���Ŀ� �ִ� c_actionForward.jsp ���� �� �κ��� ����� ������ �ʽ��ϴ�.<br>
		</font>
	</body>
</html>