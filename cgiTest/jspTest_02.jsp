<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset=EUC-KR>
	<title>DB Connection</title>
	</head>
		<body>
			<%--
				ojdbc6.jar 드라이버를  포팅한다.
				testYjs/WebContent/WEB-INF/lib/ojdbc6.jar
				 -> testYjs context(프로젝트, 도메인, 작업 디렉토리)에서만 사용!  
				Java Resources/src/a.b.c.cgitest/JspTestServlet_4.java
				WebContent/WEB-INF/lib/ojdbc6.jar
				
				~OPEN ROOT~
				C:\Program Files\Java\jdk1.8.0_291\jre\lib\ext\ojdbc6.jar
			 --%>
			<% 
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclJSY", "scott", "tiger");
				Statement stmt = conn.createStatement(); 
				ResultSet rts = stmt.executeQuery("SELECT * FROM EMP");
				while (rts.next()){
					out.println(rts.getString(1) + ": ");
					out.println(rts.getString(2) + ": ");
					out.println(rts.getString(3) + ": ");
					out.println(rts.getString(4) + ": ");
					out.println(rts.getString(5) + ": ");
					out.println(rts.getString(6) + ": ");
					out.println(rts.getString(7) + ": ");
					out.println(rts.getString(8) + "<br>");
				}
			%>
		</body>
</html>