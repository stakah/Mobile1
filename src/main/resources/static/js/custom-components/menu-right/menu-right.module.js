(function () {
  /*
   * Modulo do componenet avisos-list (avisosList)
   */
  angular
    .module('menu')
    .controller('MenuRightController', [
      '$ionicSideMenuDelegate',
      MenuRightController]);

  function MenuRightController($ionicSideMenuDelegate) {
      var ctrl = this;

      console.log('[MenuRightController]\tctrl=', ctrl);

      ctrl.closeMenuRight = function(isOpen) {
        $ionicSideMenuDelegate.toggleRight(isOpen);
      };

      ctrl.dayClick = function( date, jsEvent, view ) {
        console.log('[dayClick]\tdate=', date, 'jsEvent=', jsEvent, 'view=', view);
        let OPEN = false;
        ctrl.closeMenuRight(OPEN);
      };

      ctrl.alertEventOnClick = function() {
        console.log('[alertEventOnClick]');
        let OPEN = true;
        ctrl.closeMenuRight(OPEN);
      };
      ctrl.alertOnDrop = function() {};
      ctrl.alertOnResize = function() {};

      ctrl.uiConfig = {
        'calendar' : {
          editable: true,
          height: 'auto',
          header:{
            left: 'month, agendaWeek, agendaDay ',
            center: 'title',
            right: 'today prev,next'
          },
          theme: true,
          lang: 'pt-br',

          dayClick: ctrl.dayClick,
          eventClick: ctrl.alertEventOnClick,
          eventDrop: ctrl.alertOnDrop,
          eventResize: ctrl.alertOnResize
        }
      };


   }
})();
