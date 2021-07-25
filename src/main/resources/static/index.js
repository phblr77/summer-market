angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/summer/api/v1';

    $scope.loadPage = function (pageIndex = 1) {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                'p': pageIndex
            }
        }).then(function (response) {
            $scope.productsPage = response.data;
            $scope.navList = $scope.generatePagesIndexes(1, $scope.productsPage.totalPages);
            console.log(response.data);
        });
    };

    $scope.loadCart = function () {
        $http({
            url: contextPath + '/cart',
            method: 'GET'
        }).then(function (response) {
            $scope.cart = response.data;
        });
    }

    $scope.addToCart = function (productId) {
        $http({
            url: contextPath + '/cart/add/' + productId,
            method: 'GET'
        }).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.removeFromCart = function (productId) {
        $http({
            url: contextPath + '/cart/remove/' + productId,
            method: 'GET'
        }).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.clearCart = function () {
        $http({
            url: contextPath + '/cart/remove',
            method: 'GET'
        }).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.decrement = function (productId) {
        $http({
            url: contextPath + '/cart/decrement/' + productId,
            method: 'GET'
        }).then(function (response) {
            $scope.loadCart();
        });
    }

    //todo
    $scope.totalPriceOfCart = function () {
        $http({
            url: contextPath + '/cart/price',
            method: 'GET'
        }).then(function (response) {

        });
    }

    $scope.createOrder = function () {
        $http({
            url: contextPath + '/orders/create',
            method: 'POST'
        }).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.totalPrice = 0;
    $scope.loadPage();
    $scope.loadCart();
});