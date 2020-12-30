var myApp = angular.module('todoApp', []);

myApp.controller('todoController', function ($scope, $http, $window) {

	$scope.obj = {title: '', body: '', dueDate: '', userId: '', todoId: '' };

	angular.element(document).ready(function () {
		var todoId = document.getElementById('todoId').value;
		if (todoId != -1) {
			$http.get('ViewToDoController?todoId=' + todoId).then(function (response) {
				var res = response.data;
				console.log(response.data);
				$scope.obj.userId = res.userId;
				$scope.obj.title = res.title;
				$scope.obj.body = res.body;
				$scope.obj.dueDate = new Date(res.dueDate);
			});
		}
	});

	$scope.saveTodo = function () {
		console.log(JSON.stringify($scope.obj));
		var todoId = document.getElementById('todoId').value;
		var userId = document.getElementById('userId').value;
		$scope.obj.todoId = todoId;
		$scope.obj.userId = userId;
		if (todoId != -1) {
			console.log(JSON.stringify($scope.obj));
			$http.post('CreateUpdateToDo', JSON.stringify($scope.obj)).then(function (response) {
				console.log(response.data);
				if (response.data > 0) {
					$window.location.href = "Index.jsp?operation=update&status=1";
				} else {
					$window.location.href = "Index.jsp?operation=update&status=0";
				}
			});
		} else {
			console.log(JSON.stringify($scope.obj));
			$http.post('CreateUpdateToDo', JSON.stringify($scope.obj)).then(function (response) {
				console.log(response.data);
				if (response.data > 0) {
					$window.location.href = "Index.jsp?operation=create&status=1";
				} else {
					$window.location.href = "Index.jsp?operation=create&status=0";
				}
			});
		}

	}
});var myApp = angular.module('todoApp', []);

myApp.controller('todoController', function ($scope, $http, $window) {
	angular.element(document).ready(function() {
		var todoId = document.getElementById('todoId').nodeValue;
	});

});
