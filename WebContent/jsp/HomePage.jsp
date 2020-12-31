<%@ page import="app.util.TodoConstants"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Home page</title>
	<%@ include file="NoCacheStore.jsp" %>
	<%@ include file="Resources.jsp"%>
</head>
<body>
	<%
		if (session.getAttribute("userName") == null) {
			request.setAttribute("error", "Please Login to see the content!");
			RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
			rd.forward(request, response);
		} else {
			String name = (String) session.getAttribute("fullName");
	%>
			Welcome <%=name%>.<br/><br/>
			You can: <br/>
	<%
			String role = (String) session.getAttribute("role");
			if (TodoConstants.Parent.equals(role)) {
	%>	
				<div>
					<a class="btn btn-success" style="margin: 13px 0px 10px 43px;" href="/todo_app/jsp/ChildRecord.jsp">View Your Children</a>
				</div>
	<%		} %>
				<a class="btn btn-success" style="margin:8px 0px 9px 43px;padding-left: 36px;padding-right: 37px;" 
					href="/todo_app/jsp/CreateUpdateToDo.jsp">Create Todo</a>
				<br/>
				<a class="btn btn-success" style="margin: 6px 0px 0px 43px;padding-left: 39px;padding-right: 46px;"
					href="/todo_app/jsp/ViewToDo.jsp">View Todo</a>
				<br/>
				<form action="<%=request.getContextPath()%>/LogoutController" method="post">
					<input type="submit" class="btn btn-success" value = "Logout" 
						style="margin: 14px 0px 0px 43px; padding-left: 49px; padding-right: 60px;"/>
				</form>
			
	<%	} %>
</body>
</html>