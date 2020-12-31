<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>View ToDo List</title>
	<%@ include file="NoCacheStore.jsp" %>
	<%@ include file="Resources.jsp"%>
	<script type="text/javascript" src="../js/viewTodo.js" ></script>
</head>
<body>
	<div ng-app="viewTodoApp" ng-controller="viewTodoController">
		<span style="color: #ff0000; font-size: 26px; margin: 9px;">{{obj.msg}}</span>
		<br/>
		<div ng-if="obj.recordFound">
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
							<a class="btn btn-warning" href="CreateUpdateToDo.jsp?todoId={{x.todoId}}">Edit</a>
								<button class="btn btn-danger" ng-click="deleteTodo(x.todoId,$index)">Delete</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
</body>
</html>