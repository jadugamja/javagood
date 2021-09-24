<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="EUC-KR">
	<title>fileUpload.jsp</title>
	</head>
		<body>
		<h3>fileUpload.jsp</h3>
		<hr>
		<%
			// 이거 진짜???
			Object obj = request.getAttribute("aList");
			if (obj == null) return;
			
			ArrayList<String> aList = (ArrayList<String>)obj;
			
			if (aList !=null && aList.size() > 0){
				for (int i=0; i < aList.size(); i++){			
					out.println(">>> : " + aList.get(i) + "<br>");		
				}		
			}
		%>
		<!-- 테이블 박사가 만든... -->
		<table border="1">
		  <tr>
			<td><img src="/testYjs/fileupload/<%= aList.get(2) %>"></td>
			<td><img src="/testYjs/fileupload/<%= aList.get(2) %>"></td>
			<td><img src="/testYjs/fileupload/<%= aList.get(2) %>"></td>
			<td><img src="/testYjs/fileupload/<%= aList.get(2) %>"></td>
		  </tr>
		  <tr>
			<td><img src="/testYjs/fileupload/<%= aList.get(3) %>"></td>
			<td><img src="/testYjs/fileupload/<%= aList.get(3) %>"></td>
			<td><img src="/testYjs/fileupload/<%= aList.get(3) %>"></td>
			<td><img src="/testYjs/fileupload/<%= aList.get(3) %>"></td>
		  </tr>
		  <tr>
			<td><img src="/testYjs/fileupload/<%= aList.get(2) %>"></td>
			<td><img src="/testYjs/fileupload/<%= aList.get(2) %>"></td>
			<td><img src="/testYjs/fileupload/<%= aList.get(2) %>"></td>
			<td><img src="/testYjs/fileupload/<%= aList.get(2) %>"></td>
		  </tr>
		   <tr>
			<td><img src="/testYjs/fileupload/<%= aList.get(3) %>"></td>
			<td><img src="/testYjs/fileupload/<%= aList.get(3) %>"></td>
			<td><img src="/testYjs/fileupload/<%= aList.get(3) %>"></td>
			<td><img src="/testYjs/fileupload/<%= aList.get(3) %>"></td>
		  </tr>
		  </table>	
		</body>
</html>