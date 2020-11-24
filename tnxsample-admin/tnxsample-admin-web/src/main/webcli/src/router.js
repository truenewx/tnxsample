// router.js
import {Vue} from './app';
import VueRouter from 'vue-router';
import menu from './menu.js';
import Router from '../../../../../../../tnxweb/components/vue/tnxvue-router';

Vue.use(VueRouter);

const router = new Router(menu, function(path) {
    if (path === '/') {
        path = '/index';
    }
    return import('./pages' + path + '.vue');
});

export default new VueRouter({
    routes: router.getRoutes()
});
