<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>c_staticInclude</title>
</head>
<body>
	<%@ include file="c_header.jsp" %>
	<hr><p>
	include directive : &lt;%@ include file="file_name" %&gt; <p>
	<hr><p>
	<%@ include file="c_footer.html" %>
</body>
</html>