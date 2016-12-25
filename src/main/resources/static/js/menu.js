/**
 * Created by Alex on 11.12.2016.
 */
angular.module("menu", ['ngSanitize'])

    .controller("menuCtrl", function($scope, $http) {
        $scope.user = [];

        $http.get('http://localhost:8080/user/name/').success(function (data) {
            $scope.CustomString = data.cstring;
        });
        $http.get('http://localhost:8080/meal/info/').success(function (data) {
            $scope.menu1 = data;
        });

        $scope.orderMeal = function (meal, action) {
            $scope.meal = meal;
            $http.post("meal/order/", $scope.meal, action);
            alert("Товар добавлен в корзину!");
        }
    });