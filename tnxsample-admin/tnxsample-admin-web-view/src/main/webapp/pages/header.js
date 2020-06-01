// header.js
define(["app"], function(app) {
    return function(container) {
        new Vue({
            el: container,
            data: {},
            methods: {
                toUpdateInfo: function() {
                    tnx.open(app.context + "/mine/info.win");
                },
                toUpdatePassword: function() {
                    tnx.open(app.context + "/mine/password.win");
                }
            }
        });
    }
});
