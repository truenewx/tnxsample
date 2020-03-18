// header.js
define([], function() {
    return function(app) {
        var container = $("header")[0];
        new app.Vue({
            el: container,
            data: {},
            methods: {
                toUpdateInfo: function() {
                    
                }
            }
        });
    }
});
