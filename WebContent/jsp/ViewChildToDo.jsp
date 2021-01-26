<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Child's ToDo</title>
	<%@ include file="../resources/NoCacheStore.jsp"%>
	<%@ include file="../resources/js/jslibraries.jsp"%>
	<%@ include file="../resources/css/csslibraries.jsp"%>
	<script type="text/javascript" src="../js/viewChildTodo.js"></script>
	<%@ include file="NavigationBar.jsp" %>
</head>
<body ng-app="childToDoApp" ng-controller="childToDoController">
	<% if(session.getAttribute("userId") == null){
		request.setAttribute("error", "Please login to see the content!");
		RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
		rd.forward(request, response);
	} else {
		String userId = request.getParameter("userId");
	%>
	
		<input type="hidden" name="userId" id="userId" value="<%= userId != null ? userId : -1%>">
		<div style="color: #f82929; font-weight: bold; font-size: 32px; margin: 195px 0px 0px 596px;" ng-bind="msg"></div>
		<div ng-if="recordFound">
			<table class="table table-hover table-sm"
					style="width: 50%; margin: 1px 0px 20px 311px; text-align: center;"
					border="2">
				<thead>
					<tr>
						<th>Title</th>
						<th>Body</th>
						<th>Due Date</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="x in childTodo">
						<td>{{x.title}}</td>
						<td>{{x.body}}</td>
						<td>{{x.dueDate}}</td>
					</tr>
				</tbody>
			</table>
		</div>
	<% } %>
</body>
</html>