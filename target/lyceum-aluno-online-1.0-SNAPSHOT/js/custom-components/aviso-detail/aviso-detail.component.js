(function() {
angular.module('avisoDetail')
.component('avisoDetail', {
  templateUrl: 'js/custom-components/aviso-detail/aviso-detail.component.html',
  bindings: {
    avisoItem: "="
  },
  controller: 'AvisoDetailController',
  controllerAs: 'ctrl'
});

})();
