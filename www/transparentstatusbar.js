/*global cordova, module*/

module.exports = {
    init: function (callback) {
        cordova.exec(function(result) {
            if(result == 1) {
                document.body.className += ' ' + 'has-transparent-statusbar';
            }
            if(callback !== undefined) {
                callback(result);
            }
        }, function(error) {
            console.log(error);
            if(callback !== undefined) {
                callback(-1);
            }
        }, "Transparentstatusbar", "isTransparent", []);
    }
};