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
<body ng-app = "todoApp" ng-controller="ajaxController" >
	<%
		if (session.getAttribute("userName") == null) {
			request.setAttribute("error", "Please Login to see the content!");
			RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
			rd.forward(request, response);
		} else {
			String name = (String)session.getAttribute("fullName");
	%>
	
			Welcome <%= name %>.<br/><br/>
			You can: <br/>
	<%
		 	String role = (String)session.getAttribute("role");
			if(TodoConstants.Parent.equals(role)) {
	%>
				<div>
					<input type="button" class="btn btn-success" value="View Your Children" ng-click="viewChildren()" 
						style="margin: 10px 0px 10px 25px;"><br/>
					<div ng-if="obj.recordFound == false">
						
					</div>
					<br/>
					<input type="button" class="btn btn-success" value="Create Todo" ng-click="createTodo()" 
						style="margin:-22px 0px 9px 24px;padding-left: 36px;padding-right: 37px;"/>
					<br/>
					<input type="button" class="btn btn-success" value="View Todo" ng-click="viewTodo()" 
						style="margin: 6px 0px 0px 24px;padding-left: 39px;padding-right: 46px;"/>
					<br/>
					<form action="<%= request.getContextPath() %>/LogoutController" method="post">
						<input type="submit" class="btn btn-success" value = "Logout" 
						style="margin: 14px 0px 0px 23px; padding-left: 49px; padding-right: 60px;
						 "/>
					</form>
				</div>
	<%
			} else {
	%>
				<input type="button" class="btn btn-success" value="Create Todo" ng-click="createTodo()"
					style="margin:-22px 0px 9px 24px;padding-left: 36px;padding-right: 37px;"/>
				<br/>
				<input type="button" class="btn btn-success" value="View Todo" ng-click="viewTodo()"
					style="margin: 6px 0px 0px 24px;padding-left: 39px;padding-right: 46px;"/>
				<br/>
				<form action="<%= request.getContextPath() %>/LogoutController" method="post">
					<input type="submit" class="btn btn-success" value = "Logout" 
						style="margin: 14px 0px 0px 23px; padding-left: 49px; padding-right: 60px;"/>
				</form>
	<% 
			}
		}
	%>
	{{msg}}
</body>
</html>