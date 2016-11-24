(function() {
  /*
   * Modulo do componente boletim-deck (boletimDeck)
   */
  angular.module('boletim', ['aol.service', 'boletimDetail'])
    .controller('BoletimDeckController',
     ['Aluno', 'Aluno.User', 'Aluno.Boletim', 'Aluno.Boletim.Disciplinas', 'Aluno.TurmaDisciplinas',
      '$attrs',
        BoletimDeckController]);

  function BoletimDeckController(Aluno, Aluno_User, Aluno_Boletim, Aluno_Boletim_Disciplinas, Aluno_TurmaDisciplinas,
    $attrs) {
    var self = this;
    //this.aluno = {nome:"Claudia Cristina M. Rodrigues", grupo:"2o. Ano Ensino Médio", matricula: "144632", turma: "B"};
    var User = angular.fromJson(sessionStorage.getItem('_u'));
    external_User = User;
    console.log('[BoletimDeckController]:self=', self);
    console.log('[BoletimDeckController]:User=', User);
    console.log('User.id=', User.id);

    self.boletim;
    self.rows = [];

    console.log("self.aluno=", self.aluno);
    console.log("self.columns=", self.columns);
    console.log("$attrs=", $attrs);
    self.columns = $attrs.columns;

    self.aluno = Aluno_User.get({userId: User.id}, Aluno_User_handleSuccess, Aluno_User_handleFailure);

    self.itemClick = function(cell) {
        console.log('[BoletimDeckController.itemClick] cell:', cell);
        self.itemOpenBoletimDetail(cell);
     }

     self.itemOpenBoletimDetail = function(cell) {
        console.log('[BoletimDeckController.itemOpenBoletimDetail]\t cell=', cell);
        self.onOpenBoletimDetail({cell: cell});
     }

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

         for (d=0; d< self.disciplinas.length;) {
           var col = [];
           var columns = self.columns || 3;
           for (i=0; i< columns; i++) {
             var cell = {};
             cell.disciplina = self.disciplinas[d];

             cell.icon = 'fa fa-thumbs-o-down'
             cell.background = 'item-assertive';
             if (cell.disciplina.aprovado == 'aprovado') {
                cell.icon = 'fa fa-thumbs-o-up';
                cell.background = 'item-positive';
             }

             cell.calendarColor = 'item-normal';
             if (cell.disciplina.faltas > 0) {
               cell.calendarColor = 'placeholder-icon item-assertive';
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
