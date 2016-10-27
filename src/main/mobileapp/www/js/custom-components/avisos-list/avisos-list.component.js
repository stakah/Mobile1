angular.module('avisosList')
.component('avisosList', {
  templateUrl: 'js/custom-components/avisos-list/avisos-list.component.html',
  controller: function AvisosListController() {
    // Lista de avisos & ocorrencias
    this.list = [];
    
    this.list.push({title:"Próxima Aula", content:"10h00 - Matemática<br>Sala: 5B", icon:"icon ion-cube placeholder-icon", url: "#"});
    this.list.push({title:"Aviso:", content:"Matrículas abertas para o próximo semestre.<br>Informações na secretaria.", icon:"icon ion-person-stalker placeholder-icon", url:"#"});
    
    console.log('list=', this.list);
  }
});