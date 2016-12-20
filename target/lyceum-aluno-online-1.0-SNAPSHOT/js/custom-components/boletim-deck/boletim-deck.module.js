(function() {
  /*
   * Modulo do componente boletim-deck (boletimDeck)
   */
  angular.module('boletim', ['aol.service', 'boletimDetail'])
    .controller('BoletimDeckController',
     ['Aluno.Boletim.Disciplinas', '$attrs',
        BoletimDeckController]);

  function BoletimDeckController(Aluno_Boletim_Disciplinas, $attrs) {
    var self = this;

    console.log('[BoletimDeckController]:self=', self);

    self.boletim;
    self.rows = [];

    console.log("self.aluno=", self.aluno);
    console.log("self.columns=", self.columns);
    console.log("$attrs=", $attrs);
    self.columns = $attrs.columns;

    self.itemClick = function(cell) {
        console.log('[BoletimDeckController.itemClick] cell:', cell);
        self.itemOpenBoletimDetail(cell);
     }

     self.itemOpenBoletimDetail = function(cell) {
        console.log('[BoletimDeckController.itemOpenBoletimDetail]\t cell=', cell);
        self.onOpenBoletimDetail({cell: cell});
     }

    self.alunoSelecionado = self.aluno.list[self.aluno.selecionado];

      Aluno_Boletim_Disciplinas.query({alunoId: self.alunoSelecionado.id},
        Aluno_Boletim_Disciplinas_handleSuccess,
        Aluno_Boletim_Disciplinas_handleFailure);

     function Aluno_Boletim_Disciplinas_handleSuccess(result) {
        console.log('[Aluno_Boletim_Disciplinas_handleSuccess]\tresult=', result);
        self.boletimDisciplinas = result.content;

        console.log('[Aluno_Boletim_Disciplinas_handleSuccess]\tdisciplinas=', self.disciplinas);

         for (d=0; d< self.boletimDisciplinas.length;) {
           var col = [];
           var columns = self.columns || 3;
           for (i=0; i< columns; i++) {
             var cell = {};
             cell.disciplina = self.boletimDisciplinas[d].disciplina;

             cell.css = angular.copy(config.boletim.cell.css.default);

             if (cell.disciplina.aprovado == 'aprovado') {
                cell.css = angular.copy(config.boletim.cell.css.aprovado);
             }

             cell.css.faltasBadge = config.boletim.cell.css.default.faltasBadge;
             cell.css.faltasIcon  = config.boletim.cell.css.default.faltasIcon;

             if (cell.disciplina.faltas <= 0) {
               cell.css.faltasBadge = config.boletim.cell.css.aprovado.faltasBadge;
               cell.css.faltasIcon  = config.boletim.cell.css.aprovado.faltasIcon;
             }
             console.log('[Aluno_Boletim_Disciplina_handleSuccess]\tcell=', cell);
             cell.turmaDisciplina = self.boletimDisciplinas[d].turmaDisciplina;

             col.push(cell);
             d += 1;
             if (d >= self.boletimDisciplinas.length) {
               break;
             }
           }
            self.rows.push(col);
         }
         console.log('self.rows=', self.rows);

     }

     function Aluno_Boletim_Disciplinas_handleFailure(reason) {
     }

  }


})();
