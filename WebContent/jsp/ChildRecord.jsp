<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>ChildInfo</title>
	<%@ include file="../resources/NoCacheStore.jsp"%>
	<%@ include file="../resources/js/jslibraries.jsp"%>
	<%@ include file="../resources/css/csslibraries.jsp"%>
	<script type="text/javascript" src="../js/viewChildRecords.js"></script>
	<%@ include file="NavigationBar.jsp" %>
</head>
<body>
	<% if(session.getAttribute("userId") == null){
		request.setAttribute("error", "Please login to see the content!");
		RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
		rd.forward(request, response);
	} else {
	%>
		<div ng-app="childApp" ng-controller="childController">
			<div ng-if="recordFound">
				<table class="table table-hover table-sm"
					style="width: 50%; margin: 52px 0px 20px 319px; text-align: center;"
					border="2">
					<thead>
						<tr>
							<th>FullName</th>
							<th>No. Of Todo</th>
							<th>Last Updated date</th>
							<th>Action</th>
							<th>Access</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="x in childDetails">
							<td><a href="ViewChildToDo.jsp?userId={{x.userId}}">{{x.fullName}}</a></td>
							<td>{{x.toDoCount}}</td>
							<td>{{x.latestDate}}</td>
							<td><button class="btn btn-info">feedback</button></td>
							<td>
								<button class="btn btn-success" ng-disabled="x.isDisabled == 0" ng-click="access(0, x.userId)">Grant</button>
								<button class="btn btn-danger" ng-disabled="x.isDisabled != 0" ng-click="access(1, x.userId)">Revoke</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div style="color: #f82929; font-size: 32px; font-weight: bold; margin: 195px 0px 0px 578px;">{{msg}}</div>
		</div>
	<%} %>
</body>
</html>