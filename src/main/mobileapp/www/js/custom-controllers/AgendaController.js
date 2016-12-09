  angular.module('custom.controllers')
  .controller('AgendaController', [
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
      'SessionData',
      function($scope, $http, $rootScope, $state, $timeout, $translate, Notification, $ionicHistory, $cordovaVibration, $ionicModal, SessionData) {
          var vm = this;

          vm.sessionData = SessionData;
          vm.aluno = vm.sessionData.aluno;

          console.log('[AgendaController]\tvm=', vm);

    } ]);
