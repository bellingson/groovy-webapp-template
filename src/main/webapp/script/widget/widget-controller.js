'use strict';

function WidgetListCtrl($scope, Widget) {

    $scope.widgets = Widget.query();

    $scope.deleteWidgets = function() {

        var selected = $.grep($scope.widgets,function(widget) { return widget.selected == true; })

        if(selected.length == 0) {
            $scope.message = "Selection required";
            return;
        }

        if(!confirm("Are you sure you want to delete selected widget?"))
            return;

        var handleDeleteComplete = function(widget) {

            selected.remove(widget);
            $scope.widgets.remove(widget);

            if(selected.length > 0)
                deleteWidget(selected[0]);
            else
                $scope.message = "Delete complete";

        }



        var deleteWidget = function(widget) {

            widget.$delete(handleDeleteComplete,handleError);
        }

        deleteWidget(selected[0]);

    }

    $scope.showAddWidget = function() {
        $scope.widget = new Widget();
    }

    $scope.addWidget = function(widget) {

        widget.$save(function(widget) {
                        $scope.widgets.push(widget);
                        $scope.widget = null;
                     },handleError);

    }

     var handleError = function(resp) {

                if(resp.data && resp.data.message)
                    $scope.message = resp.data.message;
                else
                    $scope.message = "Server Error";
            }

}

function WidgetCtrl($scope, $routeParams, $rootScope, $location, Widget) {

    $rootScope.message = null;

    var id = $routeParams['id'];
    $scope.widget = Widget.get({ id: id });

    $scope.updateWidget = function(widget) {

        widget.$save(function(widget) {
            $rootScope.message = "Update [" + widget.name + "] complete";
            $location.path("/");
        },handleError);

    }


    var handleError = function(resp) {

                if(resp.data && resp.data.message)
                    $scope.message = resp.data.message;
                else
                    $scope.message = "Server Error";
            }

}
