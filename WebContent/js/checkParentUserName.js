var myApp = angular.module('todoApp', []);

myApp.controller('ajaxController', function ($scope, $http) {

	$scope.obj = { userName: '', password: '', fullName: '', address: '', phone: '', email: '', aadhar: '', dob: '', role: '', pUserName: '' };
	$scope.pUserAvailable = '';
	
	$scope.checkUserName = function () {
		if ($scope.obj.pUserName != '') {
			$http.get('/todo_app/CheckUserNameController?pUserName=' + $scope.obj.pUserName).then(function (response) {
				var res = response.data;
				if (res == 1)
					$scope.pUserAvailable = 'Available';
				else
					$scope.pUserAvailable = 'Not Available';
			});
		}
	}
	
});