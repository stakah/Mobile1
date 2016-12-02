  angular.module('custom.controllers')

  .controller('AlunoBoletimController', [
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
      'SessionData',
      function($scope, $http, $rootScope, $state, $timeout, $translate, Notification, $ionicHistory, $cordovaVibration, $ionicModal, SessionData) {
          var vm = this;
          vm.cell = {};
          vm.chart = {};
          vm.chart.options = {};
          vm.chart.options.lengend = {};
          vm.sessionData = SessionData;
          vm.aluno = vm.sessionData.aluno;

          console.log('[AlunoBoletimController]\tvm=', vm);

          $ionicModal.fromTemplateUrl('views/logged/_boletim.detail.view.html', {
            scope: $scope,
            animation: 'slide-in-up'
          }).then(function(modal) {
            vm.modalBoletim = modal;
          });

          var chartGenerateLabels  = function(chart) {
            var labels = [];
            external_chart = chart;

            for (i=0; i<chart.data.labels.length; i++) {
              var L = chart.data.labels[i];
              var N = vm.chart.data[i];
              var txt = L + ' (' + N + ')';
              labels.push({
                text: txt,
                fillStyle:   Chart.defaults.global.colors[i],
                strokeStyle: Chart.defaults.global.colors[i]
              });
            }
            console.log('chartGenerateLabels] chart=', chart);
            return labels;
          };

          vm.openBoletimDetail2 = function(cell) {
            vm.cell = cell;

            vm.chart.options = {
              title: {
                display: true,
                text: vm.cell.disciplina.faltas + ' falta(s)'
              },

              legend: {
                display: true,
                position: 'bottom',
                labels: {
                  generateLabels: chartGenerateLabels
                }
              }
            };

            Chart.defaults.global.colors =
              ['#085970', '#7DAA07', '#B40808', '#46BFBD', '#FDB45C', '#949FB1', '#4D5360'];

            vm.chart.labels = ["Aulas Assistidas", "Aulas Restantes", "Faltas" ];
            var aulasAssistidas = vm.cell.disciplina.aulas_ministradas - vm.cell.disciplina.faltas;
            var aulasRestantes = vm.cell.disciplina.aulas_previstas -
              (vm.cell.disciplina.aulas_ministradas);

            vm.chart.aulas = [vm.cell.disciplina.aulas_previstas, vm.cell.disciplina.aulas_ministradas, vm.cell.disciplina.faltas];
            vm.chart.data = [aulasAssistidas, aulasRestantes, vm.cell.disciplina.faltas];

//            vm.chart.data = {
//              datasets: [
//                {
//                  data: vm.chart.data,
//                  backgroundColor: backgroundColors
//                }
//              ]
//            };

            console.log('[AlunoBoletimController.openBoletimDetail2]\tvm=', vm);
            vm.modalBoletim.show();
          };

          $scope.closeBoletimDetail2 = function() {
            console.log('[AlunoBoletimController]\tvm.closeBoletimDetail2()');
            vm.modalBoletim.hide();
          }

    } ]);
