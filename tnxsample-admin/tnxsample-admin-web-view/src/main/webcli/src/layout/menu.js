// menu.js
/**
 * 菜单配置中的权限配置不是服务端权限判断的依据，仅用于生成具有权限的客户端菜单，以及分配权限时展示可分配的权限范围
 */
const Menu = function Menu (config) {
    this.userType = config.userType;
    this.items = config.items;
}

Menu.prototype.findItem = function(path, items, callback) {
    if (!items) {
        items = this.items;
    }
    if (path && items && items.length) {
        for (let item of items) {
            if (item.path && item.path.startsWith(path)) {
                return callback(item);
            }
            // 直接路径不匹配，则尝试在包含的操作中查找
            if (item.operations && item.operations.length) {
                for (let operation of item.operations) {
                    if (operation.path && operation.path.startsWith(path)) {
                        return callback(item, operation);
                    }
                }
            }
            // 最后尝试在子菜单中查找
            if (item.subs) {
                let result = this.findItem(path, item.subs, callback);
                if (result) {
                    return callback(item, undefined, result);
                }
            }
        }
    }
    return undefined;
}

Menu.prototype.getItem = function(path, items) {
    return this.findItem(path, items, (item, operation, sub) => {
        return sub ? sub : item;
    });
};

Menu.prototype.getBreadcrumbItems = function(path, items) {
    let breadcrumbItems = this.findItem(path, items, (item, operation, breadcrumbItems) => {
        if (breadcrumbItems && breadcrumbItems.length) {
            breadcrumbItems.unshift(item);
            return breadcrumbItems;
        } else if (operation) {
            return [item, operation];
        } else {
            return [item];
        }
    });
    return breadcrumbItems || [];
};

export default new Menu({
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
