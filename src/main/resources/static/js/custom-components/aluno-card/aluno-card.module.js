(function() {
  /*
   * Modulo do componente aluno-card (alunoCard)
   */
  angular.module('alunoCard', ['aol.service'])
    .controller('AlunoCardController',
     ['Aluno', 'Aluno.User',
        AlunoCardController]);

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
})();
