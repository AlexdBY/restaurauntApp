/**
 * Created by Alex on 19.12.2016.
 */
angular.module("adminMenu", ['ngSanitize'])

    .controller("adminMenuCtrl", function($scope, $http) {
        $scope.user = [];

        $http.get('http://localhost:8080/user/name/').success(function (data) {
            $scope.CustomString = data.cstring;
        });
        $http.get('http://localhost:8080/meal/info/').success(function (data) {
            $scope.menu1 = data;
        });

        $scope.deleteMeal = function (meal, action) {
            $scope.meal = meal;
            $http.post("menu/delete/", $scope.meal, action);
            alert("Товар удален!");
            window.location = "http://localhost:8080/adminmenu";
        }
    });
