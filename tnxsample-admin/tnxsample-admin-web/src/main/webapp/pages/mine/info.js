// mine/info.js
define(["app"], function(app) {
    return function(container) {
        new Vue({
            el: container,
            data: {
                url: "/api/self/mine/info",
                manager: {},
                meta: {},
            },
            created: function() {
                tnx.showLoading();
                var _this = this;
                app.rpc.get(this.url, function(manager) {
                    _this.manager = manager;
                    tnx.hideLoading();
                });
                app.rpc.getMeta(this.url, function(meta) {
                    _this.meta = meta;
                });
            },
            methods: {
                submit: function() {
                    var _this = this;
                    app.rpc.post(this.url, this.manager, function() {
                        $("#managerDropdown").text(_this.manager.fullName);
                        tnx.toast("保存成功", function() {
                            container.close();
                        });
                    });
                },
                cancel: function() {
                    container.close();
                }
            }
        });
    }
});