/**
 * Main angular application for Auto parts online store.
 *
 * Created by Aamir on 10/28/2016.
 */
(function () {
    var autoPartOnlineApp = angular.module('autoPartOnlineApp', ['ngRoute']);

    autoPartOnlineApp.config(['$routeProvider', function ($routeProvider) {

        $routeProvider.when("/", {
            templateUrl: "app/components/home/home.html",
            controller: "homeController"
        });
    }]);
})();