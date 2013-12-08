'use strict';

myapp.controller('MainCtrl', ['$scope','$http', function ($scope,$http) {

	$http.get('app/things')
		 	.success(function(data) {
			$scope.things = data;
		});
		
  }]);


myapp.controller('ThingCtrl', ['$scope','$routeParams','$http', function ($scope,$routeParams,$http) {

	$http.get('app/thing/' + $routeParams['id'])
		 	.success(function(data) {
			$scope.thing = data;
		});

  }]);
