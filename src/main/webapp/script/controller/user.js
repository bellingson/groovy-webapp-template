'use strict';

function SignInCtrl($scope) {




}

function RegisterCtrl($scope, $location, User) {

    // test user
    $scope.user = new User({firstName: 'Bob', lastName: 'Jones', email: 'foo@bar.com', password: 'password', confPassword: 'password'});

    //$scope.user = new User();

    $scope.registerUser = function(user) {

        console.debug('register: ' + user.firstName);

        if(user.password != user.confPassword) {
            $scope.message = "Passwords do not match";
            return;
        }

        user.confPassword = null;

        user.$save(function(r) {
            $scope.message = "Registration complete";
            $location.path("/login");
        },
        function(resp) {
        });


    }


}
