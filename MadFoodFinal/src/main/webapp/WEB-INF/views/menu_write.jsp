<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메뉴등록*관리자모드에서만 실행됩니다.*</title>
 <script src="scripts/jquery-2.1.0.min.js"  type="text/javascript"></script>
    <script src="scripts/menudetail.js" type="text/javascript"></script>
    <link href="css/default.css" rel="stylesheet" type="text/css" />
<script src="scripts/jquery.js" type="text/javascript"></script>
<script src="scripts/init.js" type="text/javascript"></script>
<script src="scripts/searchbranch.js" type="text/javascript"></script>
<style>
	#a{
		position: absolute;
		top: 80px;
		left: 500px;		
	}
</style>
</head>
<body>
	<div class="menu" style="position:absolute; top: 0px; left: 150px;">
		<jsp:include page = "/WEB-INF/views/main_header.jsp" flush="true"/> 
	</div>

	<div id="a" align="center">
	<h1>메뉴등록</h1>
		<form action="/food/menu_write.menu" method="post" enctype="multipart/form-data">
		<input type="hidden" name="pageNum" value="${pageNum }">
		<!-- form의 enctype이 multipart면 req.getPara가 먹지 않는다 -->
		<!-- 이것을 쓰기 위해서 req.getPart로 사용해서 읽어온다. -->
		<!-- 근데 req.getPara로도 읽을 수 있다>하지만, 한글을 인식하지 못한다 -->
			<table> <!-- 확인 버튼을 누르면 list로 돌아가면서 한 줄 추가(쿼리 실행) -->
				<tr>
					<th> 메뉴제목 | </th>
					<td> <input type="text" name="title" size="100"> </td>
				</tr>
				
				<tr>
					<th> 메뉴가격 | </th>
					<td> <input type="text" name="price" size="100"> </td>
				</tr>
				
				<tr>
					<th> 메뉴설명 | </th>
					<td> <textarea name="menu_content" rows="25" cols="87"></textarea> </td>
				</tr>
				
				<tr>
					<th> 메뉴사진첨부 | </th>
					<td> <input type="file" name="mpic_name"> </td>
				</tr>
					<tr>
					<th>메뉴종류 |</th>
					<td><select name="menu_kind" style="width:70;">
							<option value="0">SALAD</option>
							<option value="1">PILAF&RISOTTO</option>
							<option value="2">PASTA</option>
							<option value="3">BARBECUE</option>
							<option value="4">BEVERAGE</option>
							</select></td>
				</tr>
			</table>
			<input type="submit" value="확인">
			<input type="button" value="취소" onclick="document.location.href='/food/menu_list.menu'">
		</form>
	</div>
	
	<div id="b">
		<jsp:include page = "/WEB-INF/views/main_aside.jsp" flush="true"/> 
	</div>
</body>
</html>