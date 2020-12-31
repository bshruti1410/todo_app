<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create ToDo List</title>
<%@ include file="NoCacheStore.jsp"%>
<%@ include file="Resources.jsp"%>
<script type="text/javascript" src="../js/todo.js" ></script>
</head>
<body ng-app="todoApp" ng-controller="todoController">
	<%
		if (session.getAttribute("userId") == null) {
			request.setAttribute("error", "Please Login to see the content!");
			RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
			rd.forward(request, response);
		} else {
			String todoId = request.getParameter("todoId");
	%>
	<div class="container">
		<div class="col-md-6">
			<form>
				<input type="hidden" name="todoId" id="todoId" value="<%= todoId != null ? todoId : -1 %>"/>
				<div class="form-group row">
					<label for="title" class="col-md-4">Title</label>
					<input type="text" class="form-control col-md-8" name="title" ng-model="obj.title" />
				</div>
				<div class="form-group row">
					<label for="body" class="col-md-4">Body</label>
					<input type="text" class="form-control col-md-8" name="body" ng-model="obj.body" />
				</div>
				<div class="form-group row">
					<label for="dueDate" class="col-md-4">Due Date</label>
					<input type="date" class="form-control col-md-8" name="dueDate" ng-model="obj.dueDate" ng-init = "obj.dueDate | date : 'dd/MM/yyyy'"/>
				</div>
				<div class="form-group row col-md-4">
					<input type="submit" class="btn btn-success" value="Submit" ng-click="saveTodo()"/>
				</div>
			</form>
		</div>
	</div>

	<%
		}
			String error = (String) request.getAttribute("error");
			if (error != null)
			out.print(error);
	%>
</body>
</html>