<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>주문정보</title>
<!-- 자바스크립트 동작을 위한 json파일 연결 해당 jar파일이 라이브러리에 있어야 한다. -->
<script src="scripts/jquery-2.1.0.min.js" type="text/javascript"></script>
<script src="scripts/menudetail.js" type="text/javascript"></script>
<script src="scripts/menucomment.js" type="text/javascript"></script>
<link href="css/default.css" rel="stylesheet" type="text/css" />
<script src="scripts/jquery.js" type="text/javascript"></script>
<script src="scripts/init.js" type="text/javascript"></script>
<script src="scripts/searchbranch.js" type="text/javascript"></script>
<style>
#a {
	margin-top: 100px;
	margin-left: 200px;
	color: white;
}

#b {
	left: 1550px;
	width: 350px;
	height: 1100px;
	color: white;
	background-image: url('resources/aside.jpg');
}
</style>
</head>
<body>

	<div class="menu">
		<jsp:include page="/WEB-INF/views/main_header.jsp" flush="true" />
	</div>

	<div id="a">
	
		<table align="center">
			<tr>
				<td>
					<h1>주문하신 내역입니다. ~주문해주셔서 감사합니다~</h1>
				</td>
			</tr>
			<tr align="right">
				<td>
					<h4>주문자 id: ${id }</h4>
				</td>
			</tr>
		</table>
		<c:forEach var="article" items="${articleList}">
			<table>

				<tr>
					<td><h3>메뉴 : ${article.title}</h3></td>
				</tr>

				<tr>
					<td><img src="download.menu?fname=${article.pic_name}"
						onclick="window.open('getInform.menu?dish_num='+${article.dish_num},'_blank','width=700, height=800, toolbar=no, menubar=no,titlebar=no, location=no');"
						style="cursor: pointer;"></td>
				<tr>
					<td>${article.menu_content}</td>
				</tr>
				<tr>
					<td>가격 : ${article.price}원</td>
				</tr>

				<tr>
					<br>
					<br>
				</tr>
			</table>
		</c:forEach>

	</div>
	<div id="b">
		<table align="center" border="1" bordercolor="black" width="335">
			<tr align="center">
				<td colspan="3">
					<h3>주문명세서</h3>
				</td>
			</tr>
			<c:forEach var="article" items="${articleList }" begin="1" end="1">
			<tr align="right">				
					<td colspan="3">주문번호 : <c:out value="${article.order_num }"/></td>				
			</tr>
			<tr align="right">
				<td colspan="3">주문접수시간 : <c:out value="${article.order_date }"/></td>				
			</tr>
			</c:forEach>
			<c:forEach var="article" items="${articleList}">
				<tr>
					<td><h4>메뉴 : ${article.title}</h4></td>
					<td>가격 : ${article.price }원</td>
					<td>개수 : ${article.count }</td>
				</tr>
			</c:forEach>
			<tr>
				<br><br><br>
			</tr>
			<tr align="right">
				<td colspan="3">총 가격 : ${sum }원</td>
			</tr>
		</table>
	</div>

</body>
</html>

