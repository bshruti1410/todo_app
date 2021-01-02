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
			<div class="container" style="margin: 29px 0px 0px 78px;">
				<div class="col-md-6">
					<span ng-bind="msg"></span>
					<form name="todoForm">
						<input type="hidden" name="todoId" id="todoId" value="<%= todoId != null ? todoId : -1 %>"/>
						<div class="form-group row">
							<label for="title" class="col-md-4">Title</label>
							<input type="text" class="form-control col-md-8" name="title" ng-model="obj.title" required/>
						</div>
						<div class="form-group row">
							<label for="body" class="col-md-4">Body</label>
							<input type="text" class="form-control col-md-8" name="body" ng-model="obj.body" required/>
						</div>
						<div class="form-group row">
							<label for="dueDate" class="col-md-4">Due Date</label>
							<input type="date" class="form-control col-md-8" name="dueDate" ng-model="obj.dueDate" ng-init = "obj.dueDate | date : 'dd/MM/yyyy'" required/>
						</div>
						<div class="form-group row col-md-4" style="margin: 47px 0px 0px 173px;">
							<input type="button" class="btn btn-success" value="Submit" ng-click="saveTodo()" ng-disabled="todoForm.$invalid"/>
						</div>
					</form>
				</div>
			</div>

	<%
		}
	%>
</body>
</html>