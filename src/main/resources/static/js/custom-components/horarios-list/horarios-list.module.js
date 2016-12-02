(function () {
  /*
   * Modulo do componenet avisos-list (avisosList)
   */
  angular
    .module('horarios', [])
    .controller('HorariosListController', [
      HorariosListController]);

  function HorariosListController() {
      var vm = this;

      console.log('[HorariosListController]\tvm=', vm);


   }
})();
