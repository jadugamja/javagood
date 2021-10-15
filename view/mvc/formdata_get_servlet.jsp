<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>formdata_get_servlet</title>
</head>
<body>
	<h3>스프링 Controller에서 request 객체로 받아오기</h3>
	<hr>
	<%
		String datanum = request.getParameter("datanum");
		String dataid = request.getParameter("dataid");
		String datapw = request.getParameter("datapw");
		String dataname = request.getParameter("dataname");

		// 화면 출력
		System.out.println("formdata_get_servlet :: datanum >> " + datanum);
		System.out.println("formdata_get_servlet :: dataid >> " + dataid);
		System.out.println("formdata_get_servlet :: datapw >> " + datapw);
		System.out.println("formdata_get_servlet :: dataname >> " + dataname);

		// 콘솔 출력
		out.println("formdata_get_servlet :: datanum >> " + datanum);
		out.println("formdata_get_servlet :: dataid >> " + dataid);
		out.println("formdata_get_servlet :: datapw >> " + datapw);
		out.println("formdata_get_servlet :: dataname >> " + dataname);
	%>
	<p>
	<h3>FormDataController에서 el 객체로 받아오기</h3>
	<hr>
	${el_datanum }<br>
	${el_dataid }<br>
	${el_datapw }<br>
	${el_dataname }<br>
	<br />
	
	<h3>FormDataController에서 request.setAttribute() 객체로 받아오기</h3>
	<hr>
	${request_datanum }
	${request_dataid }
	${request_datapw }
	${request_dataname }

</body>

</html>