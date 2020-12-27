var myApp = angular.module('todoApp', []);

myApp.controller('validateUserController', function ($scope, $http, $window) {
	
	$scope.obj = {userName:'', password: ''};
	$scope.error = '';
	
	$scope.validateUser = function() {
		$http.post('/todo_app/LoginController?username=' + $scope.obj.userName + '&password=' + $scope.obj.password)
				.then(function(response) {
			var res = response.data;
			var invLogCount = res.invalidLoginCount;
			if (invLogCount == 0) {
				$window.location.href = "/todo_app/jsp/HomePage.jsp";
			} else {
				if (invLogCount == -1) {
					$scope.error = 'Invalid Credentials! Please try again...';
				} else if (invLogCount > 0 && invLogCount < 4) {
					$scope.error = 'Please enter valid Credentials! You have ' + (4-invLogCount).toString() + ' attempts left.';
				} else {
					$scope.error = 'Your account is locked.';
					if (res.role == 'Parent')
						$scope.error = $scope.error + ' Please contact administrator!';
					else if (res.role == 'Child')
						$scope.error = $scope.error + ' Please contact your parent to unlock!';
				}
			}
		});
	}
	
});