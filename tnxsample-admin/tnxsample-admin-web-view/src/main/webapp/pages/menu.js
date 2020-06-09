// menu.js
// 如果使用vue-router，则要求<router-view></router-view>在容器范围内，这将导致router-view中的内容只能使用总的
// vue实例，这使得其中的页面无法具有单独的vue实例，只能使用单个vue文件组件的方式，而vue文件的方式不符合框架的总体
// 设计原则：html、js和css分离，且*.vue文件无法在浏览器中通过require进行模块化加载执行
define(["app", "router"], function(app, TnxRouter) {
    return function(container) {
        var viewContainer = $(".main-container");
        app.router = new TnxRouter(viewContainer);
        app.router.setViewCallback(function() {
            var title = viewContainer.children("[data-title]").attr("data-title");
            if (title) {
                $(document).attr("title", title + " - txnsample");
            } else {
                $(document).attr("title", "txnsample");
            }
        });

        new Vue({
            el: container,
            data: {
                shrinked: false,
                currentPath: app.router.getCurrentPath(),
                expandedIndex: -1,
            },
            created: function() {
                if (this.currentPath) {
                    var _this = this;
                    app.rpc.get("/menu/link/indexes", {
                        path: _this.currentPath
                    }, function(indexes) {
                        if (indexes.length > 1) {
                            _this.expandedIndex = indexes[0];
                        }
                    }, {
                        base: "self"
                    });
                } else {
                    this.currentPath = app.router.navTo("/index");
                }
            },
            methods: {
                shrink: function() {
                    this.shrinked = !this.shrinked;
                },
                route: function(path) {
                    this.currentPath = path;
                    app.router.to(path);
                }
            }
        });
    }
});
