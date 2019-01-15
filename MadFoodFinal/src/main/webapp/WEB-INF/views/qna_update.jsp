<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글수정</title>
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
	<h1>글수정</h1><br><br>
		<form action="/food/qna_update.ktds" method="post">
			<input type="hidden" name="pageNum" value="${pageNum }">
			<input type="hidden" name="article_num" value="${article_num }">
			
			<table> <!-- 확인 버튼을 누르면 list로 돌아가면서 한 줄 추가(쿼리 실행) -->
				<tr>
					<th> 제목 | </th>
					<td> <input type="text" name="title" size="100" value=${article.title }> </td>
				</tr>
				
				<tr>
					<th> ID | </th>
					<td> ${id } </td>
				</tr>
				
				<tr>
					<th> 내용 | </th>
					<td> <textarea name="content" rows="25" cols="87">${article.content }</textarea> </td>
				</tr>
				
			</table>
			<input type="submit" value="수정">
			<input type="button" value="수정취소" onclick="document.location.href='/food/qna_content.ktds?article_num=${article_num}&pageNum=${pageNum }'">
			<c:if test="${update_error ==1 }">
				<h3><b><i><u><font color="red">글 제목과 내용을 모두 입력하세요!!</font></u></i></b></h3>
			</c:if>
		</form>
	<br><br><br>
</div>
	
<div id="b">
   <jsp:include page = "/WEB-INF/views/main_aside.jsp" flush="true"/>
</div>
</body>
</html>