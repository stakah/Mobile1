(function() {
angular.module('menu')
  .component('menuLeft', {
    templateUrl: 'js/custom-components/menu-left/menu-left.component.html',
    bindings: {
      session: "=",
      onListOpenAvisoDetail: "&"
    },
    controller: 'MenuLeftController',
    controllerAs: 'ctrl'
  });

})();
