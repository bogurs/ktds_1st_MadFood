<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>card</title>
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

<div class="menu">
   <jsp:include page = "/WEB-INF/views/main_header.jsp" flush="true"/>    
</div>

<div id="a" align="center">
 
<select name="branch" id="branch" style="width:70;"onchange="change()">
    <option id="0ho" value="0" > 지점찾기 </option>
   <option id="1ho" value="1" > 빅쉪 1호점(방배) </option>
   <option id="2ho" value="2"> 빅쉪 2호점(수원) </option>
</select>
<div id="c"><img src="http://www.outback.co.kr/img/about/img_outbackstory2.png" width="700" height="500"/> </div>
</div>


<div id="b">
        <jsp:include page = "/WEB-INF/views/main_aside.jsp" flush="true"/>
</div>

</body>
</html>