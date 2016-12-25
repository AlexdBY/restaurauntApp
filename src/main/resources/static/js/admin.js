/**
 * Created by Alex on 13.12.2016.
 */
angular.module("admin", ['ngSanitize'])

    .controller("adminCtrl", function($scope, $http) {
        $scope.user = [];
        $scope.total = 0;

        $http.get('http://localhost:8080/user/name/').success(function (data) {
            $scope.CustomString = data.cstring;
        });
        $http.get('http://localhost:8080/admin/info/').success(function (data) {
            $scope.menu1 = data;
            data.forEach(function (item) {
                $scope.total = $scope.total + item.price;
            })
        });

        $scope.applyOrder = function (user, action) {
            $scope.userName = user;
            $scope.user =
                {
                    name: $scope.userName,
                    password: 0
                };
            alert("Заказ принят!");
            $http.post('http://localhost:8080/admin/applyorder/', $scope.user);
            window.location = "http://localhost:8080/admin";
        }

    });