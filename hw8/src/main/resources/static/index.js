angular.module('app_hw8', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8888/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products/getAllProducts')
            .then(function (response) {
                $scope.ProductsList = response.data;
                $scope.viewDiv($scope.ProductsList.length);
            })
    };

    $scope.deleteProduct = function (productId) {
        $http.delete(contextPath + '/products/delete/' + productId)
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
        var name = $("#formGroupName").val();
        var cost = $("#formGroupCost").val();
        $http({
            url: contextPath + '/products/addProduct',
            method: 'POST',
            params: {
                name: $scope.formGroupName,
                cost: $scope.formGroupCost
            }
        }).then(function (response) {
            $scope.loadProducts();

        });
    }

    form.addEventListener('submit', getFormValue);
});