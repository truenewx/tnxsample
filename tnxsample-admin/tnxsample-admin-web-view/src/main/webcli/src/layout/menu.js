// menu.js
/**
 * 菜单配置中的权限配置不是服务端权限判断的依据，仅用于生成具有权限的客户端菜单，以及分配权限时展示可分配的权限范围
 */
const menu = {
    userType: undefined,
    items: [],
    getItem (path, items) {
        if (!items) {
            items = this.items;
        }
        if (path && path !== '/' && items && items.length) {
            for (let item of items) {
                if (item.path && item.path.startsWith(path)) {
                    return item;
                }
                // 直接路径不匹配，则尝试在包含的操作中查找
                if (item.operations && item.operations.length) {
                    for (let operation of item.operations) {
                        if (operation.path && operation.path.startsWith(path)) {
                            return item;
                        }
                    }
                }
                // 最后尝试在子菜单中查找
                if (item.subs) {
                    let sub = this.getItem(path, item.subs);
                    if (sub) {
                        return sub;
                    }
                }
            }
        }
        return undefined;
    },
    getBreadcrumbItems (path, items) {
        if (!items) {
            items = this.items;
        }
        if (path && path !== '/' && items && items.length) {
            for (let item of items) {
                if (item.path && item.path.startsWith(path)) {
                    return [item];
                }
                // 直接路径不匹配，则尝试在包含的操作中查找
                if (item.operations && item.operations.length) {
                    for (let operation of item.operations) {
                        if (operation.path && operation.path.startsWith(path)) {
                            return [item, operation];
                        }
                    }
                }
                // 最后尝试在子菜单中查找
                if (item.subs) {
                    let breadcrumbItems = this.getBreadcrumbItems(path, item.subs);
                    if (breadcrumbItems.length) { // 在子菜单中找到，则将自身插入首位，并返回
                        breadcrumbItems.unshift(item);
                        return breadcrumbItems;
                    }
                }
            }
        }
        return [];
    }
};

export default Object.assign(menu, {
    userType: 'manager',
    items: [{
        caption: '系统管理',
        icon: 'fa-cogs',
        rank: 'top',
        subs: [{
            caption: '角色管理',
            icon: 'fa-id-badge',
            path: '/role/list',
            operations: [{
                caption: '添加角色',
                path: '/role/add',
            }],
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
        permission: 'CUSTOMER_LIST',
        operations: [{
            caption: '查看客户详情',
            path: '/customer/detail',
            permission: 'CUSTOMER_DETAIL'
        }, {
            caption: '禁用/启用客户',
            permission: 'CUSTOMER_DISABLE'
        }]
    }]
});
