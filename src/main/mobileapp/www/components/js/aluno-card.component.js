angular.module('aluno')
.component('alunoCard', {
  templateUrl: 'components/templates/aluno-card.component.html',
  controller: function AlunoCardController() {
    this.aluno = {nome:"Claudia Cristina M. Rodrigues", grupo:"2o. Ano Ensino Médio", matricula: "144632", turma: "B"};
    
  }
});