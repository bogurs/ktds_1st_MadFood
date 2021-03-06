<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 내용</title>
<!-- 자바스크립트 동작을 위한 json파일 연결 해당 jar파일이 라이브러리에 있어야 한다. -->
<script src="scripts/jquery-2.1.0.min.js" type="text/javascript"></script>
<script src="scripts/notice_comment.js" type="text/javascript"></script>
<style>
#a {
	position: absolute;
	top: 80px;
	left: 500px;
}
</style>
</head>
<body>

	<div class="menu">
		<jsp:include page="/WEB-INF/views/main_header.jsp" flush="true" />
	</div>

	<!-- 댓글을 달기 위한 폼을 띄워주는 명령어 호출 -->
	<div id="a" align="center">
		<h1>제목 _ ${article.title }</h1>
		<br>
		<br>
		<form action="/food/notice_replyForm.notice" method="post"
			name="contentForm">
			<!-- 답글달기를 눌렀을 때의 동작 -->
			<input type="hidden" name="pageNum" value="${pageNum }"> <input
				type="hidden" name="depth" value="${article.depth }"> <input
				type="hidden" name="pos" value="${article.pos }"> <input
				type="hidden" name="group_id" value="${article.group_id }">
			<input type="hidden" name="article_num" id="article_num"
				value="${article.article_num}">
			<!-- 이와 같이 EL문으로 해당 폼에 심게 되면 값을 넘겨주는 jsp에서 참조하여 쓸 수 있다 -->

			<table border="1" width="700" height="550">
				<tr>
					<td width="60">글쓴이 :</td>
					<td>${article.id }</td>
					<td width="60">조회수 :</td>
					<td>${article.hit }</td>
				</tr>
				<tr>
					<td>날짜 :</td>
					<td colspan="3">${article.write_date }</td>
				</tr>
				<tr>
					<td colspan="2">다운로드</td>
					<td colspan="2"><a
						href="/food/notice_download.notice?fname=${article.fname }">${article.fname }</a></td>
				</tr>
				<!-- 다운로드를 위해 선언해주는 download.ktds명령어 호출 -->
				<tr>
					<td colspan="4" align="center" valign="middle" height="350"><xmp>${article.content}</xmp></td>
				</tr>

				<tr>
					<c:if test="${id !=null}">
						<td colspan="4" align="right"><input type="submit"
							value="답글달기"> <c:if test="${id ==article.id}">
								<input type="button" value="수정하기"
									onclick="document.location.href='/food/notice_updateForm.notice?article_num=${article.article_num}&pageNum=${pageNum}'">
								<input type="button" value="삭제하기"
									onclick="document.location.href='/food/notice_delete.notice?article_num=${article.article_num}&pageNum=${pageNum}'">
							</c:if> <c:if test="${id !=article.id}">
								<input type="button" value="수정하기" disabled="disabled">
								<input type="button" value="삭제하기" disabled="disabled">
							</c:if> <input type="button" value="목록으로"
							onclick="document.location.href='/food/notice_list.notice?pageNum=${pageNum}'">
						</td>
					</c:if>

					<c:if test="${id ==null}">
						<td colspan="4" align="right"><input type="submit"
							value="답글달기" disabled="disabled"> <input type="button"
							value="수정하기" disabled="disabled"> <input type="button"
							value="삭제하기" disabled="disabled"> <input type="button"
							value="목록으로"
							onclick="document.location.href='/food/notice_list.notice?pageNum=${pageNum}'">
						</td>
					</c:if>
				</tr>
				<!-- 답글달기를 위한 폼 모양 선언과 댓글달기 json, java script지정 -->
				<tr>
					<td colspan="4"><input type="button" value="댓글보기"
						id="comm_show">(${commentNum })</td>
				</tr>
				<tr>
					<td colspan="4"><textarea id="comment_content" cols="45"></textarea>
						<c:if test="${id ==null}">
							<input type="button" value="댓글 쓰기" disabled="disabled">
						</c:if> <c:if test="${id !=null}">
							<input type="button" value="댓글 쓰기" id="comm_write">
						</c:if></td>
				</tr>

				<tr>
					<td colspan="4"><div id="show_comment"></div></td>
					<!-- 해당 댓글이 뿌려지는 곳 지정 -->
				</tr>
			</table>
		</form>
	</div>
	<br>
	<br>
	<br>

	<div id="b">
		<jsp:include page="/WEB-INF/views/main_aside.jsp" flush="true" />
	</div>
</body>
</html>