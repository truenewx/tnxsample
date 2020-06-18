// menu.js
// 如果使用vue-router，则要求<router-view></router-view>在容器范围内，这将导致router-view中的内容只能使用总的
// vue实例，这使得其中的页面无法具有单独的vue实例，只能使用单个vue文件组件的方式，而vue文件的方式不符合框架的总体
// 设计原则：html、js和css分离，且*.vue文件无法在浏览器中通过require进行模块化加载执行
require.config({
    map: {
        "*": {
            "breadcrumb": app_config.path + "/pages/breadcrumb.js?v=" + app_config.version,
        }
    }
});

define(["app", "router", "breadcrumb"], function(app, TnxRouter) {
    return function(container) {
        var viewContainer = $(".main-container");
        app.router = new TnxRouter(viewContainer);

        app.menu = new Vue({
            el: container,
            data: {
                shrinked: false,
                currentPath: app.router.getCurrentPath(),
                expandedIndex: -1,
                indexes: [],
            },
            created: function() {
                app.router.setViewCallback(this.onView);
                this.loadIndexes();
            },
            methods: {
                shrink: function() {
                    this.shrinked = !this.shrinked;
                },
                loadIndexes: function() {
                    if (this.currentPath) {
                        var _this = this;
                        app.rpc.get("/menu/link/indexes", {
                            path: this.currentPath
                        }, function(indexes) {
                            _this.indexes = indexes;
                            if (indexes.length > 1) {
                                _this.expandedIndex = indexes[0];
                            } else {
                                _this.expandedIndex = -1;
                            }
                            _this.buildBreadcrumb();
                        }, {
                            base: "self"
                        });
                    } else {
                        this.indexes = [];
                        var defaultLink = this.getDefaultLink();
                        if (defaultLink) {
                            this.currentPath = app.router.navTo(defaultLink.path);
                        }
                    }
                },
                getDefaultLink: function() {
                    return this.parseLink($("#menu-item-default a", container));
                },
                parseLink: function(a) {
                    if (a.length) {
                        var href = a.attr("href");
                        var path = href.startsWith("#/") ? href.substr(1) : undefined;
                        return {
                            path: path,
                            caption: a.text().trim()
                        }
                    }
                    return undefined;
                },
                onView: function() {
                    var title = viewContainer.children("[data-title]").attr("data-title");
                    if (title) {
                        $(document).attr("title", title + " - txnsample");
                    } else {
                        $(document).attr("title", "txnsample");
                    }
                    this.currentPath = app.router.getCurrentPath();
                    this.loadIndexes();
                },
                buildBreadcrumb: function() {
                    var links = [this.getDefaultLink()];
                    var parentItemId = undefined;
                    for (var index of this.indexes) {
                        var itemId = parentItemId ? (parentItemId + "-" + index) : ("menu-item-" + index);
                        links.push(this.getLink(itemId));
                        parentItemId = itemId;
                    }
                    app.breadcrumb.setLinks(links);
                },
                getLink: function(itemId) {
                    var item = $("#" + itemId, container);
                    if (item.length) {
                        var a;
                        if (item.is("ul")) { // 中间节点
                            a = item.prev();
                        } else { // 叶节点
                            a = $("a", item);
                        }
                        return this.parseLink(a);
                    }
                }
            }
        });
    }
});
