angular.module('app',[]).controller('indexController',function ($scope,$http){
    const contextPath='http://localhost:8888/app';

    $scope.loadProducts=function(){
        $http.get(contextPath+'/getAllProducts')
            .then(function (response){
                $scope.ProductsList=response.data;
            })
    };

    $scope.deleteProduct = function (productId){
        $http.get(contextPath+'/delete/'+productId)
            .then(function (response){
                $scope.loadProducts();
            })
    }

    $scope.loadProducts();
});