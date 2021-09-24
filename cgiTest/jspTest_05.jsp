<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset=EUC-KR>
	<title>클라이언트 서버 정보</title>
	</head>
		<body>
			<h3>Client and Server's Information</h3>
			<hr>
			<%
				/*
					jsp에서 request 내장형 오브젝트(Built-In Object) 선언하면
					HttpServletRequset Interface에 있는 자원을 사용할 수 있음.
					IPv4 : 192.168.0.4 (우리집)
						무선 Wi-fi
					IPv6 : 0:0:0:0:0:0:0:1
						(IPv4를 대폭 확장한 차세대 인터넷 주소 체계)
					http://192.168.0.4:8088/testYjs/cgiTest/jspTest_05.jsp
				*/
				String remoteAddr = request.getRemoteAddr();
				out.println("remoteAddr >>> : " + remoteAddr + "<br>");
				
				String protocol = request.getProtocol();
				out.println("protocol >>> : " + protocol + "<br>");
				
				String method = request.getMethod();
				out.println("method >>> : " + method + "<br>");
				
				String uri = request.getRequestURI();
				out.println("uri >>> : " + uri + "<br>");
				
				String url = request.getRequestURL().toString();
				out.println("url >>> : " + url + "<br>");
				
				// context = 작업 폴더, 프로젝트 이름, ★도메인★ : 웹 응용 프로그램
				String context = request.getContextPath();
				out.println("context >>> : " + context + "<br>");
				
				String serverName = request.getServerName();
				out.println("serverName >>> : " + serverName + "<br>");
				
				String serverPort = String.valueOf(request.getServerPort());
				out.println("serverPort >>> : " + serverPort + "<br>");
				
				String remotePort = String.valueOf(request.getRemotePort());
				out.println("remotePort >>> : " + remotePort);
			%>
		</body>
</html>