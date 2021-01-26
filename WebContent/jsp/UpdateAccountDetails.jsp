<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Account Details</title>
	<%@ include file="../resources/NoCacheStore.jsp"%>
	<%@ include file="../resources/js/jslibraries.jsp"%>
	<%@ include file="../resources/css/csslibraries.jsp"%>
	<script type="text/javascript" src="../js/updateAccountDetails.js" ></script>
	<%@ include file="NavigationBar.jsp" %>
</head>
<body ng-app="updateAccountApp" ng-controller="updateAccountController">
	<%
		if (session.getAttribute("userId") == null) {
			request.setAttribute("error", "Please Login to see the content!");
			RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
			rd.forward(request, response);
		} else {
			String todoId = request.getParameter("todoId");
	%>
		
		<div class="container" style="margin: 29px 0px 0px 78px;">
				<div class="col-md-6" style="margin: 0px 0px 0px 272px;">
					<form name="updateDetailsForm">
						<div class="form-group row">
							<label for="fullName" class="col-md-4">Full Name</label>
							<input type="text" class="form-control col-md-8" name="fullName" ng-model="obj.fullName" ng-disabled="isDisabled" required/>
						</div>
						<div class="form-group row">
							<label for="userName" class="col-md-4">Username</label>
							<input type="text" class="form-control col-md-8" name="userName" ng-model="obj.userName" ng-blur="checkUserName()" ng-disabled="isDisabled" ng-change="validateUserName=''" required/>
							<div ng-style="{'color': validateUserName == 'available' ? 'rgb(87 203 87)' : '#fc5151', 
								'font-size':'17px', 'font-weight' : 'bold', 'margin' : '-29px 0px 0px 566px'}">{{validateUserName}}
							</div>
						</div>
						<div class="form-group row">
							<label for="phone" class="col-md-4">Phone</label>
							<input type="text" class="form-control col-md-8" name="phone" ng-model="obj.phone" ng-blur="checkPhone()" ng-disabled="isDisabled" ng-change="validatePhone=''" required/>
							<div ng-style="{'color': validatePhone == 'available' ? 'rgb(87 203 87)' : '#fc5151', 
								'font-size':'17px', 'font-weight' : 'bold', 'margin' : '-29px 0px 0px 566px'}"> {{validatePhone}} 
							</div>
						</div>
						<div class="form-group row">
							<label for="email" class="col-md-4">Email</label>
							<input type="email" class="form-control col-md-8" name="email" ng-model="obj.email" ng-blur="checkEmail()" ng-disabled="isDisabled" ng-change="validateEmail=''" required/>
							<div ng-style="{'color': validateEmail == 'available' ? 'rgb(87 203 87)' : '#fc5151', 
								'font-size':'17px', 'font-weight' : 'bold', 'margin' : '-29px 0px 0px 566px'}"> {{validateEmail}} 
							</div>
						</div>
						<div class="form-group row">
							<label for="address" class="col-md-4">Address</label>
							<input type="text" class="form-control col-md-8" name="address" ng-model="obj.address" ng-disabled="isDisabled" required/>
						</div>
						<div class="form-group row">
							<div class="col-md-4">
								<label for="role">Role</label>
							</div>
							<div class="col-md-8">
								<div class="form-check-inline">
									<label class="form-check-label">
										<input type="radio" class="form-check-input" value="Child" name="role" ng-model="obj.role" disabled required>
										Child
									</label>
								</div>
								<div class="form-check-inline">
									<label class="form-check-label">
										<input type="radio" class="form-check-input" value="Parent" name="role" ng-model="obj.role" disabled required>
										Parent
									</label>
								</div>
							</div>
						</div>
						<div class="form-group row col-md-4">
							<button class="btn btn-warning" ng-disabled="!isDisabled" ng-click="edit()" style="margin: 14px 0px 0px 178px; 
									padding: 3px 25px 3px 26px;font-size: 19px; font-weight: bold;" >Edit</button>
						</div>
						<div class="form-group row col-md-4">
							<button class="btn btn-primary" ng-click="saveDetails()" style="margin: -51px 0px 15px 277px; 
									padding: 0px 24px 0px 21px;font-size: 19px; font-weight: bold;" 
									ng-disabled="updateDetailsForm.$invalid || validateUserName != 'available' || 
									validatePhone != 'available' || validateEmail != 'available'">Save
							</button>
						</div>
					</form>
				</div>
			</div>
		<div ng-bind="obj.msg" ng-style="{'color': isError == '1'? '#22b622': '#fe2424', 'font-size':'18px', 'font-weight' : 'bold', 'margin' : '21px 0px 0px 509px'}"></div>
	<%	} %>
</body>
</html>