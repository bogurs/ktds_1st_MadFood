<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
<div style="position: absolute; left: 30px; top:20px;">
<c:if test="${login_error == 1}">
		<img src="resources\login_error.jpg" width="30" height="30">
		<I><font color="brown">아이디를 입력해주세요.</font></I><br>
</c:if>
<c:if test="${login_error == 2}">
		<img src="resources\login_error_1.jpg" width="30" height="30">
		<I><font color="brown">비밀번호를 입력해주세요.</font></I><br>
</c:if>
<c:if test="${login_error == 3}">
		<img src="resources\login_error_2.jpg" width="30" height="30">
		<I><font color="brown">비밀번호가 틀렸습니다.</font></I><br>
</c:if>
<c:if test="${login_error == 4}">
		<img src="resources\login_error_3.jpg" width="30" height="30">
		<I><font color="brown">아이디가 존재하지 않습니다.</font></I><br>
</c:if>
</div>

<%@include file="login.jsp" %>
</body>
</html>