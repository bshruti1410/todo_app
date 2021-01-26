var myApp = angular.module('updateAccountApp', []);

myApp.controller('updateAccountController', function($scope, $http) {

	$scope.obj = {fullName: '', userName: '', phone: '', email: '', address: '', role: '', msg : ''};
	$scope.isError = '';
	$scope.validateUserName = '';
	$scope.validateEmail = '';
	$scope.validatePhone = '';
	$scope.isDisabled = true;
	angular.element(document).ready(function() {
		$http.get('/todo_app/ViewAccountDetailsController').then(function(response) {
			var res = response.data;
			if(res) {
				$scope.obj.fullName = res.fullName;
				$scope.obj.userName = res.userName;
				$scope.obj.phone = res.phone;
				$scope.obj.email = res.email;
				$scope.obj.address = res.address;
				$scope.obj.role = res.role;
			}
		});
	});

	$scope.edit = function() {
		$scope.isDisabled = false;
	}

	$scope.checkUserName = function() {
		if($scope.obj.userName != '') {
			$http.get('/todo_app/ValidateUpdateUserParamController?param=user_name&user_name=' + $scope.obj.userName).then(function(response) {
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
			$http.get('/todo_app/ValidateUpdateUserParamController?param=phone&phone=' + $scope.obj.phone).then(function(response) {
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
			$http.get('/todo_app/ValidateUpdateUserParamController?param=email&email=' + $scope.obj.email).then(function(response) {
				
				if(response.data=='true') {
					$scope.validateEmail = 'unavailable';
				} else {
					$scope.validateEmail = 'available';
				}
			});
		}
	}

	$scope.saveDetails = function() {
		console.log(JSON.stringify($scope.obj));
		$http.post('/todo_app/UpdateAccountDetailsController', JSON.stringify($scope.obj)).then(function(response) {
			$scope.obj.fullName = '';
			$scope.obj.userName = '';
			$scope.obj.phone = '';
			$scope.obj.email = '';
			$scope.obj.address = '';
			$scope.validateUserName = '';
			$scope.validateEmail = '';
			$scope.validatePhone = '';
			$scope.isDisabled = true;
			var res = response.data;
			if(res != 0) {
				$scope.obj.msg = 'Credentials changed Successfully! ';
				$scope.isError = 1;
			} else {
				$scope.obj.msg = 'Something went wrong! Please try again!';
				$scope.isError = 0;
			}
		})
	}
});