(function ($app) {

  
  /**
   * Em todo elemento que possuir o atibuto as-date será 
   * aplicado o componente Datetimepicker (http://eonasdan.github.io/bootstrap-datetimepicker/)
   * 
   * O componente se adequa de acordo com o formato, definido através do atributo format
   * espeficado no elemento.
   * Para data simples use format="DD/MMM/YYYY", para data e hora use format="DD/MM/YYYY HH:mm:ss"
   * 
   * @see http://eonasdan.github.io/bootstrap-datetimepicker/
   */

  
  app.directive('pwCheck', [function () { 'use strict';
    return {
      require: 'ngModel',
      link: function (scope, elem, attrs, ctrl) {
      var firstPassword = '#' + attrs.pwCheck;
      elem.add(firstPassword).on('keyup', function () {
        scope.$apply(function () {
        var v = elem.val()===$(firstPassword).val();
        ctrl.$setValidity('pwmatch', v);
        });
      });
      }
    }
  }])
  
  
  
} (app));