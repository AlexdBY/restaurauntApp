/**
 * Created by Alex on 18.12.2016.
 */
angular.module("editMeal", ['ngSanitize'])

    .controller("editCtrl", function($scope, $http) {
        $scope.user = [];

        $http.get('http://localhost:8080/user/name/').success(function (data) {
            $scope.CustomString = data.cstring;
        });
        $http.get('http://localhost:8080/meal/info/').success(function (data) {
            $scope.menu1 = data;
        });

        $scope.editMeal = function (meal, action) {
            $scope.meal = meal;
            $http.post("meal/edit/", $scope.meal, action);
            window.location = "http://localhost:8080/editcurrentmeal";
        }
    });
