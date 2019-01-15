<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>상세정보</title>
<!-- 자바스크립트 동작을 위한 json파일 연결 해당 jar파일이 라이브러리에 있어야 한다. -->
<script src="scripts/jquery-2.1.0.min.js" type="text/javascript"></script>
<script src="scripts/menucomment.js" type="text/javascript"></script>
<style>
	#popupmenu_body{
		color: white;
	}
	
	
</style>
</head>
	<body id="popupmenu_body" background="resources/menu.jpg">
	<center>
	<input type="hidden" id="dish_num" value="${article.dish_num}">
	<table border="0">
		<tr>
			<td>${article.title}
		</tr>
		<tr>
			<td><img src="download.menu?fname=${article.pic_name}"
				style="cursor: pointer" /></td>
		</tr>
		<tr>
			<td>${article.menu_content}</td>
		</tr>
	</table>
	<input type="button" value="댓글보기" id="show_comment" />
	<br>
	<input type="text" id="comment_content" />
	<input type="button" value="댓글쓰기" id="menu_write_comment" />
	<div id="comment_show">
	</div>
	</center>
	</body>
</html>
