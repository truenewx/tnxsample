// menu.config.js
export default {
    items: [{
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
    }]
};
