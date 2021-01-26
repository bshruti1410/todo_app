var myApp = angular.module('childToDoApp', []);

myApp.controller('childToDoController', function($scope, $http) {
	$scope.recordFound = false;
	$scope.msg = '';
	$scope.childTodo = [];

	angular.element(document).ready(function() {
		var userId = document.getElementById('userId').value;
		$http.get('/todo_app/ViewChildToDoController?userId=' + userId).then(function(response) {
			var res = response.data;
			if(res.userAvailable) {
				$scope.recordFound = true;
				$scope.childTodo = res.todoList;
				$scope.msg = '';
			} else {
				$scope.recordFound = false;
				$scope.msg = 'No record found';
			}
			
		});
		
	});
});