  angular.module('custom.controllers')
  .controller('AlunoAvisosController', [
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

          console.log('[AlunoAvisosController]\tvm=', vm);
          console.log('[AlunoAvisosController]\t$rootScope=', $rootScope);
          console.log('[AlunoAvisosController]\t$scope=', $scope);

          $ionicModal.fromTemplateUrl('views/logged/_aluno.aviso.detail.view.html', {
            scope: $scope,
            animation: 'slide-in-up'
          }).then(function(modal) {
            vm.modalAviso = modal;
          });

          vm.openAvisoDetail2 = function(aviso) {
            vm.avisoItem = aviso;
            console.log('[AlunoAvisosController.openAvisoDetail]\tvm=', vm);
            console.log('[AlunoAvisosController.openAvisoDetail]\taviso=', aviso);
            vm.modalAviso.show();
          };

          $scope.closeAvisoDetail2 = function() {
            console.log('[AlunoAvisosController]\tvm.closeAvisoDetail2()');
            vm.modalAviso.hide();
          }

    } ]);
