(function() {
angular.module('avisos')
  .component('avisosListItem', {
    templateUrl: 'js/custom-components/avisos-list/avisos-list-item.component.html',
    bindings: {
      avisoItem: "=",
      onListOpenAvisoDetail: "&"
    },
    controller: 'AvisosListItemController',
    controllerAs: 'ctrl'
  });

})();
