var myApp = angular.module('registerApp', []);

myApp.controller('registrationController', function ($scope, $http) {

	$scope.obj = { userName: '', password: '', fullName: '', address: '', phone: '', email: '', aadhar: '', dob: '', role: '', pUserName: '' };
	$scope.pUserAvailable = '';
	$scope.validateUserName = '';
	$scope.validatePhone = '';
	$scope.validateEmail = '';
	$scope.msg = '';
	$scope.checkParentUserName = function () {
		if ($scope.obj.pUserName != '') {
			$http.get('/todo_app/CheckUserNameController?pUserName=' + $scope.obj.pUserName).then(function (response) {
				var res = response.data;
				if (res == 1) {
					$scope.pUserAvailable = 'available';
				}else {
					$scope.pUserAvailable = 'unvailable';
				}
			});
		}
	}
	
	$scope.checkUserName = function() {
		if($scope.obj.userName != '') {
			$http.get('/todo_app/ValidateUserParamController?param=user_name&user_name=' + $scope.obj.userName).then(function(response) {
				if(response.data == 'true') {
					$scope.validateUserName = 'unavailable';
				} else {
					$scope.validateUserName = 'available';
				}
			});
		}
	}

	$scope.checkPhone = function() {
		if($scope.obj.phone != '') {
			$http.get('/todo_app/ValidateUserParamController?param=phone&phone=' + $scope.obj.phone).then(function(response) {
				if(response.data == 'true') {
					$scope.validatePhone = 'unavailable';
				} else {
					$scope.validatePhone = 'available';
				}
			});
		}
	}

	$scope.checkEmail = function() {
		if($scope.obj.email != '') {
			$http.get('/todo_app/ValidateUserParamController?param=email&email=' + $scope.obj.email).then(function(response) {
				if(response.data == 'true') {
					$scope.validateEmail = 'unavailable';
				} else {
					$scope.validateEmail = 'available';
				}
			});
		}
	}



	$scope.saveUserData = function() {
		$scope.obj.dob = $scope.obj.dob.toLocaleDateString();
		$http.post('/todo_app/RegistrationController', JSON.stringify($scope.obj)).then(function(response) {
			$scope.obj.userName = '';
			$scope.obj.password = '';
			$scope.obj.fullName = '';
			$scope.obj.address = '';
			$scope.obj.phone = '';
			$scope.obj.email = '';
			$scope.obj.aadhar = '';
			$scope.obj.dob = '';
			$scope.obj.role = '';
			if(response.data != -1) {
				$scope.msg = "Registered successfully!";
			} else {
				$scope.msg = 'Error Occurred';
			}
		});
	}
	
});