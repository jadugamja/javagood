<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset=EUC-KR>
	<title>Action Forward Tag</title>
	</head>
	<body>
		<h2>Forward Action Tag</h2>
		actionForward.jsp ���� ���� �κ��Դϴ�. <br>
		forward tag�� ������ �Ӽ� ���Ϸ� ��� �ѱ�ϴ�. <br>
		actionForward.jsp �������� ������ �ϳ��� ��µ��� �ʽ��ϴ�. <br>
		
		<%
			String mid = "yjs00";
			String mpw = "yjs1234";
		%>
	
		<jsp:forward page="c_subForward.jsp">
			<jsp:param value="data_value" name="parameter_key"/>
			<jsp:param value="<%= mid %>" name="mid"/>
			<jsp:param value="<%= mpw %>" name="mpw"/>
		</jsp:forward>

		actionForward.jsp ���� �� �κ��Դϴ�.<br>
	</body>
</html>