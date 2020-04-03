// mine/info.js
define(["app"], function(app) {
    return function(container) {
        new Vue({
            el: container,
            data: {
                manager: {},
            },
            created: function() {
                var _this = this;
                app.rpc.get("/mine/info/detail", function(manager) {
                    _this.manager = manager;
                });
            },
            methods: {}
        });
    }
});