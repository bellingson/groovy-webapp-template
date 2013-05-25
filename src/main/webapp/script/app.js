'use strict';

/*
var myapp = angular.module('myapp', [])	
  .config(function($httpProvider) {
	
	//delete $httpProvider.defaults.headers.common['X-Requested-With'];
		
	}).config(function ($routeProvider) {
		
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
	
  });
*/

var myapp = angular.module('myapp',[]);

/*
myapp.config(function($httpProvider) {
	
	//delete $httpProvider.defaults.headers.common['X-Requested-With'];
		
	});
*/	

myapp.config(function ($routeProvider) {
	
$routeProvider
  .when('/', {
    templateUrl: 'views/main.html',
    controller: 'MainCtrl'
  })
  .otherwise({
    redirectTo: '/'
  });

});