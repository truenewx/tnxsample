// mine/info.js
define(["app", "validator"], function(app) {
    return function(container) {
        new Vue({
            el: container,
            data: {
                url: "/api/self/mine/info",
                model: {},
                meta: {},
                validator: {},
                valid: {},
                invalid: {},
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
                });
                this.validator = this.createValidator();
            },
            methods: {
                submit: function() {
                    if (this.validator.validate()) {
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