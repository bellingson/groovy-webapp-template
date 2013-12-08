'use strict';

var myapp = angular.module('myapp',['ngRoute','ngResource']);


myapp.config(function ($routeProvider) {
	
$routeProvider
  .when('/', {
    templateUrl: 'views/main.html',
    controller: 'MainCtrl'
  })
  .when('/signin', {
      templateUrl: 'views/user/signin.html',
      controller: 'SignInCtrl'
    })
   .when('/register', {
         templateUrl: 'views/user/register.html',
         controller: 'RegisterCtrl'
       })
  .when('/thing/:id', {
    templateUrl: 'views/thing.html',
    controller: 'ThingCtrl'
  })
  .otherwise({
    redirectTo: '/'
  });

});

myapp.factory('User',['$resource',function($resource) {
        return $resource('/app/user/:id',
            { id: '@id' });
  }]);