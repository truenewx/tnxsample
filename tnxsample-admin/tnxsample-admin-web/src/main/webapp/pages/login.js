// login.js
define(["app"], function(app) {
    var util = app.owner.util;
    return function(container) {
        new app.Vue({
            el: container,
            data: {
                username: "admin",
                password: "",
            },
            computed: {
                md5Password: function() {
                    return this.password ? util.md5(this.password) : "";
                }
            },
            methods: {
                submit: function(event) {
                    if (this.username && this.password) {
                        app.buildCsrfField(event.target);
                        return true;
                    }
                    event.preventDefault();
                    return false;
                }
            }
        });
    }
});