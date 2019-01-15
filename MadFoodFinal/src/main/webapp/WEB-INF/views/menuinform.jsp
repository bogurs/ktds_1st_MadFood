<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script src="scripts/jquery-2.1.0.min.js"  type="text/javascript"></script>
    <script src="scripts/join.js" type="text/javascript"></script>
    <script src="scripts/searchbranch.js" type="text/javascript"></script>
    <script src="scripts/menucomment.js" type="text/javascript"></script>
<style>
body { height:100%;margin:0; padding:0;} 

#overlay { visibility: hidden;position: absolute;left: 0px;top: 0px;width:100%;  
   height:100%;text-align:center;z-index: 999;  
   opacity: 0.5;filter:alpha(opacity=50);
background-color:#000;  } 

#popup {  position:fixed; visibility : hidden; 
   width:550px; height : 550px; 
   background-color: #fff;  
   border:1px solid #000;  
   padding:15px;  
   text-align:center;  
   z-index : 9999;  
   overflow:hidden; 
   top : 50%; 
   left : 50%; 
}  
</style>

</head>
<body>
<div id="popup">
${article.title}    
<p>  
<img src="download.ktds?fname=${article.pic_name}" onclick="overlay()"style="cursor:pointer;" />
</p> 
<p>
<p><input type="button" value="댓글보기" id="show_comment"><input type="button" onclick="overlay()"value="닫기"></p>  
<input type="text" id="comm_content"><input type="button" value="댓글쓰기" id="write_comment">
</div> 
<div id="overlay"></div> 
<div id="comment"></div>

</body>
</html>