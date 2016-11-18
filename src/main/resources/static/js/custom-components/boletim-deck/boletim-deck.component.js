angular.module('boletim')
.component('boletimDeck', {
  templateUrl: 'js/custom-components/boletim-deck/boletim-deck.component.html',
  controller: 'BoletimDeckController',
  controllerAs: 'ctrl',
  bindings: {
      aluno: "="
    },
});
