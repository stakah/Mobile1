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
          params: {page: 0, size: 1000},
          //isArray: true
        }
      });
    }
  ])

  .factory('Aluno.Boletim.Id', ['$resource',
    function($resource) {
      return $resource('api/rest/alunos/:alunoId/boletim/id', {}, {
        query: {
          method: 'GET',
          params: {page: 0, size: 1000},
          //isArray: true
        }
      });
    }
  ])

  .factory('Aluno.TurmaDisciplinas', ['$resource',
    function($resource) {
      return $resource('/api/rest/alunos/:alunoId/turmas/:turmaId/turmaDisciplinas', {}, {
        query: {
          method: 'GET',
          params: {page: 0, size: 1000},
          //isArray: true
        }
      });
    }
  ])

.factory('Aluno.HorariosAula', ['$resource',
    function($resource) {
      return $resource('/api/rest/alunos/:alunoId/HorariosAula', {}, {
        query: {
          method: 'GET',
          params: {page: 0, size: 1000},
          //isArray: true
        }
      });
    }
  ])

//'/api/rest/alunos/:alunoId/boletim/:boletimId/disciplinas'
  .factory('Aluno.Boletim.Disciplinas', ['$resource',
    function($resource) {
      return $resource('/api/rest/alunos/:alunoId/BoletimDisciplinas', {}, {
        query: {
          method: 'GET',
          params: {page: 0, size: 1000},
          //isArray: true
        }
      });
    }
  ])

  .factory('Aluno.Calendario.Aulas', ['$resource',
    function($resource) {
      return $resource('/api/rest/alunos/:alunoId/calendario/:calendarioId/aulas', {}, {
        query: {
          method: 'GET',
          params: {page: 0, size: 1000},
          //isArray: true
        }
      });
    }
  ])

;
