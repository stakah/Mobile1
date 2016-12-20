(function() {
  /*
   * Modulo do componente aluno-card (alunoCard)
   */
  angular.module('alunoCard', ['aol.service'])
    .controller('AlunoCardController',
     [
        AlunoCardController]);

  function AlunoCardController() {
    var self = this;

    self.alunoSelecionado = self.aluno.list[self.aluno.selecionado];

    console.log('[AlunoCardController]\tself=', self);
  }
})();
