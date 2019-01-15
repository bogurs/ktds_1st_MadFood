<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- jstl을 사용해주겠다는 의미(c라는 이름으로 사용하겠다) -->
     
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>CSS3 blur menu</title>
<link href="css/default.css" rel="stylesheet" type="text/css" />
<script src="scripts/jquery.js" type="text/javascript"></script>
<script src="scripts/init.js" type="text/javascript"></script>
<script src="scripts/searchbranch.js" type="text/javascript"></script>

</head>
<body>
<form id=loginok>

<div class="menu">
	<jsp:include page = "/WEB-INF/views/main_header.jsp" flush="true"/> 
</div>
	
 
</form>
<div id="a">
 <jsp:include page = "/WEB-INF/views/main_content.jsp" flush="true"/> 
</div>
<div id="b">
 <jsp:include page = "/WEB-INF/views/main_aside.jsp" flush="true"/> 
</div>

</body>

 
</html>