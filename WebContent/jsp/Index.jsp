<%@ page import="app.util.TodoConstants"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
	<%@ include file="../resources/NoCacheStore.jsp"%>
	<%@ include file="../resources/js/jslibraries.jsp"%>
	<%@ include file="../resources/css/csslibraries.jsp"%>
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/validateUser.js"></script>
</head>
<body style="margin: 174px 0px 0px 168px; ">
	<% String error = (String)request.getAttribute("error");
		if(error != null) {
	%>
			<span style="margin: 0px 0px 0px 395px; font-size: 20px; color: red;"><%= error != null ? error : "" %></span>
	<% } %>
		<div class="container" ng-app="todoApp" ng-controller="validateUserController" style="margin: 28px 0px 0px 79px; padding-left: 200px;">
			<div class="col-md-6">
				<form name="validateUserForm">
					<div class="form-group row">
						<label for="username" class="col-md-4">Username</label>
						<input type="text" class="form-control col-md-8" name="username" ng-model="userName" required />
					</div>
					<div class="form-group row">
						<label for="password" class="col-md-4">Password</label>
						<input type="password" class="form-control col-md-8" name="password" ng-model="password" required />
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
			<div>{{error}}</div>
		</div>
</body>
</html>