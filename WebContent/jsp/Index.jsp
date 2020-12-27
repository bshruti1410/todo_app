<%@ page import="app.util.TodoConstants"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<%@ include file="NoCacheStore.jsp"%>
<%@ include file="Resources.jsp"%>
<script type="text/javascript" src="../js/validateUser.js"></script>
</head>
<body >
	<div class="container " ng-app="todoApp" ng-controller="validateUserController">
		<div class="col-md-6">
			<form name="validateUserForm">
				<div class="form-group row">
					<label for="username" class="col-md-4">Username</label>
					<input type="text" class="form-control col-md-8" name="username" ng-model="obj.userName" required />
				</div>
				<div class="form-group row">
					<label for="password" class="col-md-4">Password</label>
					<input type="password" class="form-control col-md-8" name="password" ng-model="obj.password" required />
				</div>
				<div class="form-group row">
					<div class="col-md-4 text-left">
						<input type="button" class="btn btn-success" value="Submit" ng-disabled="validateUserForm.$invalid" ng-click="validateUser()" />
					</div>
					<div class="col-md-8 text-right">
						Not Registered Yet? <a href="<%=request.getContextPath()%>/jsp/RegistrationForm.jsp">register here</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>