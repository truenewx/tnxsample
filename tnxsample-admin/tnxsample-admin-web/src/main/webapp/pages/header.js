// header.js
define([], function() {
    return function(app) {
        var container = $("header")[0];
        new app.Vue({
            el: container,
            data: {},
            methods: {
                toUpdateInfo: function() {
                    var url = app.context + "/mine/info.win";
                    app.open(url, function(yes) {
                    });
                }
            }
        });
    }
});
