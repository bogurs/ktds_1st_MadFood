<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>주문메뉴</title>
<!-- 자바스크립트 동작을 위한 json파일 연결 해당 jar파일이 라이브러리에 있어야 한다. -->
<script src="scripts/jquery-2.1.0.min.js" type="text/javascript"></script>
<script src="scripts/menudetail.js" type="text/javascript"></script>
<script src="scripts/menucomment.js" type="text/javascript"></script>
<link href="css/default.css" rel="stylesheet" type="text/css" />
<script src="scripts/jquery.js" type="text/javascript"></script>
<script src="scripts/init.js" type="text/javascript"></script>
<script src="scripts/searchbranch.js" type="text/javascript"></script>
<script>


function addcart(title, price,dish_num) {
	var a=1;
	$(".hidden").each(function(){
			if($(this).val()==dish_num){		
				a=0;
				alert("이미 존재하는 메뉴");}else{}
});
	if(a==1){
	var html="<tr id='"+dish_num+"'>";
         html+='<td>'+title+'</td>';  
         html+="<td ><input type='hidden' class='hidden' name='dish_num' value='"+dish_num+"'><td>";
        html+="<td><input type='text' id='totalprice' value='"+price+"'size='3' readonly><td>";
        html+= "<td><input type='text' id='count' name='count' value='1' size='1' readonly></td>";
        html+="<td><input type='button' id='add' value='+' size='1' onclick='change(1,"+price+','+dish_num+")'></td>";
        html+="<td><input type='button' id='sub' value='-' size='1' onclick='change(-1,"+price+','+dish_num+")'></td>";
        html+="<td><input type='button' value='취소' size='4' onclick='cancle("+price+','+dish_num+")'></td>";
        html+="</tr>";
         
   $("#history").append(html);   
   var sum =parseInt($("#sum").val())+parseInt(price);
   $("#sum").val(sum);
		}else{
			
		}
}
function cancle(price,dish_num){
   var html='#'+dish_num+'';
   alert(html);
  
   alert(price);
   var sum =parseInt($("#sum").val())-parseInt($(html).find('#totalprice').val());
   $(html).remove();
   $("#sum").val(sum);
}
function change(num,price,dish_num){
    var html='#'+dish_num+'';
    var totalprice=$(html).find('#totalprice').val();
    var count=$(html).find('#count').val();
    var cnt =parseInt(count)+num;
    if(cnt<1) return null;
    $(html).find('#count').val(cnt);
    $(html).find('#totalprice').val(cnt*price);
    var sum =parseInt($("#sum").val())+num*parseInt(price);
    $("#sum").val(sum);
  }
</script>
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
   background-image: url('resources/aside.jpg');
}
</style>
</head>
<body>



   <div class="menu">
      <jsp:include page="/WEB-INF/views/main_header.jsp" flush="true" />
   </div>

   <div id="a">
      <c:if test="${id == 'ktds'}">
         <input type="button" value="메뉴등록"
            onclick="document.location.href='/food/menu1.menu'">
      </c:if>
      <c:forEach var="article" items="${articleList}">
         <table>

            <tr>
               <td>제목 : ${article.title}</td>
            </tr>

            <c:if test="${id == 'ktds' }">
               <tr>
                  <td><input type="button" value="메뉴삭제"
                     onclick="document.location.href='/food/deleteMenu.menu?dish_num=${article.dish_num}'"></td>
               </tr>
            </c:if>
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
               <td><input type="button" id="basket" value="담기"
                  onclick="addcart('${article.title}' ,' ${article.price}','${article.dish_num}')" /></td>
            </tr>

            <tr>
               <br>
               <br>
               <br>
               <br>
            </tr>
         </table>
      </c:forEach>
   </div>
   <div id="b">
      <input id="first" type="radio" name="tab" checked="checked" /> 
       <label for="second">장바구니</label>
      <form action="/food/menu_order.order" method="post">
<!--       	 <table border="1"> -->
      	 
          	<div id="history"></div>
          	<c:if test="${orderOK == 1 }">
	      		주문이 완료되었습니다.<br>
	      		Order 메뉴를 확인해주세요.
	       </c:if>
         </table>
         <br>
         <br> 합계 <input type="text" id="sum" value="0" size="5" readonly>
         <br>
         <br>
         <br> <input type="submit" value="주문하기">
      </form>
      
      
   </div>

</body>
</html>

