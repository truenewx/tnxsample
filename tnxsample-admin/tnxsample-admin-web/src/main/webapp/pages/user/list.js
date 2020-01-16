// user/list.js
define(["app"], function(app) {
    return function(container) {
        new app.Vue({
            el: container,
            data: {
                records: null,
            },
            methods: {}
        });
    }
});