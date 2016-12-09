(function() {
angular.module('horarios')
  .component('horariosList', {
    templateUrl: 'js/custom-components/horarios-list/horarios-list.component.html',
    bindings: {
      tableData: "=",
      onListOpenAvisoDetail: "&"
    },
    controller: 'HorariosListController',
    controllerAs: 'ctrl'
  });

})();
