/**
 * Created by Alex on 17.12.2016.
 */

angular.module("addMeal", ['ngSanitize'])

    .controller("addMealCtrl", function($scope, $http) {

        $http.get('http://localhost:8080/user/name/').success(function (data) {
            $scope.CustomString = data.cstring;
        });

        $scope.addMeal = function (action) {

            $scope.meal =
                {
                    photo: $scope.src.mealPhoto,
                    mealName: $scope.src.mealName,
                    description: $scope.src.description,
                    price: $scope.src.price,
                } ;
            $http.post("admin/add/", $scope.meal , action)
            alert("Товар добавлен!");
            window.location = "http://localhost:8080/menu";
        };



    });