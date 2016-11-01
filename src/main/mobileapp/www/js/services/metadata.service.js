(function() {
var module = angular.
  module('metadata.service')
  
  .config(function () {
    module.baseUrl = 'api/rest/metadata/';
  })
  
  .factory('Menu', ['$resource',
    function($resource) {
      return $resource(module.baseUrl + 'Menu/:menuId', {}, {
        query: {
          method: 'GET',
          //params: {alunoId: 'alunos'},
          isArray: true
        }
      });
    }
  ])
  
  .factory('MenuTree', ['$resource',
    function($resource) {
      return $resource(module.baseUrl + 'Menu/tree', {}, {
        query: {
          method: 'GET',
          //params: {alunoId: 'alunos'},
          isArray: true
        }
      });
    }
  ])
  
  .factory('Menu.Items', ['$resource',
    function($resource) {
      return $resource(module.baseUrl + 'Menu/:menuId/MenuItems', {}, {
        query: {
          method: 'GET',
          isArray: true
        }
      });
    }
  ]);
})();