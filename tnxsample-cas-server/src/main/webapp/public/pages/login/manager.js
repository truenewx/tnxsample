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
                app.rpc.get('/serviceLogoutUrls', function(urlMapping) {
                    Object.keys(urlMapping).forEach(function(service) {
                        const url = urlMapping[service];
                        app.rpc.post(url, undefined, undefined, {
                            ignored: 'Redirect-To'
                        });
                    });
                });
            },
            mounted: function() {
                const $username = $('#username');
                this.username = $username.attr('init-value');
                if (!this.username) {
                    $username.focus();
                }
                const $password = $('#password');
                const password = $password.attr('init-value');
                if (password && password.length < 32) {
                    this.password = password;
                } else if (this.username) {
                    $password.focus();
                }
            },
            methods: {
                submit: function(event) {
                    if (this.username && this.password) {
                        const form = $(event.target).parents('form');
                        app.buildCsrfField(form[0]);
                        form.submit();
                    }
                }
            }
        });
    }
});