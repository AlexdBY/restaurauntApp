/**
 * Created by Alex on 12.12.2016.
 */
angular.module("basket", ['ngSanitize'])

    .controller("basketCtrl", function($scope, $http) {
        $scope.user = [];
        $scope.total = 0;

        $http.get('http://localhost:8080/user/name/').success(function (data) {
            $scope.CustomString = data.cstring;
        });
        $http.get('http://localhost:8080/basket/info/').success(function (data) {
            $scope.menu1 = data;
            data.forEach(function (item) {
                $scope.total = $scope.total + item.price;
            })
        });

        $scope.makeOrder = function (action) {
            $http.post('http://localhost:8080/basket/order/');
            $http.get('http://localhost:8080/basket/delete/');
            alert("Заказ потверждён!");
            window.location = "http://localhost:8080/menu";
        }

    });
