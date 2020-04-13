// mine/info.js
define(["app", "validator"], function(app) {
    return function(container) {
        new Vue({
            el: container,
            data: {
                url: "/api/self/mine/info",
                model: {},
                meta: {},
                vr: {},
            },
            created: function() {
                tnx.showLoading();
                var _this = this;
                app.rpc.get(this.url, function(model) {
                    _this.model = model;
                    tnx.hideLoading();
                });
                app.rpc.getMeta(this.url, function(meta) {
                    _this.meta = meta;
                    _this.vr = _this.createValidator(_this.meta, true);
                });
            },
            methods: {
                submit: function() {
                    var _this = this;
                    app.rpc.post(this.url, this.model, function() {
                        $("#managerDropdown").text(_this.model.fullName);
                        tnx.toast("保存成功", 1000, function() {
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