(function() {
angular.module('menu')
  .component('menuRight', {
    templateUrl: 'js/custom-components/menu-right/menu-right.component.html',
    bindings: {
      tableData: "=",
      eventSources: "=",
      onListOpenAvisoDetail: "&"
    },
    controller: 'MenuRightController',
    controllerAs: 'ctrl'
  });

})();
