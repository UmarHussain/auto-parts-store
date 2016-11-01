/**
 * Service to load auto parts to home page.
 *
 * Created by Aamir on 10/28/2016.
 */
(function(){
    angular.module('autoPartOnlineApp').factory('homeService', HomeService);

    function HomeService($http) {
        return {
            getAutoParts: getAutoParts,
            placeOrder: placeOrder
        };

        function getAutoParts() {
            return $http.get('/terminal/auto/PB7856/part')
                .then(function(response) {
                    return response.data;
                })
                .catch(function(error){
                    return error;
                });
        }

        function placeOrder(order) {
            return $http({
                url: "/online/auto/part/order",
                method: "POST",
                data: order
            })
                .then(function(response){
                    return response.data;
                })
                .catch(function(error){
                    return error;
                });
        }
    }

})();