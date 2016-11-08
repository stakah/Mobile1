  angular.module('custom.controllers')
  .controller('HomeController', [ 
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

      /* ngResource services */
      'MenuTree',

      function($scope, $http, $rootScope, $state, $timeout, $translate, Notification, $ionicHistory, $cordovaVibration, $ionicModal, menuTree) {
        
        console.log("HomeController");

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
          $state.go('login');
        }

        // Menu
        $scope.groups = [];
        $scope.groups = menuTree.get();

        $scope.groupSettings = "Home.view.ajustes";
        
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
