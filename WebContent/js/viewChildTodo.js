var myApp = angular.module('childToDoApp', []);

myApp.controller('childToDoController', function($scope, $http) {
	$scope.obj = {recordFound: false, msg: ''};
	$scope.childTodo = [];

	angular.element(document).ready(function() {
		var userId = document.getElementById('userId').value;
		$http.get('/todo_app/ViewChildToDoController?userId=' + userId).then(function(response) {
			var res = response.data;
			if(res.userAvailable) {
				$scope.obj.recordFound = true;
				$scope.childTodo = res.todoList;
				$scope.obj.msg = '';
			} else {
				$scope.obj.recordFound = false;
				$scope.obj.msg = 'No record found!';
			}
			
		});
		
	});
});