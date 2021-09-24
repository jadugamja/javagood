<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset=EUC-KR>
	<title>b_0</title>
	</head>
	<body>
		<h3>b_0</h3><br>
		setAttribute(java.lang.String, java.lang.Object) :: getAttribute(java.lang.String)
		<hr>
		<%
			// Let it begin Request Scope
			request.setAttribute("key", "value");
			String key = String.valueOf(request.getAttribute("key"));
			out.println("key0 >>> : " + key + "<br>");
		
			ArrayList<String> aList = new ArrayList<String>();
			aList.add("name");
			aList.add("age");
			aList.add("studying in KOSMO");
			aList.add("so tired...");
			request.setAttribute("aListRequest", aList);

			Object obj = request.getAttribute("aListRequest");
			// ????
			if(obj==null) return;
			
			ArrayList<String> aList_1 = (ArrayList<String>)obj;
			if(aList_1 != null && aList_1.size() > 0){
				for(int i=0; i < aList_1.size(); i++){
					out.println("b_0.jsp :: aList_1.get("+i+") >>> : " + aList_1.get(i) + "<br>");
				}
			}
		%>
		<hr>
		<%	
			// Session Scope gogogo
			// ??binding??
			session.setAttribute("key1", "value1");
			String key1 = String.valueOf(session.getAttribute("key1"));
			out.println("key1 >>> : " + key1 + "<br>");
			
			ArrayList<String> aList_2 = new ArrayList<String>();
			aList_2.add("name");
			aList_2.add("age");
			aList_2.add("studying in KOSMO");
			aList_2.add("so tired...");
			request.setAttribute("aListSession", aList_2);

			Object objSession = request.getAttribute("aListSession");
			// ????
			if(objSession==null) return;
			
			ArrayList<String> aListSession = (ArrayList<String>)objSession;
			if(aListSession != null && aListSession.size() > 0){
				for(int i=0; i < aListSession.size(); i++){
					out.println("b_0.jsp :: aListSession.get("+i+") >>> : " + aListSession.get(i) + "<br>");
				}
			}
		%>
		<hr>
		<%	
			// Application Scope get it started
			application.setAttribute("key2", "value2");
			String key2 = String.valueOf(application.getAttribute("key2"));
			out.println("key2 >>> : " + key2 + "<br>");
		%>
	</body>
</html>