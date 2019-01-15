<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
<link href="css/default.css" rel="stylesheet" type="text/css" />
<script src="scripts/jquery.js" type="text/javascript"></script>
<script src="scripts/init.js" type="text/javascript"></script>
<style>
	#a{
		position: absolute;
		top: 80px;
		left: 500px;
	}
</style>
</head>
<body>

<div class="menu">
<jsp:include page = "/WEB-INF/views/main_header.jsp" flush="true"/>    
</div>
 
<div id="a" align="center">
	<h1>글쓰기</h1><br><br>
		<form action="/food/qna_writeOk.ktds" method="post">
		<input type="hidden" name="pageNum" value="${pageNum }">
		<!-- form의 enctype이 multipart면 req.getPara가 먹지 않는다 -->
		<!-- 이것을 쓰기 위해서 req.getPart로 사용해서 읽어온다. -->
		<!-- 근데 req.getPara로도 읽을 수 있다>하지만, 한글을 인식하지 못한다 -->
			<table class="tblGreen"> <!-- 확인 버튼을 누르면 list로 돌아가면서 한 줄 추가(쿼리 실행) -->
				<tr>
					<th> 제목 | </th>
					<td> <input type="text" name="title" id="title" size="100"> </td>
				</tr>
				
				<tr>
					<th> ID | </th>
					<td> ${id } </td>
				</tr>
				
				<tr>
					<th> 내용 | </th>
					<td> <textarea name="content" rows="25" cols="87"></textarea> </td>
				</tr>
			</table>
			<input type="submit" value="확인">
			<input type="button" value="취소" onclick="document.location.href='/food/qna_list.ktds?pageNum=${pageNum}'">
			<c:if test="${write_error ==1 }">
				<h3><b><i><u><font color="red">글 제목과 내용을 모두 입력하세요!!</font></u></i></b></h3>
			</c:if>
	</form>
	</div>

<div id="b">
<jsp:include page = "/WEB-INF/views/main_aside.jsp" flush="true"/>
</div>

</body>
</html>