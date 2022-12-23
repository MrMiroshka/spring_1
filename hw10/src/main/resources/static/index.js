angular.module('app_hw8', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8888/app/api/v1';

    $scope.loadProducts = function (pageIndex = 1) {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                min_cost: $scope.filter ? $scope.filter.min_cost : null,
                max_cost: $scope.filter ? $scope.filter.max_cost : null,
                name_product: $scope.filter ? $scope.filter.name_product : null
            }
        }).then(function (response) {
            $scope.ProductsList = response.data.content;
            $scope.viewDiv($scope.ProductsList.length);
        });
    };

    $scope.deleteProduct = function (productId) {
        $http.delete(contextPath + '/products/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            })
    }

    $scope.aboutProduct = function (productId) {
        $http.get(contextPath + '/products/' + productId)
            .then(function (response) {
                $scope.ProductsList = response.data;
                $scope.viewDiv($scope.ProductsList.length);
            })
        console.log(contextPath + '/products/' + productId)
    }

    $scope.putBasket = function (productId) {
        $http.get(contextPath + '/products/basket/put/' + productId)
            .then(function (response) {
                $scope.BasketList = response.data.content;
            });
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

    $scope.createProductJson = function () {
        $http.post(contextPath + '/products', $scope.newProductJson)
            .then(function (response) {
                $scope.loadProducts();
            })
    }
});