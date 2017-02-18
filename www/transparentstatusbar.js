/*global cordova, module*/

module.exports = {
    enable: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Transparentstatusbar", "enable", []);
    }
};