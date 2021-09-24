<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
		<script type="text/javascript">
		</script>
		<style type="text/css">
		</style>
			</head>
				<body>
					Hello JSP
					<%
						out.println("scriptlet tag" + "<br>");
						out.println("this is server side script area" + "<br>");
						out.println("browser can't read it" + "<br>");
						out.println("서버에서 ?결과를 만들어서? 전달해준 내용만 읽는다.");
					%>
				</body>
</html>
<?xml version="1.0" encoding="UTF-8" ?>
<root>
	<test>test</test>
</root>
