(function () {
  /*
   * Modulo do componenet avisos-list (avisosList)
   */
  angular
    .module('avisos')
    .controller('AvisosListItemController', AvisosListItemController);

  function AvisosListItemController() {
      var vm = this;

      vm.itemClick = function() {
        console.log('[AvisosListItemController.itemClick]');
        vm.itemOpenAvisoDetail();
      }

      vm.itemOpenAvisoDetail = function() {
        console.log('[AvisosListItemController.itemOpenAvisoDetail]\t avisoItem=', vm.avisoItem);
        vm.onListOpenAvisoDetail({aviso: vm.avisoItem});
      }

      console.log('[AvisosListItemController]\tvm=', vm);

   }
})();
