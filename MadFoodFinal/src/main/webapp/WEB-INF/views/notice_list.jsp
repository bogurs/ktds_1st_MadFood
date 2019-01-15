<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>notice_게시판</title>
<link href="css/default.css" rel="stylesheet" type="text/css" />
<script src="scripts/jquery.js" type="text/javascript"></script>
<script src="scripts/init.js" type="text/javascript"></script>
<script src="scripts/searchbranch.js" type="text/javascript"></script>
<style>
#a {
	position: absolute;
	top: 80px;
	left: 500px;
}
</style>
</head>

<body>

	<div class="menu" style="position: absolute; top: 0px; left: 150px;">
		<jsp:include page="/WEB-INF/views/main_header.jsp" flush="true" />
	</div>

	<div id="a" align="center">
		<h1>
			<b>공지사항</b>
		</h1>
		<br>
		<br> <b>(전체 글:${count})</b>
		<table width="700">
			<tr>
				<c:if test="${id == 'ktds' }">
					<td align="right"><a href="/food/notice_writeForm.notice">글쓰기</a>
					</td>
				</c:if>
			</tr>
		</table>

		<c:if test="${count == 0}">
			<table width="700" border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center">게시판에 저장된 글이 없습니다.</td>
				</tr>
			</table>
		</c:if>

		<table border="1" width="700" cellpadding="2" cellspacing="2"
			align="center">
			<tr height="30">
				<td align="center" width="50">번 호</td>
				<td align="center" width="250">제 목</td>
				<td align="center" width="100">작성자</td>
				<td align="center" width="150">작성일</td>
				<td align="center" width="50">조 회</td>
			</tr>

			<c:forEach var="article" items="${articleList}">
				<tr height="30">
					<td align="center" width="50"><c:out
							value="${article.article_num}" /></td>
					<td width="250"><c:if test="${article.depth > 0}">
							<img src="resources\content.jpg" width="${10 * article.depth}"
								height="16">
							<img src="resources\reply.jpg" width="16" height="16">
						</c:if> <c:if test="${article.depth == 0}">
							<img src="resources\content.jpg" width="0" height="16">
						</c:if> <!-- 4.글내용 --> <a
						href="/food/notice_content.notice?article_num=${article.article_num}&pageNum=${pageNum}">
							${article.title}</a> <!-- a 태그를 통해 get방식으로 제목을 클릭했을 때의 동작을 선언한다 --> <c:if
							test="${article.hit >= 20}">
							<img src="resources\hot.gif" border="0" height="16">
						</c:if></td>
					<td align="center" width="100">${article.id}</td>
					<td align="center" width="150">${article.write_date}</td>
					<td align="center" width="50">${article.hit}</td>
				</tr>
			</c:forEach>
			<tr>

				<td colspan="5" align="center" height="40">${pageCode}</td>

			</tr>


		</table>
	</div>
	<br>
	<br>
	<br>

	<div id="b">
		<jsp:include page="/WEB-INF/views/main_aside.jsp" flush="true" />
	</div>

</body>

</html>