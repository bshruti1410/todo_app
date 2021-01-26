var myApp = angular.module('childApp', []);

myApp.controller('childController', function ($scope, $http) {

	$scope.recordFound = false;
	$scope.msg = '';
	$scope.operation = '';
	$scope.childDetails = [];

	angular.element(document).ready(function () {
		$http.get('/todo_app/ChildDetailsController').then(function (response) {
			var res = response.data;
			if (res.length != 0) {
				$scope.recordFound = true;
				$scope.childDetails = res;
				$scope.msg = '';
			} else {
				$scope.recordFound = false;
				$scope.msg = 'No record found';
			}
		});
	});
	
	$scope.access = function(access, userId) {
		if(access == 0)
			$scope.operation = 'Granted';
		else
			$scope.operation = 'Revoked';

		$http.get('/todo_app/ChildAccessController?access=' + access + '&userId=' + userId).then(function(response) {
			if(response.data != -1) {
				$scope.msg = $scope.operation + ' successfully! ';
			} else {
				$scope.msg = $scope.operation + ' failed! ';
			}
		})
	}
});
