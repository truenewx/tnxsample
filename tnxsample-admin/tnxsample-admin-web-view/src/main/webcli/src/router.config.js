// router.config.js
import menu from './layout/menu.js';
import Router from '../../../../../../../tnxweb/components/tnxcore-router';

const router = new Router(menu, function(path) {
    return import('./pages' + path + '.vue');
});

export default {
    routes: router.getRoutes()
};
