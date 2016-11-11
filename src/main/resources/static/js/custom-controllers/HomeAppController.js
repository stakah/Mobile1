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
          var vm = this;

          console.log('[HomeAppController]\tvm=', vm);

          $ionicModal.fromTemplateUrl('views/logged/_aluno.aviso.detail.view.html', {
            scope: $scope,
            animation: 'slide-in-up'
          }).then(function(modal) {
            vm.modalAviso = modal;
          });

          vm.openAvisoDetail2 = function(aviso) {
            vm.avisoItem = aviso;
            console.log('[HomeAppController.openAvisoDetail]\tvm=', vm);
            console.log('[HomeAppController.openAvisoDetail]\taviso=', aviso);
            vm.modalAviso.show();
          };

          $scope.closeAvisoDetail2 = function() {
            console.log('[HomeAppController]\tvm.closeAvisoDetail2()');
            vm.modalAviso.hide();
          }

    } ]);
