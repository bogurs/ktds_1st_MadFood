<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
<form action="/food/notice_write.notice" method="post" enctype="multipart/form-data">
	<h1>글쓰기</h1><br><br>
	<input type="hidden" name="pageNum" value="${pageNum }">
	<table> <!-- 확인 버튼을 누르면 list로 돌아가면서 한 줄 추가(쿼리 실행) -->
		<tr>	 
		 <td>제목 | </td>
		 <td><input type="text" name="title" id="title" size="100"></td>			 
		</tr>
		
		<tr>
 			 <td> ID | </td>
 			 <td> ${id} </td>
 		</tr>
 		
		<tr>
		  <th> 내용 | </th>
		  <td>
		  	<textarea cols="87" rows="25" name="content" id="content"></textarea>
		  </td>
	    </tr> 	    
	    <tr>
	      <td>첨부 : </td>
	      <td><input type="file"  name="ibatisfname" ></td>
	    </tr>
	</table> 
		
	    
	   <input type="submit" value="글쓰기">
	   <input type="button" value="글쓰기취소" onclick="document.location.href='/food/notice_list.notice?pageNum=${pageNum}'">
		<c:if test="${write_error ==1 }">
				<h3><b><i><u><font color="red">글 제목과 내용을 모두 입력하세요!!</font></u></i></b></h3>
		</c:if>
	<br><br><br>
</form>
</div>

<div id="b">
<jsp:include page = "/WEB-INF/views/main_aside.jsp" flush="true"/>
</div>

</body>
</html>












