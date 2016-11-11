(function() {
angular.module('avisos')
  .component('avisosList', {
    templateUrl: 'js/custom-components/avisos-list/avisos-list.component.html',
    bindings: {
      onOpenAvisoDetail: "&"
    },
    controller: 'AvisosListController',
    controllerAs: 'ctrlAvisosList'
  });

})();
