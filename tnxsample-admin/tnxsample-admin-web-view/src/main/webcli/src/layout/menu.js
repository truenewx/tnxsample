// menu.js
import Menu from '../../../../../../../../tnxweb/components/tnxcore-menu';

export default new Menu({
    url: '/manager/self/authorities',
    items: [{
        caption: '系统管理',
        icon: 'fa-cogs',
        subs: [{
            caption: '角色管理',
            icon: 'fa-id-badge',
            path: '/role/list',
            rank: 'top',
            operations: [{
                caption: '添加角色',
                path: '/role/add',
                rank: 'top',
            }, {
                caption: '修改角色',
                path: '/role/:id/update',
                rank: 'top',
            }, {
                caption: '删除角色',
                path: '/role/:id/delete',
                rank: 'top',
            }],
        }, {
            caption: '管理员管理',
            icon: 'fa-users-cog',
            path: '/manager/list',
            rank: 'top',
        }]
    }, {
        caption: '客户管理',
        desc: '查询客户清单',
        icon: 'fa-user',
        path: '/customer/list',
        permission: 'CUSTOMER_LIST',
        operations: [{
            caption: '查看客户详情',
            path: '/customer/:id/detail',
            permission: 'CUSTOMER_DETAIL'
        }, {
            caption: '禁用/启用客户',
            path: '/customer/:id/disable',
            permission: 'CUSTOMER_DISABLE'
        }]
    }]
});
