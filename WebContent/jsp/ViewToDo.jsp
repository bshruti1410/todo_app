<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>View ToDo List</title>
	<%@ include file="../resources/NoCacheStore.jsp"%>
	<%@ include file="../resources/js/jslibraries.jsp"%>
	<%@ include file="../resources/css/csslibraries.jsp"%>
	<script type="text/javascript" src="../js/viewTodo.js" ></script>
	<%@ include file="NavigationBar.jsp" %>
</head>
<body>

	<% if (session.getAttribute("userId") == null) {
			request.setAttribute("error", "Please login to see the content!");
			RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
			rd.forward(request, response);
		} else {
	%>
			<div ng-app="viewTodoApp" ng-controller="viewTodoController">
				<div style="color: #f82929; font-size: 32px; font-weight: bold; margin: 195px 0px 0px 578px;">{{msg}}</div>
				<br/>
				<div ng-if="recordFound">
					<table class="table table-hover table-sm" style="width: 50%; margin: -80px 0px 20px 325px; text-align: center;" border="2">
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
	<%	} %>
</body>
</html>