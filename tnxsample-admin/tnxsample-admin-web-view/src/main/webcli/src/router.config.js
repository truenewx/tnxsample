import menuConfig from './layout/menu.config';

function applyItemsToRoutes (items, routes) {
    if (items && items.length) {
        items.forEach(item => {
            if (item.path) {
                routes.push({
                    path: item.path,
                    component: () => import('./pages' + item.path + '.vue')
                });
            } else {
                applyItemsToRoutes(item.subs, routes);
            }
        });
    }
}

function getRoutes () {
    const routes = [];
    applyItemsToRoutes(menuConfig.items, routes);
    return routes;
}

export default {
    routes: getRoutes()
};
