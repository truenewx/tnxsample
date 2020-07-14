// menu.js
import Menu from '../../../../../../../../tnxweb/components/tnxcore-menu';

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
