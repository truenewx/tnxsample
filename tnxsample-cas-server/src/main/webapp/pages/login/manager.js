// login.js
define(["app"], function(app) {
    var util = app.owner.util;
    return function(container) {
        new Vue({
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
            created: function() {
                app.rpc.post("/deleteServiceTickets", function(urlMapping) {
                    var service = $("#service").val();
                    for (var deletedService of urlMapping) {
                        if (deletedService !== service) {
                            var url = urlMapping[deletedService]
                            app.rpc.get(url);
                        }
                    }
                });
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