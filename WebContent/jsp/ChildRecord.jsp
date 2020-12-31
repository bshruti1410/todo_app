<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ChildInfo</title>
<%@ include file="NoCacheStore.jsp" %>
<%@ include file="Resources.jsp"%>
<script type="text/javascript" src="../js/viewChildRecords.js" ></script>
</head>
<body>
	<div ng-app="childApp" ng-controller="childController">
		<span style="color: #ff0000; font-size: 26px; margin: 9px;">{{obj.msg}}</span>
		<br/>
		<div ng-if="obj.recordFound">
			<table class="table table-hover table-sm" style="width: 50%; margin: 1px 0px 20px 311px; text-align: center;" border="2">
				<thead>
					<tr>
						<th>FullName</th>
						<th>No. Of ToDoList</th>
						<th>Last Updated date</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="x in childDetails">
						<td>{{x.fullName}}</td>
						<td>{{x.toDoCount}}</td>
						<td>{{x.latestDate}}</td>
						<td> <button class="btn btn-info">feedback</button> </td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>