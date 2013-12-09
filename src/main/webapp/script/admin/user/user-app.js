'use strict';

var userApp = angular.module('userApp',['ngRoute','ngResource']);

userApp.config(function ($routeProvider) {

$routeProvider
  .when('/', {
    templateUrl: '/views/admin/user/list.html',
    controller: 'UserListCtrl'
  })
  .when('/view/:id', {
      templateUrl: '/views/admin/user/view.html',
      controller: 'UserViewCtrl'
    })
  .otherwise({
    redirectTo: '/'
  });

});

userApp.factory('User',['$resource',function($resource) {
        return $resource('/app/admin/user/:id',
            { id: '@id' });
  }]);



if(!Array.prototype.remove)
    Array.prototype.remove = function(obj) {
        if(obj == null) return;
        var x = this.indexOf(obj);
        if(x >= 0)
            this.splice(x,1);
    }