var external_scope;

(function() {
angular.module('login.service', ['aol.service'])
  .factory('AlunoFromUser', ['$rootScope', 'Aluno.User',
  function($rootScope, Aluno_User) {
    return function(){
      var User = angular.fromJson(sessionStorage.getItem('_u'));
      external_User = User;
      if (!User) return;

      console.log('[AlunoFromUser]:User=', User);
      if (User) console.log('User.id=', User.id);

      var aluno = Aluno_User.get({userId: User.id},
        function handleSuccess(aluno) {
          console.log('[Aluno_User_handleSuccess]\taluno=', aluno);
          var a = {
            'list': [aluno],
            'selecionado': 0
          };
          sessionStorage.setItem("_a", JSON.stringify(a));

        },
        function handleFailure() {
          console.log('[Aluno_User_handleFailure]\targuments=', arguments);
        });
      };

  }])

  .factory('SessionData', [function(){
    var aluno = angular.fromJson(sessionStorage.getItem('_a'));
    var user = angular.fromJson(sessionStorage.getItem('_u'));

    var data = {
      "aluno": aluno,
      "user": user
    };

    return data;
  }])
;
})();
