angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8888/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/getAllProducts')
            .then(function (response) {
                $scope.ProductsList = response.data;
                $scope.viewDiv($scope.ProductsList.length);
            })
    };

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            })
    }

    $scope.aboutProduct = function (productId) {
        $http.get(contextPath + '/getProduct/' + productId)
            .then(function (response) {
                $scope.ProductsList = response.data;
                $scope.viewDiv($scope.ProductsList.length);
            })
    }

    $scope.viewDiv = function (length) {
        if (length > 1) {
                document.getElementById('div_return').hidden = true;
        } else {
            document.getElementById('div_return').hidden = false;
        }
    }


    $scope.returnProducts = function () {
        $scope.loadProducts();
    }

    $scope.loadProducts();

    const form = document.getElementById('form');

    function getFormValue(event) {
        form.getElementsById
        event.preventDefault();
        var id = $("#formGroupId").val();
        var name = $("#formGroupName").val();
        var cost = $("#formGroupCost").val();
        $http({
            url: contextPath + '/addProduct',
            method: 'GET',
            params: {
                id: id,
                name: name,
                cost: cost
            }
        }).then(function (response) {
            $scope.loadProducts();

        });
    }

    form.addEventListener('submit', getFormValue);
});