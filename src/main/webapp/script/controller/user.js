'use strict';

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
            console.debug(resp)
            if(resp.data && resp.data.message)
                $scope.message = resp.data.message;
            else
                $scope.message = "Server error"
        });


    }


}
