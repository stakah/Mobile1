  angular.module('custom.controllers')
  .controller('HomeAppController', [ 
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
      function($scope, $http, $rootScope, $state, $timeout, $translate, Notification, $ionicHistory, $cordovaVibration, $ionicModal) {
        
        console.log('HomeAppController');
        
        
      } ]);
