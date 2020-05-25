// mine/password.js
define(["app"], function(app) {
    return function(container) {
        new Vue({
            el: container,
            data: {
                model: {},
                newPassword2: null,
                error: {
                    oldPassword: false,
                    newPassword: false,
                }
            },
            methods: {
                submit: function() {
                    this.error.oldPassword = false;
                    this.error.newPassword = this.model.newPassword !== this.newPassword2;
                    if (!this.error.newPassword) {
                        var _this = this;
                        app.rpc.post("/mine/password", function() {
                            tnx.alert("成功", "登录密码修改成功，请使用新的密码重新登录", function() {
                                window.location.href = app.context + "/logout";
                            });
                        }, {
                            params: this.model,
                            error: function(errors) {
                                _this.error.oldPassword = true;
                            }
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