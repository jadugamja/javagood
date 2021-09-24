<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset=EUC-KR>
	<title>Ŭ���̾�Ʈ ���� ����</title>
	</head>
		<body>
			<h3>Client and Server's Information</h3>
			<hr>
			<%
				/*
					jsp���� request ������ ������Ʈ(Built-In Object) �����ϸ�
					HttpServletRequset Interface�� �ִ� �ڿ��� ����� �� ����.
					IPv4 : 192.168.0.4 (�츮��)
						���� Wi-fi
					IPv6 : 0:0:0:0:0:0:0:1
						(IPv4�� ���� Ȯ���� ������ ���ͳ� �ּ� ü��)
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
				
				// context = �۾� ����, ������Ʈ �̸�, �ڵ����Ρ� : �� ���� ���α׷�
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