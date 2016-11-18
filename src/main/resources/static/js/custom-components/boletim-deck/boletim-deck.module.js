(function() {
  /*
   * Modulo do componente boletim-deck (boletimDeck)
   */
  angular.module('boletim', ['aol.service'])
    .controller('BoletimDeckController',
     ['Aluno', 'Aluno.User',
        BoletimDeckController]);

  function BoletimDeckController(Aluno, Aluno_User) {
    var self = this;
    //this.aluno = {nome:"Claudia Cristina M. Rodrigues", grupo:"2o. Ano Ensino Médio", matricula: "144632", turma: "B"};
    var User = angular.fromJson(sessionStorage.getItem('_u'));
    external_User = User;

    console.log('[AlunoCardController]:User=', User);
    console.log('User.id=', User.id);

    self.aluno = Aluno_User.get({userId: User.id},
      function handleSuccess(aluno) {
        console.log('aluno=', aluno);
        self.aluno = aluno;
      },
      function handleFailure() {
        console.log('faliure: arguments=', arguments);
      });
  }
})();
