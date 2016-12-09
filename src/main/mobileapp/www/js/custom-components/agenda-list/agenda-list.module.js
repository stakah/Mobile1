(function () {
  /*
   * Modulo do componenet avisos-list (avisosList)
   */
  angular
    .module('agenda', [])
    .controller('AgendaListController', [
      AgendaListController]);

  function AgendaListController() {
      var ctrl = this;

      console.log('[AgendaListController]\tctrl=', ctrl);


   }
})();
