<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- jstl을 사용해주겠다는 의미(c라는 이름으로 사용하겠다) -->

<link href="css/default.css" rel="stylesheet" type="text/css" />
<style>
</style>


<h2><a href="/food/main.ktds">Main</a></h2>
<br>
<br>
<br>
<c:if test="${id == null}">
	<a href="#"
		onClick="javascript:window.open('go_login.ktds','cnjOpen','width=300,height=300, left=400, top=100')">Login</a>
</c:if>
<c:if test="${id != null}">
	<a href="/food/logout.ktds">Logout</a>
</c:if>
<a href="#"
	onClick="javascript:window.open('joinView.etc','cnjOpen','width=730,height=760, left=400, top=100')">Join</a>
<a href="/food/notice_list.notice">Notice</a>
<a href="/food/menu_list.menu">Menu</a>
<a href="/food/order_list.order">Order</a>
<a href="/food/event.etc">Event</a>
<a href="/food/card.etc">Membership</a>
<a href="/food/qna_list.ktds">Q&amp;A</a>
<a href="/food/searchBranch.etc">Location</a>