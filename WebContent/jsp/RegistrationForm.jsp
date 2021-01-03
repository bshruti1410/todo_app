<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
	<%@ include file="../resources/NoCacheStore.jsp"%>
	<%@ include file="../resources/js/jslibraries.jsp"%>
	<%@ include file="../resources/css/csslibraries.jsp"%>
	<script type="text/javascript" src="../js/checkParentUserName.js"></script>
</head>
<body>
	<%
		String error = (String) request.getAttribute("error");
		if (error != null)
			out.print(error);
	%>
	<div class="container" ng-app="todoApp" ng-controller="ajaxController" style="margin: 67px; margin-left: 209px; padding-left: 107px;">
		<div class="col-md-6">
			<form action="<%=request.getContextPath()%>/RegistrationController" method="post" name="registrationForm">
				<div class="form-group row">
					<label for="username" class="col-md-4">Username</label>
					<input type="text" class="form-control col-md-8" name="userName" ng-model="obj.userName" required/>
				</div>
				<div class="form-group row">
					<label for="password" class="col-md-4">Password</label>
					<input type="password" class="form-control col-md-8" name="password" ng-model="obj.password" required/>
				</div>
				<div class="form-group row">
					<label for="fullName" class="col-md-4">Full Name</label>
					<input type="text" class="form-control col-md-8" name="fullName" ng-model="obj.fullName" required/>
				</div>
				<div class="form-group row">
					<label for="address" class="col-md-4">Address</label>
					<input type="text" class="form-control col-md-8" name="address" ng-model="obj.address" required/>
				</div>
				<div class="form-group row">
					<label for="phone" class="col-md-4">Phone(10 digits)</label>
					<input type="text" class="form-control col-md-8" name="phone" ng-model="obj.phone" required/>
				</div>
				<div class="form-group row">
					<label for="email" class="col-md-4">Email</label>
					<input type="text" class="form-control col-md-8" name="email" ng-model="obj.email" required/>
				</div>
				<div class="form-group row">
					<label for="aadhar" class="col-md-4">Aadhar No.(12 digits)</label>
					<input type="text" class="form-control col-md-8" name="aadhar" ng-model="obj.aadahr" required/>
				</div>
				<div class="form-group row">
					<label for="dob" class="col-md-4">Date-of-birth</label>
					<input type="date" class="form-control col-md-8" name="dob" ng-model="obj.dob" required/>
				</div>
				<div class="form-group row">
					<div class="col-md-4">
						<label for="role">Role</label>
					</div>
					<div class="col-md-8">
						<div class="form-check-inline">
							<label class="form-check-label">
								<input type="radio" class="form-check-input" value="Child" name="role" ng-model="obj.role" required>
								Child
							</label>
						</div>
						<div class="form-check-inline">
							<label class="form-check-label">
								<input type="radio" class="form-check-input" value="Parent" name="role" ng-model="obj.role" required>
								Parent
							</label>
						</div>
					</div>
				</div>
				<div class="form-group row" ng-if="obj.role == 'Child'">
					<label for="pUsername" class="col-md-4">Parent username</label>
					<input type="text" class="form-control col-md-5" name="pUserName" ng-model="obj.pUserName" ng-blur="checkUserName()" required/>
					<span style="color: #5cb85c; white-space: pre-wrap; font-weight: bold;"> {{pUserAvailable}} </span>
				</div>
				<div class="form-group row">
					<div class="col-md-4">
						<input type="submit" class="btn btn-success" value="Submit" ng-disabled="registrationForm.$invalid"/>
					</div>
					<div class="col-md-8 ">
						Already Registered? <a href="<%=request.getContextPath()%>/jsp/Index.jsp">Please login here</a>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>