// mine/info.js
define(["app", "validator"], function(app, Validator) {
    return function(container) {
        new Vue({
            el: container,
            data: {
                url: "/mine/info",
                model: {},
                v: new Validator(),
            },
            created: function() {
                tnx.showLoading();
                var _this = this;
                app.rpc.get(this.url, function(model) {
                    _this.model = model;
                    _this.v.setModel(model);
                    tnx.hideLoading();
                });
                app.rpc.getMeta(this.url, function(meta) {
                    _this.v.setMeta(meta);
                });
            },
            methods: {
                submit: function() {
                    if (this.v.validate()) {
                        var _this = this;
                        app.rpc.post(this.url, this.model, function() {
                            $("#managerDropdown").text(_this.model.fullName);
                            tnx.toast("保存成功", 1000, function() {
                                container.close();
                            });
                        });
                    }
                },
                cancel: function() {
                    container.close();
                }
            }
        });
    }
});