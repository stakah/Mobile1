(function() {
  /*
   * Modulo do componente aviso-detail (avisoDetail)
   */
  angular
    .module('avisoDetail', [])
    .controller('AvisoDetailController', AvisoDetailController)
  ;

  function AvisoDetailController() {
    var vm = this;

      // Lista de avisos & ocorrencias
  //    vm.avisos = [];
  //
  //    vm.avisos.push({title:"Próxima Aula", content:"10h00 - Matemática<br>Sala: 5B", icon:"icon ion-cube placeholder-icon", url: "#"});
  //    vm.avisos.push({title:"Aviso:", content:"Matrículas abertas para o próximo semestre.<br>Informações na secretaria.", icon:"icon ion-person-stalker placeholder-icon", url:"#"});

    console.log('[AvisoDetailController]\tvm=', vm);
  }
})();
