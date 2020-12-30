var myApp = angular.module('todoApp', []);

myApp.controller('ajaxController', function ($scope, $http, $window) {
	
	$scope.obj = { recordFound: false, msg: ''};
	$scope.childDetails = [];
	$scope.todoList = [];

	$scope.viewChildren = function() {
		$http.get('/todo_app/ChildDetailsController').then(function(response) {
			var res = response.data;
			
			if (res) {
				$scope.obj.recordFound = true;
				$scope.childDetails = res;
				$window.location.href = "/todo_app/jsp/ChildRecord.jsp";
			} else {
				$scope.obj.recordFound = false;
				$scope.msg = 'No Records Found!';
				$window.location.href="/todo_app/jsp/HomePage.jsp";
			}
		});
	}

	angular.element(document).ready(function() {
		$http.get('/todo_app/ChildDetailsController').then(function(response) {
			var res = response.data;
			
			if (res) {
				$scope.obj.recordFound = true;
				$scope.childDetails = res;
			}
		});
	});


	$scope.createTodo = function() {
		$window.location.href = "/todo_app/jsp/CreateToDo.jsp";
	}

	$scope.viewTodo = function() {
		$http.get('/todo_app/ViewToDoListController').then(function(response) {
			var res = response.data;
			if(res) {
				$scope.obj.recordFound = true;
				$scope.todoList = res;
				$window.location.href = "/todo_app/jsp/ViewToDo.jsp";
			} else {
				$scope.obj.recordFound = false;
				$scope.msg = 'No Records Found!';
				$window.location.href="/todo_app/jsp/HomePage.jsp";
			}
		});
	}

	angular.element(document).ready(function() {
		$http.get('/todo_app/ViewToDoListController').then(function(response) {
			var res = response.data;
			
			if (res) {
				$scope.obj.recordFound = true;
				$scope.todoList = res;
			}
		});
	});
	

});
