/**
 * Created by Alex on 18.12.2016.
 */
angular.module("editcurrentmeal", ['ngSanitize'])

    .controller("editcurrentmealCtrl", function($scope, $http) {
        $scope.user = [];
        $scope.meal;

        $http.get('http://localhost:8080/user/name/').success(function (data) {
            $scope.CustomString = data.cstring;
        });
        $http.get('http://localhost:8080/edit/currentmeal/').success(function (data) {
            $scope.meal = data;
        });

        $scope.saveEdit = function (action) {
            $scope.mealNew =
                {
                    mealId: $scope.meal.mealId,
                    photo: $scope.meal.photo,
                    mealName: $scope.src.mealName,
                    price: $scope.src.price,
                    description: $scope.src.description
                } ;
            $http.post("meal/addnew/", $scope.mealNew, action);
            window.location = "http://localhost:8080/editmeal";
        }
    });
