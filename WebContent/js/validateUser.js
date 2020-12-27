var myApp = angular.module('todoApp', []);

myApp.controller('validateUserController', function ($scope, $http) {
	
	$scope.obj = {userName:'', password: ''};
	
	$scope.validateUser = function() {
		$http.get('/todo_app/LoginController').then(function(response) {
			var res = response.data;
			alert(hello);
		});
	}
});