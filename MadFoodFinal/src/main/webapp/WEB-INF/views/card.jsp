<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
<br>

<h1><b>멤버쉽</b></h1>
<table border="1" width="1000" >
   <tr align="center">
<!--       <td><center>종류</center></td><td><center>할인정보</center></td><td><center>차감 포인트</center></td><td><center>이용안내</center></td><td><center>상세정보</center></td> -->
      <td>종류</td><td>할인정보</td><td>차감 포인트</td><td>이용안내</td><td>상세정보</td>
   </tr>
   <tr align="center">
      <td><br><img src="resources/skt.jpg"><br>SK T멤버십<br><br></td>
      <td>전체금액<br>20% 할인</td>
      <td>SKT멤버십 할인한도<br>10%차감</td>
      <td><img src="resources\1.gif"> <img src="resources\2.gif"><br><img src="resources\3.gif"> <img src="resources\4.gif"><br><img src="resources\5.gif"> <img src="resources\6.gif"></td>
      <td>잘생겼다 sk텔레콤</td>
   </tr>
   <tr align="center">
      <td><br><img src="resources/kt.jpg"><br>KT 올레클럽<br><br></td>
      <td>전체금액<br>50% 할인</td>
      <td>KT멤버십 할인한도<br>0.5%차감</td>
      <td><img src="resources\1.gif"> <img src="resources\2.gif"><br><img src="resources\3.gif"> <img src="resources\4.gif"><br><img src="resources\5.gif"> <img src="resources\6.gif"></td>
      <td>아니라오 아니라오 다되는건아니라오<br>송소희 쨩</td>
   </tr>
   <tr align="center">
      <td><br><img src="resources/lg.jpg"><br>LG U+멤버십<br><br></td>
      <td>전체금액<br>5% 할인</td>
      <td>SKT멤버십 할인한도<br>15%차감</td>
      <td><img src="resources\1.gif"> <img src="resources\2.gif"><br><img src="resources\3.gif"> <img src="resources\4.gif"><br><img src="resources\5.gif"> <img src="resources\6.gif"></td>
      <td>왜씀?</td>
   </tr>
   
</table>
<br><br>
<br> 
 
</div>

<div id="b">
        <jsp:include page = "/WEB-INF/views/main_aside.jsp" flush="true"/>
</div>

</body>
</html>