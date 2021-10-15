<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>formdata_return</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			// alert("ready >>> : ");
			
			// GET 방식
			$(document).on("click", "#getbtn", function(){
				alert("getbtn >>> : 진입 ");
				
				$("#formData").attr({
					"action":"formdata_get_servlet.yjs",
					"method":"GET",
					"enctype":"application/x-www-form-urlencoded"
				}).submit();
				
			});
			
			// 스프링 GET 방식
			$(document).on("click", "#get_spring_btn", function(){
				alert("get_spring_btn >>> : 진입 ");
				
				$("#formData").attr({
					"action":"formdata_get_spring.yjs",
					"method":"GET",
					"enctype":"application/x-www-form-urlencoded"
				}).submit();				
			});
			
			// 스프링 POST 방식
			$(document).on("click", "#post_spring_btn", function(){
				alert("post_spring_btn >>> : 진입 ");
				
				$("#formData").attr({
					"action":"formdata_post_spring.yjs",
					"method":"POST",
					"enctype":"application/x-www-form-urlencoded"
				}).submit();					
			});
			
			// 스프링 POST 방식
			$(document).on("click", "#post_spring_btn_111", function(){
				alert("post_spring_btn_111 >>> : 진입 ");
				
				$("#formData").attr({
					"action":"formdata_post_spring_111.yjs",
					"method":"POST",
					"enctype":"application/x-www-form-urlencoded"
				}).submit();			
			});
		})
	
	</script>
</head>
<body>
	<h3 align="center">FORM DATA</h3>
	<hr>
	<form name="formdata" id="formdata">
		<table border="1" align="center">
			<tr>
				<td>회원번호</td>
				<td><input type="text" name="datanum"></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="dataid"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="datapw"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="dataname"></td>
			</tr>
			<tr>
				<td colspan=2>
					<button type="button" id="getbtn">GET</button>
					<button type="button" id="get_spring_btn">GET SPRING</button>
					<button type="button" id="post_spring_btn">POST SPRING</button>
					<button type="button" id="post_spring_btn_111">POST SPRING 111</button>
				</td>
			</tr>		
		</table>
	</form>
</body>
</html>