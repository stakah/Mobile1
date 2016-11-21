angular.
  module('aol.service')
  .factory('Aluno', ['$resource',
    function($resource) {
      return $resource('api/rest/alunos/:alunoId', {}, {
        query: {
          method: 'GET',
          //params: {alunoId: 'alunos'},
          isArray: true
        }
      });
    }
  ])

  .factory('Aluno.User', ['$resource',
    function($resource) {
      return $resource('api/rest/alunos/user/:userId');
    }
  ])

  .factory('Aluno.Boletim', ['$resource',
    function($resource) {
      return $resource('api/rest/alunos/:alunoId/boletim', {}, {
        query: {
          method: 'GET',
          //params: {alunoId: 'alunos'},
          isArray: true
        }
      });
    }
  ])

  .factory('Aluno.TurmaDisciplinas', ['$resource',
    function($resource) {
      return $resource('/api/rest/alunos/:alunoId/turmas/:turmaId/turmaDisciplinas', {}, {
        query: {
          method: 'GET',
          //params: {alunoId: 'alunos'},
          isArray: true
        }
      });
    }
  ])

  .factory('Aluno.Boletim.Disciplinas', ['$resource',
    function($resource) {
      return $resource('/api/rest/alunos/:alunoId/boletim/:boletimId/disciplinas', {}, {
        query: {
          method: 'GET',
          //params: {alunoId: 'alunos'},
          isArray: true
        }
      });
    }
  ])


;
