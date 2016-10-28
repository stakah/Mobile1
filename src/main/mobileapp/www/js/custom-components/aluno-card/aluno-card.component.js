angular.module('alunoCard')
.component('alunoCard', {
  templateUrl: 'js/custom-components/aluno-card/aluno-card.component.html',
  controller: ['Aluno', 
    function AlunoCardController(Aluno) {
      //this.aluno = {nome:"Claudia Cristina M. Rodrigues", grupo:"2o. Ano Ensino Médio", matricula: "144632", turma: "B"};
      var alunoId = 'CD4116DF-7BFE-4074-8066-E0FC399471DF';
      this.aluno = Aluno.get({alunoId:alunoId});
    }
  ]
});