<%@page import="Model.DAO.CatDao"%>
<%@page import="Model.Bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>Danh mục tin</h3>
<%
	ArrayList<Category> listCats = CatDao.getItems();
	if (listCats.size() > 0) {
%>
<ul>
	<%
		for (Category objCat : listCats) {
	%>
	<li><a
		href="<%=request.getContextPath() %>/cat?cid=<%=objCat.getId()%>"
		title=""><%=objCat.getName()%></a></li>
	<%
		}
	%>
</ul>
<%
	}
%>