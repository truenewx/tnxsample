// mine/info.js
define(["app"], function(app) {
    return function(container) {
        new Vue({
            el: container,
            data: {
                manager: {},
            },
            created: function() {
                app.showLoading();
                var _this = this;
                app.rpc.get("/api/mine/info", function(manager) {
                    _this.manager = manager;
                    app.hideLoading();
                });
            },
            methods: {}
        });
    }
});