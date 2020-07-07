// login.js
define([], function() {
    return function(container) {
        new Vue({
            el: container,
            data: {
                username: '',
                password: '',
            },
            computed: {
                md5Password: function() {
                    return this.password ? util.md5(this.password) : '';
                }
            },
            created: function() {
                const service = $('#service').val();
                app.rpc.get('/serviceLogoutUrls', {
                    service: service
                }, function(urlMapping) {
                    Object.keys(urlMapping).forEach(function(logoutService) {
                        if (logoutService !== service) {
                            const url = urlMapping[logoutService];
                            // app.rpc.get(url);
                        }
                    });
                });
            },
            mounted: function() {
                this.username = $('#username').attr('init-value');
                const password = $('#password').attr('init-value');
                if (password && password.length < 32) {
                    this.password = password;
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