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
   overflow :auto;
}  
</style>


</head>
<body>


						
															

	
<img src="http://postfiles15.naver.net/20131011_46/kja831007_1381489742690kUhCK_JPEG/SAM_5989.jpg?type=w1"></img>
<input type="button" id="menu" value="상세보기" onclick="javascript:overlay();"></input>
<div id="popup">    
<p>  
<img src="http://postfiles15.naver.net/20131011_46/kja831007_1381489742690kUhCK_JPEG/SAM_5989.jpg?type=w1" onclick="overlay()"style="cursor:pointer;"> 
</p> 
<p>
<div id="star"></div>
<p><input type="button" value="댓글보기" id="show_comment"><input type="button" onclick="overlay()"value="닫기"></p>  
				
		

<input type="text" id="dish_num">
<input type="text" id="comment_content"><input type="button" value="댓글쓰기" id="write_comment">

   <div id="comment"></div>
   
</div> 
<div id="overlay"></div> 

</body>
</html>