(function() {
angular.module('horarios')
  .component('horariosList', {
    templateUrl: 'js/custom-components/horarios-list/horarios-list.component.html',
    bindings: {
      avisoItem: "=",
      onListOpenAvisoDetail: "&"
    },
    controller: 'HorariosListController',
    controllerAs: 'ctrl'
  });

})();
