angular.module('alunoCard')
.component('alunoCard', {
  templateUrl: 'js/custom-components/aluno-card/aluno-card.component.html',
  controller: 'AlunoCardController',
  controllerAs: 'ctrlAlunoCard',
  bindings: {
      aluno: "=",
      columns: "<"
    },
});
