(function($app) {
  angular.module('custom.controllers', []);
  app.controller('LoginController', [ 
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
          $state.go("home.app");
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

      } ]);

  app.controller('HomeController', [ 
      '$scope', 
      '$http', 
      '$rootScope', 
      '$state',
      '$timeout',
      '$translate', 
      'Notification', 
      '$ionicHistory',
      '$cordovaVibration',
      '$ionicModal',
      function($scope, $http, $rootScope, $state, $timeout, $translate, Notification, $ionicHistory, $cordovaVibration, $ionicModal) {

        $ionicModal.fromTemplateUrl('views/logged/_changepassword.view.html', {
          scope: $scope,
          animation: 'slide-in-up'
        }).then(function(modal) {
          $scope.modal = modal;
        });
        
        $scope.openChangePassword = function() {
          $scope.modal.show();
        };

        $scope.closeChangePassword = function() {
          $scope.modal.hide();
        };

        $scope.shouldShowDelete = false;
        $scope.shouldShowReorder = false;
        $scope.listCanSwipe = true

        $scope.message = {};

        $scope.selecionado = {
          valor : 1
        }

        $scope.vibrate = function() {
           $cordovaVibration.vibrate(1000);
        };
        
        // When access home page we have to check
        // if the user is authenticated and the userData
        // was saved on the browser's sessionStorage
        $rootScope.session = (sessionStorage._u) ? JSON.parse(sessionStorage._u) : null;
        if(!$rootScope.session) {
          // If there isn't a user registered on the sessionStorage
          // we must send back to login page
          // TODO - REVISAR login oauth2
          // $state.go("login");
        }

        // Menu
        $scope.groups = [];

        /*
         * if given group is the selected group, deselect it else, select the given group
         */
        $scope.toggleGroup = function(group) {
          if($scope.isGroupShown(group)) {
            $scope.shownGroup = null;
          }
          else {
            $scope.shownGroup = group;
          }
        };

        $scope.isGroupShown = function(group) {
          return $scope.shownGroup === group;
        };

        $rootScope.logout = function logout() {

          $http({
            method : 'GET',
            url : 'logout',
          }).then(handleSuccess, handleError)

          $rootScope.session = {};
          $state.go("login");
    			$timeout(function() {
    			  $state.reload();
    			},500);
        }

        function handleSuccess(data) {
          // Before redirect to login page we
          // have to clean the user data from the
          // session storage
          if(typeof (Storage) !== "undefined") {
            // save the user data on localStorage
            sessionStorage.removeItem("_u");
          }
          else {
            // It's not working with sessionStorage
          }

          $state.go("login");
        }

        function handleError(error) {
          $rootScope.session.error = error;
        }

        $scope.changePassword = function() {

          var user = {
            oldPassword : oldPassword.value,
            newPassword : newPassword.value,
            newPasswordConfirmation : newPasswordConfirmation.value
          };

          $http({
            method : 'POST',
            url : 'changePassword',
            data : $.param(user),
            headers : {
              'Content-Type' : 'application/x-www-form-urlencoded'
            }
          }).success(changeSuccess).error(changeError);

          function changeSuccess(data, status, headers, config) {
            Notification.info($translate.instant('Home.view.passwordChanged'));
            cleanPasswordFields();
          }

          function changeError(data, status, headers, config) {
            var error = status >= 401 ? $translate.instant('Home.view.InvalidPassword') : data;
            Notification.error(error);
          }

          function cleanPasswordFields() {
            oldPassword.value = "";
            newPassword.value = "";
            newPasswordConfirmation.value = "";
            $scope.closeChangePassword();
          }
        };

      } ]);
}(app));
