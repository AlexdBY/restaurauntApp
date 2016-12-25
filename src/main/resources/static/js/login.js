/**
 * Created by Alex on 10.12.2016.
 */
angular.module("login", ['ngSanitize'])

    .controller("loginCtrl", function($scope, $http) {

            $scope.saveUser = function (action) {

                $scope.user =
                    {
                        name: $scope.src.name,
                        password: $scope.src.pas,
                        phone: $scope.src.phone,
                        address: $scope.src.address
                    } ;
                $http.post("create/user/", $scope.user , action)};

            $scope.signIn = function (action) {
                $scope.user =
                    {
                        name: $scope.src.name,
                        password: $scope.src.pas,
                        phone: $scope.src.phone,
                        address: $scope.src.address
                    } ;
                $http.post("login/user/", $scope.user , action).success(function () {}).error(function () {
                    $http.get("login/user2/", action).success(function (data) {
                        $scope.URL = data.url;
                    }).success(function () {
                        window.location.href = $scope.URL;
                    });
                });


            };

        }
    );