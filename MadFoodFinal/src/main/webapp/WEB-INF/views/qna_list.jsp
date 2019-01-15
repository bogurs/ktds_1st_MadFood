<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- jstl을 사용해주겠다는 의미(c라는 이름으로 사용하겠다) -->

<html>  
<head>
<title>질문과답변 게시판</title>
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
<input type="hidden" name="pageNum" id="pageNum" value="${pageNum }">
<b><h1>QnA 게시판</h1></b><br><br>
<b>글목록(전체 글:${count})</b> <!-- HTML설계는 디자이너가 하기 때문에 신경안써도 되지만, 읽을줄은 알아야 한다. -->
<table width="700" > <!-- EL문이 차례로 application>session>request순으로 검사한다 -->
  <tr>
    <td align="right" >
       <a href="/food/qna_writeForm.ktds?pageNum=${pageNum}">글쓰기</a>
    </td><!-- 글쓰기 클래스 실행을 위한 폼 --> <!-- 3.글쓰기 -->
  </tr>
</table>

<c:if test="${count == 0}"> <!-- jstl은 태그 내부에서 직접 연산이 가능하다 -->
<table width="700" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center">
      게시판에 저장된 글이 없습니다.
    </td>
  </tr>
</table>
</c:if>

<table border="1" width="700" align="center"> 
    <tr height="30" > 
      <th align="center"  width="50"  >번 호</th> 
      <th align="center"  width="250" >제   목</th> 
      <th align="center"  width="100" >작성자</th>
      <th align="center"  width="150" >작성일</th> 
      <th align="center"  width="50" >조 회</th>
    </tr>

	<!-- arraylist는 순서가 있고 hashmap은 순서가 없다 -->
   <c:forEach var="article" items="${articleList}"> <!-- jstl을 이용(for문 대신) -->
   <tr height="30"> <!-- items에는 배열값을 넣을수 있고, var은 article로 이름을 설정해 값을 참조할 수 있다 -->
    <td align="center"  width="50" >
	  <c:out value="${article.article_num}"/> <!-- article.(get이 생략되어있다) doget으로 간다 -->
	</td>
    <td  width="250" >
      <c:if test="${article.depth > 0}">
	  	<img src="resources\content.jpg" width="${10 * article.depth}"  height="16">
	    <img src="resources\reply.jpg" width="16" height="16">
	  </c:if>
	  <c:if test="${article.depth == 0}">
	    <img src="resources\content.jpg" width="0"  height="16">
	  </c:if>         <!-- 4.글내용 -->
      <a href="/food/qna_content.ktds?article_num=${article.article_num}&pageNum=${pageNum}">
          ${article.title}</a> <!-- a 태그를 통해 get방식으로 제목을 클릭했을 때의 동작을 선언한다 -->
          <c:if test="${article.hit >= 20}">
            <img src="resources\hot.gif" border="0" height="16">
		  </c:if>
	</td>
    <td align="center"  width="100">${article.id}</td>
    <td align="center"  width="150">${article.write_date}</td>
    <td align="center"  width="50">${article.hit}</td>
  </tr>
  </c:forEach>
  <tr>
	  
    <th colspan="5" align="center" height="40">	 
	  ${pageCode} <!-- page 링크들을 보여주는 것(ex 1~10) -->
	 </th>

  </tr>
</table>
</div>


<div id="b">
        <jsp:include page = "/WEB-INF/views/main_aside.jsp" flush="true"/>
</div>
        
</body>
</html>