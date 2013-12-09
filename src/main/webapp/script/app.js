'use strict';

var myapp = angular.module('myapp',['ngRoute','ngResource']);

var currentApp = myapp;

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

/*
myapp.factory('CurrentUser',['$resource',function($resource) {
        return $resource('/user/:id/:aMethod',
            { id: '@id', aMethod: '@aMethod' }, {
                current: { method: 'GET', params: { aMethod: 'current' }  }
           });
  }]);


myapp.run(function($rootScope, CurrentUser) {

    $rootScope.currentUser = null;
    CurrentUser.current(function(user) {
             if(user.firstName) {
                $rootScope.currentUser = user;
             }

        },function(resp) {
            console.debug('current user error: ' + resp);
        });

    $rootScope.isUserInRole = function(name) {

        name = 'ROLE_' + name.toUpperCase();

        //console.debug('role: ' + name + ' : ' + $rootScope.currentUser);

        var user = $rootScope.currentUser;
        if(user == null)
            return false;

        var inRole = false;
        $.each(user.roles,function(i,role) {
            if(role.name === name)
               inRole = true;
        });

        //console.debug('user: ' + user.name + ' : ' + name + ' : ' + inRole);

        return inRole;
    }


});
*/

