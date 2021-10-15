<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="a.b.c.com.vo.FormDataVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>formdata_post_model_attribute_return</title>
</head>
<body>
	<h3>formdata_post_model_attribute_return</h3>
	<hr>
	
	<p>
	<h3>EL 표현식으로 데이터 추출</h3>
	$ {ma_fdvo } >>> : ${ma_fdvo }<br>
	$ {ma_fdvo.datanum } >>> : ${ma_fdvo.datanum }<br>
	$ {ma_fdvo.dataid } >>> : ${ma_fdvo.dataid}<br>
	$ {ma_fdvo.datapw } >>> : ${ma_fdvo.datapw }<br>
	$ {ma_fdvo.dataname } >>> : ${ma_fdvo.dataname }<br>
	<hr>

	<p>
	<h3>EL 표현식으로 데이터 추출</h3>
	$ {ma_fdvo } >>> : ${ma_fdvo }<br>
	$ {ma_fdvo.getDatanum() } >>> : ${ma_fdvo.getDatanum() }<br>
	$ {ma_fdvo.getDataid() } >>> : ${ma_fdvo.getDataid()}<br>
	$ {ma_fdvo.getDatapw() } >>> : ${ma_fdvo.getDatapw() }<br>
	$ {ma_fdvo.getDataname() } >>> : ${ma_fdvo.getDataname() }<br>

	<p>
	<h3>request.getAttribute() 객체로 데이터 추추르</h3>
	<hr>
	<%
		Object obj = request.getAttribute("ma_fdvo");
		// 이건 스프링이 객체 저장하는 네임컨벤션이얌.. 다음부터 참조변수는 축약해두 괜차너
		FormDataVO formDataVO = (FormDataVO)obj;
		
		System.out.println("formdata_post_spring_modelattribute_return.jsp >>> : fdvo >>> : " 
							+ formDataVO);
		out.println("formdata_post_spring_modelattribute_return.jsp >>> : fdvo >>> : "
					+ formDataVO + "<br>");
	%>
</body>
</html>