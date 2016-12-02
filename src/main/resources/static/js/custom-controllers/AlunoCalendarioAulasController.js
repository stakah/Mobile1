  angular.module('custom.controllers')
  .controller('AlunoCalendarioAulasController', [
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
      'Aluno.HorariosAula',
      function($scope, $http, $rootScope, $state, $timeout, $translate, Notification, $ionicHistory, $cordovaVibration, $ionicModal, SessionData, Aluno_HorariosAula) {
          var vm = this;

          vm.sessionData = SessionData;
          vm.aluno = vm.sessionData.aluno;
          var alunoSelecionado = vm.aluno.list[vm.aluno.selecionado];
          vm.tableData = {
            "ano": {
              "list": {},
              "selecionado": 0
            }
          };

          console.log('[AlunoCalendarioAulasController]');

          vm.horariosAula = Aluno_HorariosAula.query({alunoId: alunoSelecionado.id},
            Aluno_HorariosAula_handleSuccess, Aluno_HorariosAula_handleFailure);

          function Aluno_HorariosAula_handleSuccess(data) {
            console.log('data=', data);
            vm.horariosAula = data._embedded.horarioAulas;

            for (i=0; i<vm.horariosAula.length; i++) {
              var h = vm.horariosAula[i];
              if (typeof(vm.tableData.ano.list[h.ano]) == 'undefined') {
                vm.tableData.ano.list[h.ano] = {
                  "semestre" : {
                    "list" : {},
                    "selecionado" : 0
                  }
                };
              }

              if (typeof(vm.tableData.ano.list[h.ano].semestre.list[h.semestre]) == 'undefined') {
                vm.tableData.ano.list[h.ano].semestre.list[h.semestre] = {
                  "diaSemana" : {
                    "list" : {}
                  }
                };
              }

              if (typeof(vm.tableData.ano.list[h.ano].semestre.list[h.semestre].diaSemana.list[h.diaSemana]) == 'undefined') {
                vm.tableData.ano.list[h.ano].semestre.list[h.semestre].diaSemana.list[h.diaSemana] =
                {
                  "list" : []
                };
              }
              vm.tableData.ano.list[h.ano].semestre.list[h.semestre].diaSemana.list[h.diaSemana].list.push({
                  "horaIni" : h.horaIni,
                  "nomeDisciplina" : h.nomeDisciplina,
                  "icone" : h.icone
                });

            }

            // Seleciona o primeiro ano da lista
            vm.tableData.selectAno(vm.tableData.getAnos()[0]);

            // Seleciona o primeiro semestre do ano selecionado
            vm.tableData.selectSemestre(vm.tableData.getSemestres()[0]);


          }

          function Aluno_HorariosAula_handleFailure(reason) {
          }

          vm.tableData.getAnos = function() {
            var anos = Object.keys(this.ano.list);
            return anos;
          }

          vm.tableData.getSemestres = function() {
            var sems = [];
            let anos = this.getAnos();
            //console.log('[getSemestres]\tvm=', vm, 'anos=', anos, 'this=', this);
            if (typeof(this.ano.list[this.ano.selecionado]) !== 'undefined') {
              sems = Object.keys(this.ano.list[this.ano.selecionado].semestre.list);
            }
            return sems;
          }

          vm.tableData.getDiasSemana = function() {
            var dias = [];
            var ano = this.ano;

            if (typeof(this.ano.list[ano.selecionado]) !== 'undefined') {
              var sem = this.ano.list[ano.selecionado].semestre;
              var dia = sem.list[sem.selecionado];
              if (typeof(sem.list[sem.selecionado]) !== 'undefined') {
                dias = Object.keys(dia.diaSemana.list);
              }
            }
            //console.log('[getDiasSemana]\tdias=', dias);
            return dias;
          }

          vm.tableData.selectAno = function (ano) {
            vm.tableData.ano.selecionado = ano;
            //console.log('[selectAno]\tano=', ano);
          }

          vm.tableData.selectSemestre = function (semestre) {
            var ano = vm.tableData.ano;
            var sem = vm.tableData.ano.list[ano.selecionado].semestre;
            sem.selecionado = semestre;
            //console.log('[selectSemestre]\tsemestre=', semestre);
          }

          vm.tableData.getNomeDiaSemana = function (dia) {
            var nomes = ['domingo', 'segunda-feira', 'ter&ccedil;a-feira', 'quarta-feira', 'quinta-feira', 'sexta-feira', 's&aacute;bado'];

            var nome = '';
            if (dia >=0 && dia <=6) {
              nome = nomes[dia];
            }
            //console.log('[getNomeDiaSemana]\tdia=', dia, '\tnome=', nome);
            return nome;
          }

          vm.tableData.getDiaSemana = function (dia) {
            var diaSemana = {};
            var ano = this.ano;
            var sem = this.ano.list[ano.selecionado];
            if (typeof(sem) !== 'undefined') {
              diaSemana = sem.semestre.list[sem.semestre.selecionado].diaSemana.list[dia];
            }
            console.log('[getDiaSemana]\tdiaSemana=', diaSemana);
            return diaSemana;
          }

          vm.tableData.getDisciplinas = function(dia) {
            var ds = [];
            var diaSemana = this.getDiaSemana(dia);
            if (typeof(diaSemana) !== 'undefined') {
              ds = diaSemana.list;
            }
            console.log('[getDisciplinas]\tdia=', dia, 'ds=', ds, 'diaSemana=', diaSemana);
            return ds;
          }


          $ionicModal.fromTemplateUrl('views/logged/_aluno.aviso.detail.view.html', {
            scope: $scope,
            animation: 'slide-in-up'
          }).then(function(modal) {
            vm.modalAviso = modal;
          });

          vm.openAvisoDetail2 = function(aviso) {
            vm.avisoItem = aviso;
            console.log('[HomeAppController.openAvisoDetail]\tvm=', vm);
            console.log('[HomeAppController.openAvisoDetail]\taviso=', aviso);
            vm.modalAviso.show();
          };

          $scope.closeAvisoDetail2 = function() {
            console.log('[HomeAppController]\tvm.closeAvisoDetail2()');
            vm.modalAviso.hide();
          }

          console.log('[AlunoCalendarioAulasController]\tvm=', vm);
    } ]);
