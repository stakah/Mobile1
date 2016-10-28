angular.
  module('aol.service').
  factory('Aluno', ['$resource',
    function($resource) {
      return $resource('api/rest/aol/Aluno/:alunoId', {}, {
        query: {
          method: 'GET',
          //params: {alunoId: 'alunos'},
          isArray: false
        }
      });
    }
  ]);