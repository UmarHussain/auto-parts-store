/**
 * Home page controller.
 *
 * Created by Aamir on 10/28/2016.
 */
(function () {
    angular.module('autoPartOnlineApp').controller('homeController', HomeController);

    function HomeController($scope, homeService) {
        $scope.message = "Welcome!";
        $scope.isOrder = false;

        homeService.getAutoParts().then(function(autopartsjson) {
            $scope.products = autopartsjson;
        });

        $scope.buyProduct = function() {
            $scope.isOrder = true;
            $scope.quantity = 0;
        };

        $scope.confirmOrder = function() {
            var order = {
                "autoPartId": $scope.products.id,
                "quantity": $scope.quantity,
                "total": $scope.products.price * $scope.quantity
            };

            homeService.placeOrder(order).then(function(message){
                $scope.orderConfirmation = message.orderConfirmation;
                $scope.isOrder = false;
                $scope.quantity = 0;
            });
        };
    }
})();