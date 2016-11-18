  (function() {
  angular.module('custom.controllers')
  .controller('LoginController', [
    '$scope',
    '$http',
    '$location',
    '$rootScope',
    '$window',
    '$state',
    '$translate',
    'Notification',
    '$ionicLoading',
    '$timeout',
    '$stateParams',
    function($scope, $http, $location, $rootScope, $window, $state, $translate, Notification, $ionicLoading, $timeout, $stateParams) {

        $scope.user = {};
        $scope.message = {};

        $scope.profile = {};

        $scope.login = function() {

          $ionicLoading.show({
            content : 'Loading',
            animation : 'fade-in',
            showBackdrop : true,
            maxWidth : 200,
            showDelay : 0
          });

          $scope.message.error = undefined;

          if(window.hostApp) {
            $http({
              method : 'POST',
              url : window.hostApp + 'auth',
              data : serializeData($scope.user),
              headers : {
                'Content-Type' : 'application/x-www-form-urlencoded'
              }
            }).success(handleSuccess).error(handleError);

          }
          else {
            $ionicLoading.hide();
            Notification.error("HostApp is required!");
          }

        }

        $rootScope.infiniteReached = function() {
          //
        }

        function handleSuccess(data, status, headers, config) {

          // Store data response on session storage
          // The session storage will be cleaned when the browser window is closed
          if(typeof (Storage) !== "undefined") {
            // save the user data on localStorage
            sessionStorage.setItem("_u", JSON.stringify(data));
          }
          else {
            // Sorry! No Web Storage support.
            // The home page may not work if it depends
            // on the logged user data
          }

          // Redirect to home page
          $state.go("home.avisos");
          window.location.reload();

          $timeout(function() {
            $ionicLoading.hide();
          },500);
        }

        function handleError(data, status, headers, config) {
          var error = status == 401 ? $translate.instant('Login.view.invalidPassword') : data;

          $ionicLoading.hide();
          Notification.error(error);
        }

        function serializeData(data) {
          // If this is not an object, defer to native stringification.
          if(!angular.isObject(data)) {
            return ((data === null) ? "" : data.toString());
          }

          var buffer = [];

          // Serialize each key in the object.
          for( var name in data) {
            if(!data.hasOwnProperty(name)) {
              continue;
            }

            var value = data[name];

            buffer.push(encodeURIComponent(name) + "=" + encodeURIComponent((value === null) ? "" : value));
          }

          // Serialize the buffer and clean it up for transportation.
          var source = buffer.join("&").replace(/%20/g, "+");
          return (source);
        }

        $scope.selectProfile = function (profile) {
            let classPositive    = 'button button-positive';
            let classOutline     = 'button button-positive button-outline';
            let loginAluno       = 'Login.view.AlunoUsername';
            let loginResponsavel = 'Login.view.ResponsavelUsername';

            $scope.loginAlunoButton       = 'Login.view.AlunoButtonLabel';
            $scope.loginResponsavelButton = 'Login.view.ResponsavelButtonLabel';

          if (profile == 'aluno') {
            $scope.profile = {};

            $scope.profile.name = 'aluno';
            $scope.buttonClassAluno = classPositive;
            $scope.buttonClassResponsavel = classOutline;
            $scope.loginUsername = loginAluno;
          }

          if (profile == 'responsavel') {
            $scope.profile = {};

            $scope.profile.name = 'responsavel';
            $scope.buttonClassAluno = classOutline;
            $scope.buttonClassResponsavel = classPositive;
            $scope.loginUsername = loginResponsavel;
          }
        }


        $scope.selectProfile('aluno');

      } ]);

})(app);
