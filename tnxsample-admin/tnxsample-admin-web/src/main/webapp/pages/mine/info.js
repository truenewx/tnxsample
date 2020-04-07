// mine/info.js
define(["app"], function(app) {
    return function(container) {
        new Vue({
            el: container,
            data: {
                manager: {},
                meta: {},
            },
            created: function() {
                tnx.showLoading();
                var _this = this;
                app.rpc.get("/api/self/mine/info", function(manager) {
                    _this.manager = manager;
                    tnx.hideLoading();
                });
                app.rpc.getMeta("/api/self/mine/info", function(meta) {
                    _this.meta = meta;
                });
            },
            methods: {}
        });
    }
});