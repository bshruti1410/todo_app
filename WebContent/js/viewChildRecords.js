var myApp = angular.module('todoApp', []);

myApp.controller('ajaxController', function ($scope, $http) {
	
	$scope.obj = { recordFound: false };
	$scope.childDetails = [];

	$scope.viewRecord = function() {
		$http.get('/todo_app/ChildDetailsController').then(function(response) {
			var res = response.data;
			
			if (res) {
				$scope.obj.recordFound = true;
				$scope.childDetails = res;
			} else {
				$scope.obj.recordFound = false;
			}
		});
	}

	$(document).ready(function() {
		$("button").click(function() {
			$('#table').toggle();
		});
	});
});
