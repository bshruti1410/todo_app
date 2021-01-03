var myApp = angular.module('logoutApp', []);

myApp.controller('logoutController', function($scope, $http) {
	$scope.obj = {logout: false, msg:''};
	
	angular.element(document).ready(function() {
		$http.post('/todo_app/LogoutController').then(function(response) {
			if(response.data == 1) {
				$scope.obj.logout = true;
				$scope.obj.msg = 'Thanks for visiting! ';
			} else {
				$scope.obj.logout = false;
				$scope.obj.msg = 'Error occured while logging out!';
			}
		});
	});
});