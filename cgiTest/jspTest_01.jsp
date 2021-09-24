<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
	<!-- 
		page : page directive
		contentType : 현재 JSP 문서의 형태(포맷)와 인코딩 설정
		text/html : MIME : 현재 페이지는 html 형식임.
						 : Multipurpose Internet Mail Extensions : 전자 우편을 위한 표준 포맷
				  : 파일 포맷 및 인코딩 설정
		charset="EUC-KR" : 현재 JSP 페이지의 인코딩은 EUC-KR으로 함.
	 -->
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset=EUC-KR>
	<!-- 
		이 페이지의 html 인코딩은 EUC-KR이다.
	 -->
	<title>JSP tags</title>
	</head>
		<body>
			<h3>JSP 태그 사용법</h3>
			<hr>
			<!-- JSP 주석 : 브라우저로 전송 안 됨 -->
			<%
				out.println("this is scriptlet area <br>");
				out.println("you can write java code <br>");
				out.println("1. jsp 내장형 오브젝트 : request response <br>");
				out.println("2. servlet code <br>");
				out.println("3. java code");
				out.println("4. 프로그램 실행 결과만 클라이언트로 응답한다. <br>");
				out.println(new Date() + "<br>");
			%>
			<hr>
			<%= "this is expression area" %><br>
			<%= "브라우저의 출력을 담당한다." %><br>
			<%= "sriptlet에서 쓰는 out.println(); 같은 기능을 한다." %><br>
			<!-- 태그 안에서 ; 안 쓰는 거 조심 -->
			<%= new Date() %><br>
			<hr>
			<%@ include file="jspTest.jsp" %>
		</body>
</html>