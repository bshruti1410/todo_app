<%@ page import="app.util.TodoConstants"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Home page</title>
	<%@ include file="../resources/NoCacheStore.jsp"%>
	<%@ include file="../resources/js/jslibraries.jsp"%>
	<%@ include file="../resources/css/csslibraries.jsp"%>
	<%@ include file="NavigationBar.jsp" %>
</head>
<body>
	<%
		if (session.getAttribute("userName") == null) {
			request.setAttribute("error", "Please Login to see the content!");
			RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
			rd.forward(request, response);
		} else {
			String fullName = (String) session.getAttribute("fullName");
	%>
			<div style="font-size: 24px; font-weight: bold; font-style: italic; margin: 150px 0px 0px 582px; color: #d122a5;">
				Welcome <%=fullName%>
			</div>
	<%
		}
	%>
</body>
</html>