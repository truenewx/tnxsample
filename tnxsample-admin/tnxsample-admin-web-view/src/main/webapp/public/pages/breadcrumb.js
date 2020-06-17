// breadcrumb.js
define(["app"], function(app) {
    return function(container) {
        app.breadcrumb = new Vue({
            el: container,
            data: {
                links: []
            },
            methods: {
                setLinks: function(links) {
                    this.links = links;
                }
            }
        });
    }
});
