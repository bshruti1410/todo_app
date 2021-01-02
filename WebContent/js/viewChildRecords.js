var myApp = angular.module('childApp', []);

myApp.controller('childController', function ($scope, $http) {

	$scope.obj = { recordFound: false, msg: '' };
	$scope.childDetails = [];

	angular.element(document).ready(function () {
		$http.get('/todo_app/ChildDetailsController').then(function (response) {
			var res = response.data;
			if (res.length != 0) {
				$scope.obj.recordFound = true;
				$scope.childDetails = res;
				$scope.obj.msg = '';
			} else {
				$scope.obj.recordFound = false;
				$scope.obj.msg = 'No record found!';
			}
		});
	});
	
});
