<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Child's ToDo</title>
<%@ include file="NoCacheStore.jsp"%>
<%@ include file="Resources.jsp"%>
<script type="text/javascript" src="../js/viewChildTodo.js"></script>
</head>
<body ng-app="childToDoApp" ng-controller="childToDoController">
	<% String userId = request.getParameter("userId"); %>
	
	<input type="hidden" name="userId" id="userId" value="<%= userId != null ? userId : -1%>">
	<span style="color: #ff0000; font-size: 26px; margin: 9px;" ng-bind="obj.msg"></span>
	<div ng-if="obj.recordFound">
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
	
</body>
</html>