(function() {
  /*
   * Modulo do componente boletim-deck (boletimDeck)
   */
  angular.module('boletim', ['aol.service'])
    .controller('BoletimDeckController',
     ['Aluno', 'Aluno.User', 'Aluno.Boletim', 'Aluno.Boletim.Disciplinas', 'Aluno.TurmaDisciplinas',
        BoletimDeckController]);

  function BoletimDeckController(Aluno, Aluno_User, Aluno_Boletim, Aluno_Boletim_Disciplinas, Aluno_TurmaDisciplinas) {
    var self = this;
    //this.aluno = {nome:"Claudia Cristina M. Rodrigues", grupo:"2o. Ano Ensino Médio", matricula: "144632", turma: "B"};
    var User = angular.fromJson(sessionStorage.getItem('_u'));
    external_User = User;

    console.log('[AlunoCardController]:User=', User);
    console.log('User.id=', User.id);

    self.boletim;
    self.rows = [];

    self.aluno = Aluno_User.get({userId: User.id}, Aluno_User_handleSuccess, Aluno_User_handleFailure);

    function Aluno_User_handleSuccess(aluno) {
      console.log('aluno=', aluno);
      self.aluno = aluno;

      self.boletim = Aluno_Boletim.query({alunoId: aluno.id}, Aluno_Boletim_handleSuccess, Aluno_User_handleFailure);
     }

     function Aluno_User_handleFailure() {
       console.log('faliure: arguments=', arguments);
     }

     function Aluno_Boletim_handleSuccess(boletim) {
       console.log('boletim=', boletim);

      self.boletim = boletim;

       if (boletim.length > 0) {
        var b = boletim[0];
        self.disciplinas = Aluno_Boletim_Disciplinas.query({alunoId: self.aluno.id, boletimId: b.id},
          Aluno_Boletim_Disciplinas_handleSuccess,
          Aluno_Boletim_Disciplinas_handleFailure);
       }
     }

     function Aluno_Boletim_handleFailure(reason) {
       console.log('Failure: reason=', reason);
     }

     function Aluno_Boletim_Disciplinas_handleSuccess(disciplinas) {
       console.log('disciplinas=', disciplinas);

        self.turmaDisciplinas = Aluno_TurmaDisciplinas.query({alunoId: self.aluno.id, turmaId: self.aluno.turma_1.id},
          Aluno_TurmaDisciplinas_handleSuccess,
          Aluno_TurmaDisciplinas_handleFailure);

     }

     function Aluno_Boletim_Disciplinas_handleFailure(reason) {
         console.log('Failure: reason=', reason);
     }

     function Aluno_TurmaDisciplinas_handleSuccess(turmaDisciplinas) {
        self.turmaDisciplinas = turmaDisciplinas;

        console.log('turmaDisciplinas=', turmaDisciplinas);

         for (d=0; d< self.disciplinas.length; d++) {
           var col = [];
           for (i=0; i<3; i++) {
             var cell = {};
             cell.disciplina = self.disciplinas[d];

             cell.icon = 'ion-sad'
             cell.background = 'item-assertive';
             if (cell.disciplina.aprovado == 'aprovado') {
                cell.icon = 'ion-happy';
                cell.background = 'item-positive';
             }

             for (td=0; td<turmaDisciplinas.length; td++) {
                turmaDisciplina = turmaDisciplinas[td];
                console.log('td=', td, ' turmaDisciplina=', turmaDisciplina);
              if (turmaDisciplina.disciplina.id == cell.disciplina.id) {
                cell.turmaDisciplina = turmaDisciplina;
                break;
              }
             }
             col.push(cell);
             d += 1;
             if (d >= self.disciplinas.length) {
               break;
             }
           }
            self.rows.push(col);
         }
         console.log('self.rows=', self.rows);

     }

     function Aluno_TurmaDisciplinas_handleFailure(reason) {
     }

  }


})();
