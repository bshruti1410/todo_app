var myApp = angular.module('passwordApp', []);

myApp.controller('passwordController', function($scope, $http) {
	
	$scope.obj = {oldPassword : '', newPassword : '', confirmPassword : '', msg : '', isError : ''};

	$scope.changePassword = function() {
		$http.post('/todo_app/UpdatePasswordController?newPassword=' + $scope.obj.newPassword + '&oldPassword=' + $scope.obj.oldPassword).then(function(response) {
			$scope.obj.oldPassword = ''
			$scope.obj.newPassword = '';
			$scope.obj.confirmPassword = '';
			if(response.data > 0) {
				$scope.obj.msg = 'Updated password successfully!';
				$scope.obj.isError = 1;
			} else {
				$scope.obj.msg = 'Incorrect password, please try again!';
				$scope.obj.isError = 0;
			}
		});
	}
	
});