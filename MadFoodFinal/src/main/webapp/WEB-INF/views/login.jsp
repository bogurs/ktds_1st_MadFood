<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/default.css" rel="stylesheet" type="text/css" />
<script src="scripts/jquery.js" type="text/javascript"></script>
<script src="scripts/init.js" type="text/javascript"></script>
<title>로그인</title>
</head>
<body>

	<div id="a" style="margin-top: 80px;">
		<form action="/food/login.ktds" method="post">
			<table border="1" width="210">
				<!-- 로그인 관리 클래스에 연결한다 -->
				<tr>
					<td><input type="hidden" value="${logined}"></td>
				</tr>
				<tr>
					<td>I&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;D :</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>PASS :</td>
					<td><input type="password" name="pass"></td>
				</tr>
				<tr>
					<td><input type="submit" value="로그인"></td>
					<td><input type="reset" value="초기화"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>