<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
	<!-- 
		page : page directive
		contentType : ���� JSP ������ ����(����)�� ���ڵ� ����
		text/html : MIME : ���� �������� html ������.
						 : Multipurpose Internet Mail Extensions : ���� ������ ���� ǥ�� ����
				  : ���� ���� �� ���ڵ� ����
		charset="EUC-KR" : ���� JSP �������� ���ڵ��� EUC-KR���� ��.
	 -->
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset=EUC-KR>
	<!-- 
		�� �������� html ���ڵ��� EUC-KR�̴�.
	 -->
	<title>JSP tags</title>
	</head>
		<body>
			<h3>JSP �±� ����</h3>
			<hr>
			<!-- JSP �ּ� : �������� ���� �� �� -->
			<%
				out.println("this is scriptlet area <br>");
				out.println("you can write java code <br>");
				out.println("1. jsp ������ ������Ʈ : request response <br>");
				out.println("2. servlet code <br>");
				out.println("3. java code");
				out.println("4. ���α׷� ���� ����� Ŭ���̾�Ʈ�� �����Ѵ�. <br>");
				out.println(new Date() + "<br>");
			%>
			<hr>
			<%= "this is expression area" %><br>
			<%= "�������� ����� ����Ѵ�." %><br>
			<%= "sriptlet���� ���� out.println(); ���� ����� �Ѵ�." %><br>
			<!-- �±� �ȿ��� ; �� ���� �� ���� -->
			<%= new Date() %><br>
			<hr>
			<%@ include file="jspTest.jsp" %>
		</body>
</html>