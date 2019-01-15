<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="scripts/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="scripts/join.js"></script>
<title>회원가입</title>
</head>
<body background="resources/content.jpg">
	<form action="/food/join.etc" method="post">
		<center>
			<table border="2" width="200">
				<tr>
					<td>ID</td>
					<td><input type="text" name="id" id="id" maxlength="8"></td>
					<td><input type="button" id="searchmember" value="중복 조회"></td>
				</tr>

				<tr>
					<td>Password</td>
					<td><input type="password" id="pass" name="pass" maxlength="8"></td>
				</tr>

				<tr>
					<td>Password확인</td>
					<td><input type="password" id="pass1" name="pass1"
						maxlength="8">
					<td><div id="show_pass1"></div></td>
				</tr>

				<tr>
					<td>name</td>
					<td><input type="text" id="name" name="name" maxlength="20"></td>
				</tr>

				<tr>
					<td>Phone number</td>
					<td><input type="text" id="phonenumber" name="phonenumber"
						maxlength="11"
						onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"
						onkeypress="NumObj(this)"></td>
					<td>(-) 생략</td>
				</tr>
				<tr>
				<tr>
					<td>주소</td>
					<td><input type="text" id="address" name="address"
						maxlength="20"></td>
				</tr>

				<tr>
					<td><input type="submit" value="가입하기" disabled="disabled"
						id="song"></td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>