// index.js
define(["app"], function(app) {
    return function(container) {
        new app.Vue({
            el: container,
            data: {
                welcome: "Hello Vue",
                message: "hello",
                visible: true,
            },
            methods: {
                reverseVisible: function() {
                    this.visible = !this.visible;
                }
            }
        });
    }
});
