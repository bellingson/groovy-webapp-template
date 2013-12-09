'use strict';


currentApp.factory('CurrentUser',['$resource',function($resource) {
        return $resource('/user/:id/:aMethod',
            { id: '@id', aMethod: '@aMethod' }, {
                current: { method: 'GET', params: { aMethod: 'current' }  }
           });
  }]);


currentApp.run(function($rootScope, CurrentUser) {

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


function SignInCtrl($scope) {

    $scope.recover = {};

     $scope.recoverPassword = function() {

        if($scope.recover.email == null) {
            $scope.message = "Email address is required";
            return;
        }

        alert('Function not yet implemented: ' + $scope.recover.email);

        $scope.forgotPassword = false;

     }


}

function RegisterCtrl($scope, $location, $rootScope, CurrentUser) {

    // test user
    $scope.user = new CurrentUser({firstName: 'Bob', lastName: 'Jones', email: 'foo@bar.com', password: 'password', confPassword: 'password'});

    //$scope.user = new CurrentUser();

    $scope.registerUser = function(user) {

        if(user.password != user.confPassword) {
            $scope.message = "Passwords do not match";
            return;
        }

        user.confPassword = null;

        user.$save(function(r) {
            $rootScope.message = "Registration complete";
            $location.path("/signin");
        },
        function(resp) {
            console.debug(resp)
            if(resp.data && resp.data.message)
                $scope.message = resp.data.message;
            else
                $scope.message = "Server error"
        });


    }


}
