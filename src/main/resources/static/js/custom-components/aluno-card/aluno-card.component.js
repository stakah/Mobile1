angular.module('alunoCard')
.component('alunoCard', {
  templateUrl: 'js/custom-components/aluno-card/aluno-card.component.html',
  controller: ['Aluno', 'Aluno.User',
    function AlunoCardController(Aluno, Aluno_User) {
      var self = this;
      //this.aluno = {nome:"Claudia Cristina M. Rodrigues", grupo:"2o. Ano Ensino Médio", matricula: "144632", turma: "B"};
      var User = angular.fromJson(sessionStorage.getItem('_u'));
      external_User = User;
      
      //console.log('[AlunoCardController]:User=', User);
      //console.log('User.id=', User.id);
      
      self.aluno = Aluno_User.get({userId: User.id},
        function handleSuccess(aluno) {
          //console.log('aluno=', aluno);
        },
        function handleFailure() {
          //console.log('faliure: arguments=', arguments);
        });
    }
  ]
});