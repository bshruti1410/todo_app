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
	<script type="text/javascript" src="../js/viewChildRecords.js" ></script>
</head>
<body>
	<%
		if (session.getAttribute("userName") == null) {
			request.setAttribute("error", "Please Login to see the content!");
			RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
			rd.forward(request, response);
		} else {
			String name = (String)session.getAttribute("fullName");
	%>
	
			Welcome <%= name %>.<br/>
			You can: <br/>
	<%
		 	String role = (String)session.getAttribute("role");
			if(TodoConstants.Parent.equals(role)) {
	%>
				<div ng-app = "todoApp" ng-controller="ajaxController" >
					<button ng-click="viewRecord()">View Your Children</button><br/>
					<div ng-if="obj.recordFound">
						<table id="table" style="width: 50%;" border= "2">
							<tr>
								<th>FullName</th>
								<th>No. Of ToDoList</th>
							</tr>
							<tr ng-repeat="x in childDetails" >
								<td>{{x.fullName}}</td>
								<td>{{x.toDoCount}}</td>
							</tr>
						</table>
					</div>
					<br/>
					<form action="CreateToDo.jsp" method="get">
						<input type="submit" value="Create ToDo List"/>
					</form>
					<br/>
					<form action="<%= request.getContextPath() %>/ViewToDoController" method="post">
						<input type="submit" value="View ToDo List"/>
					</form>
					<br/>
					<form action="<%= request.getContextPath() %>/LogoutController" method="post">
						<input type="submit" value = "Logout" />
					</form>
				</div>
	<%
			} else {
	%>
				<form action="CreateToDo.jsp" method="get">
					<input type="submit" value="Create ToDo List"/>
				</form>
				<br/>
				<form action="<%= request.getContextPath() %>/ViewToDoController" method="post">
					<input type="submit" value="View ToDo List"/>
				</form>
				<br/>
				<form action="<%= request.getContextPath() %>/LogoutController" method="post">
					<input type="submit" value = "Logout" />
				</form>
	<% 
			}
		}
	%>
</body>
</html>