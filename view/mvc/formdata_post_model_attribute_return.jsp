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
	<h3>EL ǥ�������� ������ ����</h3>
	$ {ma_fdvo } >>> : ${ma_fdvo }<br>
	$ {ma_fdvo.datanum } >>> : ${ma_fdvo.datanum }<br>
	$ {ma_fdvo.dataid } >>> : ${ma_fdvo.dataid}<br>
	$ {ma_fdvo.datapw } >>> : ${ma_fdvo.datapw }<br>
	$ {ma_fdvo.dataname } >>> : ${ma_fdvo.dataname }<br>
	<hr>

	<p>
	<h3>EL ǥ�������� ������ ����</h3>
	$ {ma_fdvo } >>> : ${ma_fdvo }<br>
	$ {ma_fdvo.getDatanum() } >>> : ${ma_fdvo.getDatanum() }<br>
	$ {ma_fdvo.getDataid() } >>> : ${ma_fdvo.getDataid()}<br>
	$ {ma_fdvo.getDatapw() } >>> : ${ma_fdvo.getDatapw() }<br>
	$ {ma_fdvo.getDataname() } >>> : ${ma_fdvo.getDataname() }<br>

	<p>
	<h3>request.getAttribute() ��ü�� ������ ���߸�</h3>
	<hr>
	<%
		Object obj = request.getAttribute("ma_fdvo");
		// �̰� �������� ��ü �����ϴ� �����������̾�.. �������� ���������� ����ص� ������
		FormDataVO formDataVO = (FormDataVO)obj;
		
		System.out.println("formdata_post_spring_modelattribute_return.jsp >>> : fdvo >>> : " 
							+ formDataVO);
		out.println("formdata_post_spring_modelattribute_return.jsp >>> : fdvo >>> : "
					+ formDataVO + "<br>");
	%>
</body>
</html>