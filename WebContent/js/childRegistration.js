var myApp = angular.module('childRegisterApp', []);

myApp.controller('childRegistrationController', function ($scope, $http) {

	$scope.obj = { userName: '', password: '', fullName: '', address: '', phone: '', email: '', aadhar: '', dob: ''};
	$scope.msg = '';
	$scope.validateUserName = '';
	$scope.validatePhone = '';
	$scope.validateEmail = '';
	
	$scope.checkUserName = function() {
		if($scope.obj.userName != '') {
			$http.get('/todo_app/ValidateUserParamController?param=user_name&user_name=' + $scope.obj.userName).then(function(response) {
				if(response.data=='true') {
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
				if(response.data=='true') {
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
				
				if(response.data=='true') {
					$scope.validateEmail = 'unavailable';
				} else {
					$scope.validateEmail = 'available';
				}
			});
		}
	}

	$scope.saveChildData = function() {
		$scope.obj.dob = $scope.obj.dob.toLocaleDateString();
		$http.post('/todo_app/ChildRegistrationController', JSON.stringify($scope.obj)).then(function(response) {
			$scope.obj.userName = '';
			$scope.obj.password = '';
			$scope.obj.fullName = '';
			$scope.obj.address = '';
			$scope.obj.phone = '';
			$scope.obj.email = '';
			$scope.obj.aadhar = '';
			$scope.obj.dob = '';
			if(response.data != -1) {
				$scope.msg = 'Registered successfully!';
			} else {
				$scope.msg = 'Error occurred';
			}
		});
	}
	
});