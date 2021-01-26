<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>logout</title>
	<%@ include file="../resources/NoCacheStore.jsp"%>
	<%@ include file="../resources/js/jslibraries.jsp"%>
	<%@ include file="../resources/css/csslibraries.jsp"%>
	<script type="text/javascript" src="../js/logout.js"></script>
</head>
<body ng-app="logoutApp" ng-controller="logoutController" style="margin: 113px 0px 0px 466px; font-size: 22px; color: #ff03bf; font-weight: bold;">
	<% if (session.getAttribute("userId") == null) {
			request.setAttribute("error", "Please login to see the content!");
			RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
			rd.forward(request, response);
		} else {
	%>
			<div ng-if="logout">
				<span ng-bind="msg"></span>
				Please login<a href="/todo_app/jsp/Index.jsp" style="color: #e305ab; font-style: italic; font-weight: bold;"> here</a>.
			</div>
	<%} %>
</body>
</html>