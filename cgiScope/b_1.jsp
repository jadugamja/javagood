<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset=EUC-KR>
	<title>b_1</title>
	</head>
	<body>
		<h3>b_1</h3>
		<hr>
		<%
			String key = String.valueOf(request.getAttribute("key")); 
			out.println("b_1.jsp :: key >>> : " + key + "<br>");

			Object obj = request.getAttribute("aListRequest");
			// ????
//			if(obj==null) return;
			
			ArrayList<String> aList_1 = (ArrayList<String>)obj;
			if(aList_1 != null && aList_1.size() > 0){
				for(int i=0; i < aList_1.size(); i++){
					out.println("b_1.jsp :: aList_1.get("+i+") >>> : " + aList_1.get(i) + "<br>");
				}
			}
		%>
		<hr>
		<%	
			String key1 = String.valueOf(session.getAttribute("key1")); 
			out.println("key1 >>> : " + key1 + "<br>");
			
			Object objSession = session.getAttribute("aListSession");
			ArrayList<String> aListSession_1 = (ArrayList<String>)objSession;
			if(aListSession_1 != null && aListSession_1.size() > 0){
				for(int i=0; i < aListSession_1.size(); i++){
					out.println("b_1.jsp :: aListSession_1.get("+i+") >>> : " + aListSession_1.get(i) + "<br>");
				}
			}
		%>
		<hr>
		<%	
			String key2 = String.valueOf(application.getAttribute("key2"));
			out.println("key2 >>> : " + key2);

//			Object objApplication = application.getAttribute("aListApplication");
//			ArrayList<String> aListApplication = (ArrayList<String>)objApplication;
//			if(aListApplication != null && aListApplication.size() > 0){
//				for(int i=0; i < aListApplication.size(); i++){
//					out.println("b_1.jsp :: aListApplication.get("+i+") >>> : " + aListApplication.get(i) + "<br>");
//				}
//			}
		%>
	</body>
</html>