(function() {
angular.module('agenda')
  .component('agendaList', {
    templateUrl: 'js/custom-components/agenda-list/agenda-list.component.html',
    bindings: {
      eventSources: "=",
      onListOpenAvisoDetail: "&"
    },
    controller: 'AgendaListController',
    controllerAs: 'ctrl'
  });

})();
