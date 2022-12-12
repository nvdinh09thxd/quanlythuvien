<%@page import="Model.Bean.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp"%>
<div class="content-left fl">
	<%@include file="inc/left_bar.jsp"%>
</div>
<div class="content-right fr">
	<%
		int idCat = Integer.parseInt(request.getParameter("cid"));
		Category itemCat = CatDao.getItem(idCat);
		String catName = "";
		if(itemCat != null){
			catName = itemCat.getName();
		}
	%>
	<h3><%=catName%></h3>
	<div class="main-content items-new">
		<%
			@SuppressWarnings("unchecked")
			ArrayList<News> listNewsByIdCat = (ArrayList<News>) request.getAttribute("listNewsByIdCat");
			if (listNewsByIdCat != null && listNewsByIdCat.size() > 0) {
		%>
		<ul>
			<%
				for (News objNews : listNewsByIdCat) {
			%>
			<li>
				<h2>
					<a href="<%=request.getContextPath() %>/detail?id=<%=objNews.getId()%>" title=""><%=objNews.getName()%></a>
				</h2>
				<div class="item">
					<p><%=objNews.getDescription()%></p>
					<div class="clr"></div>
				</div>
			</li>
			<%
				}
			%>
		</ul>
		<%
			} else {
		%>
		<p>Không có tin nào!</p>
		<%
			}
		%>
	</div>
</div>
<%@include file="inc/footer.jsp"%>