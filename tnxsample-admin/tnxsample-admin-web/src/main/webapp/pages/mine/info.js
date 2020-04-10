// mine/info.js
define(["app"], function(app) {
    return function(container) {
        new Vue({
            el: container,
            data: {
                url: "/api/self/mine/info",
                model: {},
            },
            validations: {
                model: {
                    fullName: {
                        required: required()
                    }
                }
            },
            created: function() {
                tnx.showLoading();
                var _this = this;
                app.rpc.get(this.url, function(model) {
                    _this.model = model;
                    tnx.hideLoading();
                });
                app.rpc.getMeta(this.url, function(meta) {
                    $.extend(_this.$v.model, Vuelidate.transfer(meta));
                });
            },
            methods: {
                submit: function() {
                    var _this = this;
                    app.rpc.post(this.url, this.model, function() {
                        $("#managerDropdown").text(_this.model.fullName);
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