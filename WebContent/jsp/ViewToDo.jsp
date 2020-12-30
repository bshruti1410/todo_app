<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>View ToDo List</title>
	<%@ include file="NoCacheStore.jsp" %>
	<%@ include file="Resources.jsp"%>
	<script type="text/javascript" src="../js/viewChildRecords.js" ></script>
</head>
<body>
	<div ng-app="todoApp" ng-controller="ajaxController">
	
		<br/>
		<div ng-if="obj.recordFound == true">
			<table class="table table-hover table-sm" style="width: 50%; margin: 1px 0px 20px 311px; text-align: center;" border="2">
				<thead>
					<tr>
						<th>Title</th>
						<th>Body</th>
						<th>Due date</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="x in todoList">
						<td>{{x.title}}</td>
						<td>{{x.body}}</td>
						<td>{{x.dueDate}}</td>
						<td> 
							<a class="btn btn-warning" href="CreateToDo.jsp?todoId={{x.todoId}}">Edit</a>
								<button class="btn btn-danger" ng-click="deleteTodo(x.todoId)">Delete</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
</body>
</html>