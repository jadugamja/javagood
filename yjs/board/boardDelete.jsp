<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="EUC-KR">
	<title>�ۻ���</title>
	</head>
		<body>
		<h3>�ۻ���</h3>
		<hr>
		<%
			Object obj = request.getAttribute("bDelete");
			if (obj == null) return;
				
			boolean bool = ((Boolean)obj).booleanValue();
			
			if (bool){
				System.out.println("���� ����  bool >>> : " + bool);
		%>
				<script>
					location.href="/testYjs/board?ISUD_TYPE=D";
				</script>
		<%		
			}
			else{
				
			}
		%>
		</body>
</html>