<%@page import="Model.Bean.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp"%>
<div class="content-left fl">
	<%@include file="inc/left_bar.jsp"%>
</div>
<div class="content-right fr">
	<%
		News itemNews = (News) request.getAttribute("itemNews");
		if (itemNews != null) {
	%>
	<h3><%=itemNews.getName()%></h3>
	<div class="main-content">
		<p><%=itemNews.getDetail()%></p>
	</div>
	<%
		} else {
	%>
	<h3>Không có thông tin!</h3>
	<%} %>
</div>
<%@include file="inc/footer.jsp"%>