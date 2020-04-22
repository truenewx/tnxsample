// index.js
define(["app", "fssUpload"], function(app) {
    return function(container) {
        new Vue({
            el: container,
            data: {
            },
            created: function() {
            },
            mounted: function() {
                $("#headImageContainer").fssUpload({
                    type: "MANAGER_HEAD_IMAGE"
                });
            },
            methods: {
            }
        });
    }
});
