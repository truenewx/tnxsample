// menu.js
define(["app"], function(app) {
    return function(container) {
        new Vue({
            el: container,
            data: {
                shrinked: false
            },
            methods: {
                shrink: function() {
                    this.shrinked = !this.shrinked;
                }
            }
        });
    }
});
