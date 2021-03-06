var pageController;
window.hostApp = window.location.href.substring(0,window.location.href.lastIndexOf( '/')+1);

var app = (function() {
    return angular.module('MyApp', [
        'ionic',
        'ui.router',
        'ngResource',
        'ngSanitize',
        'custom.controllers',
        'custom.services',
        'datasourcejs',
        'pascalprecht.translate',
        'tmh.dynamicLocale',
        'ui-notification',
        'ngInputDate',
        'ngCordova',
        'ui.calendar',
        'ngCookies'

    ])

    .constant('LOCALES', {
        'locales': {
            'pt_BR': 'Portugues (Brasil)',
            'en_US': 'English'
        },
        'preferredLocale': 'pt_BR'
    })

    .run(function($ionicPlatform) {
        $ionicPlatform.ready(function() {
            // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
            // for form inputs)
            if (window.cordova &&
                window.cordova.plugins.Keyboard) {
                cordova.plugins.Keyboard
                    .hideKeyboardAccessoryBar(true);
                cordova.plugins.Keyboard.disableScroll(true);

            }
            if (window.StatusBar) {
                // org.apache.cordova.statusbar required
                StatusBar.styleDefault();
            }
        });
    })

    .config(function($stateProvider, $urlRouterProvider, $ionicConfigProvider) {
        $ionicConfigProvider.navBar.alignTitle('center')
    })

    .config(function($stateProvider, $urlRouterProvider, NotificationProvider) {
        NotificationProvider.setOptions({
            delay: 5000,
            startTop: 20,
            startRight: 10,
            verticalSpacing: 20,
            horizontalSpacing: 20,
            positionX: 'center',
            positionY: 'top'
        });

        // Set up the states
        $stateProvider

            .state('login', {
            url: "",
            controller: 'LoginController',
            templateUrl: 'views/login.view.html'
        })

        .state('main', {
            url: "/",
            controller: 'LoginController',
            templateUrl: 'views/login.view.html'
        })

        .state('home', {
            url: "/home",
            controller: 'HomeController',
            templateUrl: 'views/logged/home.view.html'
        })

        /*.state('home.app', {
            url: "/app",
            controller: 'HomeController',
            views: {
                'mainContent': {
                    controller: 'HomeAppController',
                    controllerAs: 'vm',
                    templateUrl: 'views/logged/aluno.avisos.view.html'
                }
            }
        })*/

        .state('home.avisos', {
            url: "/avisos",
            controller: 'HomeController',
            views: {
                'mainContent': {
                    controller: 'AlunoAvisosController',
                    controllerAs: 'vm',
                    templateUrl: 'views/logged/aluno.avisos.view.html'
                }
            }
        })

        .state('home.boletim', {
            url: "/boletim",
            controller: 'HomeController',
            views: {
                'mainContent': {
                    controller: 'AlunoBoletimController',
                    controllerAs: 'vm',
                    templateUrl: 'views/logged/aluno.boletim.view.html'
                }
            }
        })

        .state('home.calendarioAulas', {
            url: "/aulas",
            controller: 'HomeController',
            views: {
                'mainContent': {
                    controller: 'AlunoCalendarioAulasController',
                    controllerAs: 'vm',
                    templateUrl: 'views/logged/aluno.calendario.aulas.view.html'
                }
            }
        })

        .state('home.agenda', {
            url: "/agenda",
            controller: 'HomeController',
            views: {
                'mainContent': {
                    controller: 'AgendaController',
                    controllerAs: 'vm',
                    templateUrl: 'views/logged/aluno.agenda.view.html'
                }
            }
        })

        .state('home.pages', {
          url: "/{name:.*}",
          controller: 'PageController',
          views: { 'menuContent': {
	                    templateUrl: function(urlattr) {
	                      console.log('urlattr=', urlattr);
	                      return 'views/'+urlattr.name+'.view.html'; }
	                    }
                  }
        })

        .state('404', {
            url: "/error/404",
            controller: 'PageController',
            templateUrl: function(urlattr) {
                return 'views/error/404.view.html';
            }
        })

        .state('403', {
            url: "/error/403",
            controller: 'PageController',
            templateUrl: function(urlattr) {
                return 'views/error/403.view.html';
            }
        });

        // For any unmatched url, redirect to /state1
        $urlRouterProvider.otherwise("/error/404");
    })

    .config(
        function($translateProvider, tmhDynamicLocaleProvider) {

            $translateProvider.useMissingTranslationHandlerLog();

            $translateProvider.useStaticFilesLoader({
                prefix: 'i18n/locale_',
                suffix: '.json'
            });

            $translateProvider.registerAvailableLanguageKeys([
                'pt_BR', 'en_US'
            ], {
                'en*': 'en_US',
                'pt*': 'pt_BR',
                '*': 'pt_BR'
            });

            var locale = (window.navigator.userLanguage ||
                    window.navigator.language || 'pt_BR')
                .replace('-', '_');

            // Para persistir a linguagem escolhida.
            $translateProvider.useLocalStorage();

            $translateProvider.determinePreferredLanguage();
            //$translateProvider.use(locale);
            $translateProvider.useSanitizeValueStrategy('escaped');

            let localePlugin = 'plugins/angular-i18n/angular-locale_{{locale | lowercase}}.js';
            tmhDynamicLocaleProvider
                .localeLocationPattern(localePlugin);
        })

    .directive('crnValue', ['$parse', function($parse) {
      return {
        restrict: 'A',
        require: '^ngModel',
        link: function(scope, element, attr, ngModel) {
            var evaluatedValue;
            if(attr.value) {
              evaluatedValue = attr.value;
            } else {
              evaluatedValue = $parse(attr.crnValue)(scope);
            }
            element.attr("data-evaluated", JSON.stringify(evaluatedValue));
            element.bind("click", function(event) {
              scope.$apply(function() {
                 ngModel.$setViewValue(evaluatedValue);
              }.bind(element));
            });
        }
      };
    }])

    // General controller
    .controller(
        'PageController', [
            "$scope",
            "$stateParams",
            "$location",
            "$http",
            function($scope, $stateParams, $location, $http) {
                for (var x in app.userEvents)
                    $scope[x] = app.userEvents[x].bind($scope);
pageController = this;
                // save state params into scope
                $scope.params = $stateParams;
                $scope.$http = $http;

                // Query string params
                var queryStringParams = $location.search();
                for (var key in queryStringParams) {
                    if (queryStringParams.hasOwnProperty(key)) {
                        $scope.params[key] = queryStringParams[key];
                    }
                }
            }
        ])

    .run(
        function($rootScope, $state) {
            $rootScope.$on('$stateChangeError', function() {
                if (arguments.length >= 6) {
                    var requestObj = arguments[5];
                    if (requestObj.status === 404 ||
                        requestObj.status === 403) {
                        $state.go(requestObj.status.toString());
                    }
                } else {
                    $state.go('404');
                }
            });
        });

}(window));

app.userEvents = {};
