var external_chart;
(function() {
  /*
   * Modulo do componente boletim-detail (boletimDetail)
   */
  var module = angular
    .module('boletimDetail', ['chart.js'])
    .controller('BoletimDetailController', BoletimDetailController)
  ;

  function BoletimDetailController() {
    var vm = this;

      // Lista de avisos & ocorrencias
  //    vm.avisos = [];
  //
  //    vm.avisos.push({title:"Próxima Aula", content:"10h00 - Matemática<br>Sala: 5B", icon:"icon ion-cube placeholder-icon", url: "#"});
  //    vm.avisos.push({title:"Aviso:", content:"Matrículas abertas para o próximo semestre.<br>Informações na secretaria.", icon:"icon ion-person-stalker placeholder-icon", url:"#"});

    console.log('[BoletimDetailController]\tvm=', vm);

    vm.toggleGroup = function(group) {
      if(vm.isGroupShown(group)) {
        vm.shownGroup = null;
      }
      else {
        vm.shownGroup = group;
      }
      console.log('vm=', vm);
      console.log('vm.shownGroup=', vm.shownGroup);
    };

    vm.isGroupShown = function(group) {
      console.log('vm.shownGroup === group? ', (vm.shownGroup === group));
      return vm.shownGroup === group;
    };

    console.log('BoletimDetailController] vm', vm);
  }

})();
