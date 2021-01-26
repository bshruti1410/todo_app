var myApp = angular.module('passwordApp', []);

myApp.controller('passwordController', function($scope, $http) {
	
	$scope.oldPassword = '';
	$scope.newPassword = '';
	$scope.confirmPassword = '';
	$scope.msg = '';
	$scope.isError = '';

	$scope.changePassword = function() {
		$http.post('/todo_app/UpdatePasswordController?newPassword=' + $scope.newPassword + '&oldPassword=' + $scope.oldPassword).then(function(response) {
			$scope.oldPassword = ''
			$scope.newPassword = '';
			$scope.confirmPassword = '';
			if(response.data > 0) {
				$scope.msg = 'Updated password successfully!';
				$scope.isError = 1;
			} else {
				$scope.msg = 'Incorrect password, please try again!';
				$scope.isError = 0;
			}
		});
	}
	
});