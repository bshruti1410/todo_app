<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Child Registration</title>
	<%@ include file="../resources/NoCacheStore.jsp"%>
	<%@ include file="../resources/js/jslibraries.jsp"%>
	<%@ include file="../resources/css/csslibraries.jsp"%>
	<script type="text/javascript" src="../js/childRegistration.js"></script>
	<%@ include file="NavigationBar.jsp" %>
</head>
<body style="margin: 0px 0px 0px -13px" ng-app="childRegisterApp" ng-controller = "childRegistrationController">
	<% if(session.getAttribute("userId") == null){
		request.setAttribute("error", "Please login to see the content!");
		RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
		rd.forward(request, response);
	} else {
	%>
		<div class="container" style="margin: 44px 0px 0px 56px;">
		<div class="col-md-6" style="margin: 0px 0px 0px 320px;">
			<form name="childRegistrationForm">
				<div class="form-group row">
					<label for="username" class="col-md-4">Username</label>
					<input type="text" class="form-control col-md-8" name="userName" ng-model="obj.userName" ng-blur="checkUserName()" ng-change="validateUserName='' "required/>
					<div ng-style="{'color': validateUserName == 'available' ? 'rgb(87 203 87)' : '#fc5151', 'font-size':'17px', 
						'font-weight' : 'bold', 'margin' : '-29px 0px 0px 566px'}" >{{validateUserName}}
					</div>
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
					<input type="text" class="form-control col-md-8" name="phone" ng-model="obj.phone" ng-blur="checkPhone()" ng-change="validatePhone='' " required/>
					<div ng-style="{'color': validatePhone == 'available' ? 'rgb(87 203 87)' : '#fc5151', 'font-size':'17px', 
						'font-weight' : 'bold', 'margin' : '-29px 0px 0px 566px'}"> {{validatePhone}} 
					</div>
				</div>
				<div class="form-group row">
					<label for="email" class="col-md-4">Email</label>
					<input type="email" class="form-control col-md-8" name="email" ng-model="obj.email" ng-blur="checkEmail()" ng-change="validateEmail='' " required/>
					<div ng-style="{'color': validateEmail == 'available' ? 'rgb(87 203 87)' : '#fc5151', 'font-size':'17px', 
						'font-weight' : 'bold', 'margin' : '-29px 0px 0px 566px'}"> {{validateEmail}} 
					</div>
				</div>
				<div class="form-group row">
					<label for="aadhar" class="col-md-4">Aadhar No.(12 digits)</label>
					<input type="text" class="form-control col-md-8" name="aadhar" ng-model="obj.aadhar" required/>
				</div>
				<div class="form-group row">
					<label for="dob" class="col-md-4">Date-of-birth</label>
					<input type="date" class="form-control col-md-8" name="dob" ng-model="obj.dob" ng-init = "obj.dueDate | date : 'dd/MM/yyyy'" required/>
				</div>
				<div class="form-group row">
					<div class="col-md-4">
						<input type="submit" class="btn btn-success" value="Submit" 
						ng-disabled="childRegistrationForm.$invalid || validateUserName != 'available' ||
						 validatePhone != 'available' || validateEmail != 'available'" ng-click="saveChildData()"/>
					</div>
				</div>
			</form>
		</div>
	</div>
		<div ng-bind = "msg" style="margin: -15px 0px 0px 582px; font-weight: bold; color: #0c7d76; font-size: 18px;"></div>
		
	<%} %>
</body>
</html>