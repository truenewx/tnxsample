// menu.js
// 如果使用vue-router，则要求<router-view></router-view>在容器范围内，这将导致router-view中的内容只能使用总的
// vue实例，这使得其中的页面无法具有单独的vue实例，只能使用单个vue文件组件的方式，而vue文件的方式不符合框架的总体
// 设计原则：html、js和css分离，且*.vue文件无法在浏览器中通过require进行模块化加载执行
define(["app", "router"], function(app, TnxRouter) {
    return function(container) {
        new Vue({
            el: container,
            data: {
                router: new TnxRouter($(".main-container")),
                shrinked: false,
            },
            methods: {
                shrink: function() {
                    this.shrinked = !this.shrinked;
                }
            }
        });
    }
});
