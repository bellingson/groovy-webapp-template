'use strict';

var myapp = angular.module('myapp',['ngRoute','ngResource']);


var currentApp = myapp;

myapp.config(function ($routeProvider) {
	
$routeProvider
  .when('/', {
    templateUrl: 'views/widget/list.html',
    controller: 'WidgetListCtrl'
  })
  .when('/widget/:id', {
    templateUrl: 'views/widget/edit.html',
    controller: 'WidgetCtrl'
  })
  .when('/widget/:id/view', {
      templateUrl: 'views/widget/view.html',
      controller: 'WidgetCtrl'
    })
  .otherwise({
    redirectTo: '/'
  });

});

currentApp.factory('Widget',['$resource',function($resource) {
        return $resource('/widget/:id',
                        { id: '@id'});
  }]);

if(!Array.prototype.remove)
    Array.prototype.remove = function(obj) {
        if(obj == null) return;
        var x = this.indexOf(obj);
        if(x >= 0)
            this.splice(x,1);
    }