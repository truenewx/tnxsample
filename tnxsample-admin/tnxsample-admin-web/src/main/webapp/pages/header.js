// header.js
define([], function() {
    return function(app) {
        var container = $("header")[0];
        new Vue({
            el: container,
            data: {},
            methods: {
                toUpdateInfo: function() {
                    var url = app.context + "/mine/info.win";
                    tnx.open(url, function(yes) {
                        if (yes) {

                        }
                    }, {
                        width: "sm"
                    });
                }
            }
        });
    }
});
