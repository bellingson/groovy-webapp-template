'use strict';

/*
myapp.controller('MainCtrl', ['$scope','$html', function ($scope,$html) {
	
	//$scope.things = $html.get('app/things');
	
	console.debug($scope.things);

  }]);

*/

myapp.controller('MainCtrl', ['$scope','$http', function ($scope,$http) {

	//console.debug($html);
	
	
	$http.get('app/things')
		 	.success(function(data) {
			$scope.things = data;
		});
		
	
	//$scope.things = ['one','two','three']
	
	console.debug($scope.things);

  }]);
