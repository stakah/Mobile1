angular.module('alunoCard')
.component('alunoCard', {
  templateUrl: 'js/custom-components/aluno-card/aluno-card.component.html',
  controller: function AlunoCardController() {
    this.aluno = {nome:"Claudia Cristina M. Rodrigues", grupo:"2o. Ano Ensino Médio", matricula: "144632", turma: "B"};
    
  }
});