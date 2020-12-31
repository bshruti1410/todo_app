var myApp = angular.module('todoApp', []);

myApp.controller('todoController', function ($scope, $http) {

	$scope.obj = {title: '', body: '', dueDate: '', userId: ''};

	angular.element(document).ready(function() {
		var todoId = document.getElementById('todoId').value;
		if(todoId != -1) {
			$http.get('/todo_app/ViewToDoController?todoId=' + todoId).then(function(response) {
				var res = response.data;
				console.log(res);
				if(res) {
					$scope.obj.title = res.title;
					$scope.obj.body = res.body;
					$scope.obj.dueDate = new Date(res.dueDate);
					$scope.obj.userId = res.userId;
				}
			});
		}
		
	});
	
});