  angular.module('custom.controllers')
  .controller('HomeController', [
      '$scope',
      '$http',
      '$rootScope',
      '$state',
      '$timeout',
      '$translate',
      'Notification',
      '$ionicHistory',
      '$cordovaVibration',
      '$ionicModal',

      /* ngResource services */
      'MenuTree',

      function($scope, $http, $rootScope, $state, $timeout, $translate, Notification, $ionicHistory, $cordovaVibration, $ionicModal, menuTree) {

        console.log("HomeController");

        $scope.showCalendarButton = function() {
          //console.log('[showCalendarButton]\t$state=', $state);
          var show = false;
          if ($state.current.name == 'home.agenda') {
            show = true;
          }

          return show;
        };


      } ]);
