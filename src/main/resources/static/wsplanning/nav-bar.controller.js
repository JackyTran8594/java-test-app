var navBarController = angular.module('mdColorMenu').controller('navBarController', ['$scope', '$rootScope', 'mdPickerColors', function ($scope, $rootScope, mdPickerColors) {

    mdPickerColors.setFavorites([
        '#5d5d5c',
        '#266478',
        '#86ceca',
        '#3b8985',
        '#8cbe9d',
        '#347849',
        '#bfdc80',
        '#6e8d25',
        '#bcc596',
        '#6d7748'
    ]);

    var username = angular.element('#username').val();
    console.log(username);

    var vm = this;

    vm.showTooltips = vm.showTooltips || false;
    vm.openMenu = openMenu;
    vm.colors = mdPickerColors.colors;
    vm.selectColor = selectColor;
    vm.favorites = mdPickerColors.getFavorites();

    function openMenu($mdOpenMenu, $event) {
      $mdOpenMenu($event);
    }

    function selectColor(color) {
      vm.color = color;
      console.log(color);
    }

    // $scope.color = mdPickerColors
 
    var color = angular.element($('md-color-menu')).val();
    console.log(color);
    $scope.color = mdPickerColors.getColor('#D32F2F');
    console.log($scope.color);
    $scope.openColorPicker = function (ev) {
        
      
        mdPickerColors.openColorPicker(ev, function (color) {

            console.log(color);
        });
    }
}]);