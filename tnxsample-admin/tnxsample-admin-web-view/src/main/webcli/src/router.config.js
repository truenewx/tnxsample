// router.config.js
import menu from './layout/menu.js';

function addRoute (path, routes) {
    if (path) {
        routes.push({
            path: path,
            component: () => import('./pages' + path + '.vue'),
        });
        return true;
    }
    return false;
}

function applyItemsToRoutes (items, routes) {
    if (items && items.length) {
        items.forEach(item => {
            if (addRoute(item.path, routes)) {
                if (item.operations && item.operations.length) {
                    item.operations.forEach(operation => {
                        addRoute(operation.path, routes);
                    });
                }
            } else {
                applyItemsToRoutes(item.subs, routes);
            }
        });
    }
}

function getRoutes () {
    const routes = [];
    applyItemsToRoutes(menu.items, routes);
    return routes;
}

export default {
    routes: getRoutes()
};
