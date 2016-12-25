'use strict';



var App = angular.module('index', ['ngSanitize']);

App.controller('indexCtrl',['$scope','$http','$location', function ($scope, $http) {
    $scope.saveSite = function (action) {
        console.log($scope.src.name);
        $scope.user =
            {
                name: $scope.src.name,
                password: $scope.src.pas
            } ;
        $http.post("create/user/", $scope.user , action)};

}]);