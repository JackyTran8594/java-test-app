var UserWebApp = angular.module('UserWebApp', [
    'ngMaterial',
    'ngCookies',
    // 'mdColorPicker',
    'mdColorMenu',
    'ngSanitize',
    'ui.bootstrap',
    'checklist-model',
    'ui.select2',
    'pascalprecht.translate',
    'treeGrid',
    'ivh.treeview',
    'ui.bootstrap.datetimepicker',
    'ui.select',

]);


// config app
UserWebApp.config(['$mdIconProvider', function ($mdIconProvider) {
    $mdIconProvider.icon("palette", '/assets/colorPicker/md-color-menu/ic_palette.svg');
}]);


UserWebApp.run(['uiSelect2Config', '$translate', '$rootScope', '$cookies', function (uiSelect2Config, $translate, $rootScope, $cookies) {
    uiSelect2Config.placeholder = $translate.instant('placeholderSelect');

    $rootScope.textBackground;
    
    var siteId = $cookies.get('siteId');

    $rootScope.pickerDisable = true;
    var colorObjectArray = JSON.parse(localStorage.getItem('colorPicker'));

    if (colorObjectArray[0].username == 'admin') {
        $rootScope.pickerDisable = false;
        $rootScope.colorCode = colorObjectArray[0].colorCode;
    } else if (colorObjectArray[0].username !== 'admin' && colorObjectArray[0].siteId == siteId) {
        $rootScope.colorCode = colorObjectArray[0].colorCode;
    }
    // if()

    // colorObjectArray.forEach(item => {
    //     if (item.username == objLogin.username && item.siteId == objLogin.siteId) {
    //         $rootScope.colorCode = item.colorCode;
    //     }
    // });



    $('.select2').select2({
        placeholder: $translate.instant('placeholderSelect')
    });

    $('.select2clear').select2({
        placeholder: $translate.instant('placeholderSelect'),
        allowClear: true
    });

    // Config message validate form
    jQuery.extend(jQuery.validator.messages, {
        notExisted: $translate.instant('validatorExisted'),
        required: $translate.instant('validatorRequired'),
        email: $translate.instant('validatorEmail'),
        url: $translate.instant('validatorUrl'),
        date: $translate.instant('validatorDate'),
        dateISO: $translate.instant('validatorDateISO'),
        number: $translate.instant('validatorNumber'),
        digits: $translate.instant('validatorDigits'),
        equalTo: $translate.instant('validatorEqualTo'),
        accept: $translate.instant('validatorAccept'),
        maxlength: jQuery.validator.format($translate.instant('validatorMaxlength')),
        minlength: jQuery.validator.format($translate.instant('validatorMinlength')),
        rangelength: jQuery.validator.format($translate.instant('validatorRangelength')),
        range: jQuery.validator.format($translate.instant('validatorRange')),
        max: jQuery.validator.format($translate.instant('validatorMax')),
        min: jQuery.validator.format($translate.instant('validatorMin')),
    });
}]);