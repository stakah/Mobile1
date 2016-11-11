(function () {
  /*
   * Modulo do componenet avisos-list (avisosList)
   */
  angular
    .module('avisos')
    .controller('AvisosListController',AvisosListController);

  function AvisosListController($scope) {
      var vm = this;

      console.log('[AvisosListController]\t$scope=', $scope);

      // Lista de avisos & ocorrencias
      vm.avisos = [];

      vm.avisos.push({title:"Próxima Aula", content:"10h00 - Matemática<br>Sala: 5B", icon:"icon ion-cube placeholder-icon", url: "#"});
      vm.avisos.push({title:"Aviso:", content:"Matrículas abertas para o próximo semestre.<br>Informações na secretaria.", icon:"icon ion-person-stalker placeholder-icon", url:"#"});

      vm.listOpenAvisoDetail = function(item) {
        vm.avisoItem = item;
        console.log('[AvisosListController.listOpenAvisoDetail]\tvm=', vm);
        vm.onOpenAvisoDetail({aviso: item});
      }

      console.log('[AvisosListController]\tvm=', vm);

   }
})();
