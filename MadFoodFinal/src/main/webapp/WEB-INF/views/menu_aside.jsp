<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Insert title here</title>
<!-- 자바스크립트 동작을 위한 json파일 연결 해당 jar파일이 라이브러리에 있어야 한다. -->
<script src="scripts/jquery-2.1.0.min.js" type="text/javascript"></script>
<script src="scripts/json_comment.js" type="text/javascript"></script>
</head>
<body>
   <aside id="main_aside">
      <input id="first" type="radio" name="tab" checked="checked" /> <input
         id="second" type="radio" name="tab" />
      <section class="buttons">
         <label for="first">최근주문내역</label> <label for="second">장바구니</label>
      </section>
      <div class="history">
         <table>
            <tr>
               <td><input type="text" id="count" value="1" size="3" readonly></td>
               <td><input type="button" id="add" value="+" size="1" onclick=change(1)> 
                    <input type="button" id="sub" value="-" size="1" onclick=change(-1)></td>
            </tr>
         </table>
      </div>
      <div class="order"></div>
   </aside>
</body>
</html>
   