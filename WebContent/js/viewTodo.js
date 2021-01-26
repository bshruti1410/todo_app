var myApp = angular.module('viewTodoApp', []);

myApp.controller('viewTodoController', function($scope, $http) {

	$scope.recordFound = false;
	$scope.msg = '';
	$scope.todoList = [];

	angular.element(document).ready(function() {
		$http.get('/todo_app/ViewToDoListController').then(function(response) {
			var res = response.data;
			if (res.length != 0) {
				$scope.recordFound = true;
				$scope.todoList = res;
				$scope.msg = '';
			} else {
				$scope.recordFound = false;
				$scope.msg = 'No record found';
			}
		});
	});

	$scope.deleteTodo = function(todoId,index) {
		$http.get('/todo_app/DeleteToDoController?todoId=' + todoId).then(function(response) {
			var res = response.data;
			if(res>0) {
				alert('Deleted Successfully');
				$scope.todoList.splice(index, 1);
			}
		});
	} 

});