/*global cordova, module*/

module.exports = {
    customaction: function (name, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Transparentstatusbar", "customaction", [name]);
    }
};