<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>event</title>
<script src="scripts/jquery.js" type="text/javascript"></script>
<script src="scripts/init.js" type="text/javascript"></script>
<script src="scripts/searchbranch.js" type="text/javascript"></script>
<style>
#a {
	position: absolute;
	top: 170px;
	left: 500px;
}
</style>
</head>
<body>

	<div class="menu">
		<jsp:include page="/WEB-INF/views/main_header.jsp" flush="true" />
	</div>


	<div id="a" align="center">

		<br>
		<h1>
			<b>이벤트</b>
		</h1>
		<table border="1" width="1000">
			<tr align="center">
				<td>구분</td>
				<td>내용</td>
				<td>기간</td>
				<td>상세정보</td>
			</tr>
			<tr align="center">
				<td><center>
						<img src="resources/event1.gif">
					</center> <br>
					<center>
						<img src="resources/event2.gif">
					</center> <br>
					<center>
						<img src="resources/event3.gif">
					</center></td>
				<td><br> <img src="resources/ktds.jpg"><br>KTDS
					직원 할인<br> <br></td>
				<td>2014-03-15~계속</td>
				<td>KTDS 전 직원 모든 메뉴 50% 할인</td>
			</tr>

		</table>
		<br> <br> <br>
	</div>
	<div id="song1"></div>

	<div id="b">
		<jsp:include page="/WEB-INF/views/main_aside.jsp" flush="true" />
	</div>

</body>
</html>