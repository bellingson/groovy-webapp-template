'use strict';

function UserListCtrl($scope, User) {

    $scope.users = User.query();

    $scope.deleteUsers = function() {

        var selected = $.grep($scope.users,function(user) { return user.selected; } )

        if(!confirm("Are you sure you want to delete selected users?"))
            return;

        $(selected).each(function(i,user) {
            //console.debug(user.email);
        });

        var handleDeleteComplete = function(user) {

            $scope.users.remove(user);
            selected.remove(user);

            if(selected.length > 0)
                deleteUser(selected[0]);
            else
                $scope.message = "Selected user(s) deleted"

        }

        var handleError = function(resp) {
            if(resp.data && resp.data.message)
                $scope.message = resp.data.message;
            else
                $scope.message = "Server Error: " + resp;
        }

        var deleteUser = function(user) {

            user.$delete(handleDeleteComplete,
                         handleError);

        }

        deleteUser(selected[0]);


    }


}

function UserViewCtrl($scope, $routeParams, $location, User) {

    var id = $routeParams['id'];

    $scope.user = User.get({id: id},function(user) {
        user.password = null;
        user.confPassword = null;
    });

    $scope.updateUser = function(user) {

        user.$save(function() {
            $location.path("/");
            $scope.message = "Update complete";
        },
        function(resp) {
            $scope.message = resp;
        });
    }



}