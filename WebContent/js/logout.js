var myApp = angular.module('logoutApp', []);

myApp.controller('logoutController', function($scope, $http) {
	$scope.logout = false;
	$scope.msg = '';
	
	angular.element(document).ready(function() {
		$http.post('/todo_app/LogoutController').then(function(response) {
			if(response.data == 1) {
				$scope.logout = true;
				$scope.msg = 'Thanks for visiting! ';
			} else {
				$scope.logout = false;
				$scope.msg = 'Error occured while logging out!';
			}
		});
	});
});