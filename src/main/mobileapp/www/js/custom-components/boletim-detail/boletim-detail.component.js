(function() {
angular.module('boletimDetail')
.component('boletimDetail', {
  templateUrl: 'js/custom-components/boletim-detail/boletim-detail.component.html',
  bindings: {
    cell: "=",
    chart: "="
  },
  controller: 'BoletimDetailController',
  controllerAs: 'ctrl'
});

})();
