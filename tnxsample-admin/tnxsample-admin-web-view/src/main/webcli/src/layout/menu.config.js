// menu.config.js
const items = [{
    caption: '系统管理',
    icon: 'fa-cogs',
    subs: [{
        caption: '角色管理',
        icon: 'fa-id-badge',
        path: '/role/list',
    }, {
        caption: '管理员管理',
        icon: 'fa-users-cog',
        path: '/manager/list',
    }, {
        caption: '操作日志',
        path: '/log/action',
    }, {
        caption: '系统日志',
        path: '/log/system',
    }]
}, {
    caption: '客户管理',
    icon: 'fa-user',
    path: '/customer/list',
}];

function applyItemsToRoutes(items, routes) {
    if (items && items.length) {
        items.forEach(item => {
            if (item.path) {
                routes.push({
                    path: item.path,
                    component: () => import('../pages' + item.path + '.vue')
                });
            } else {
                applyItemsToRoutes(item.subs, routes);
            }
        });
    }
}

export default {
    items: items,
    getRoutes: () => {
        const routes = [];
        applyItemsToRoutes(items, routes);
        return routes;
    }
};
