package org.truenewx.tnxsample.admin.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.truenewx.tnxjee.core.caption.Caption;
import org.truenewx.tnxjee.core.util.CollectionUtil;
import org.truenewx.tnxjee.model.entity.unity.UnityUtil;
import org.truenewx.tnxjee.test.service.annotation.TestBusinessException;
import org.truenewx.tnxsample.admin.model.command.RoleCommandModel;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.model.entity.Role;
import org.truenewx.tnxsample.admin.service.test.ServiceTestSupport;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * RoleServiceTest
 *
 * @author jianglei
 */
public class RoleServiceTest extends ServiceTestSupport {
    @Autowired
    private RoleService service;

    @Test
    @Caption("测试：查找所有角色")
    public void findAllTest() {
        List<Role> roles = getDataList(Role.class);

        List<Role> list = CollectionUtil.toList(this.service.findAll());
        Assert.assertEquals(roles.size(), list.size());
        list.forEach(role -> {
            Assert.assertTrue(roles.contains(role));
        });
    }

    @Test
    @Caption("测试：根据名称查找角色")
    public void findByName() {
        Role role0 = getFirstData(Role.class);
        String roleName = role0.getName().substring(0, 1);
        List<Role> list = this.service.findByName(roleName);
        Assert.assertEquals(1, list.size());
        Assert.assertTrue(list.get(0).getName().contains(roleName));
    }

    @Test
    @Caption("测试：移动角色顺序")
    public void moveTest() {
        Role role0 = getData(Role.class, 0);
        Role role1 = getData(Role.class, 1);
        long ordinal0 = role0.getOrdinal();
        long ordinal1 = role1.getOrdinal();

        this.service.move(role1.getId(), false);
        Role role = this.service.find(role1.getId());
        Assert.assertEquals(ordinal0, role.getOrdinal());

        this.service.move(role1.getId(), true);
        role = this.service.find(role1.getId());
        Assert.assertEquals(ordinal1, role.getOrdinal());
    }

    @Test
    @Caption("测试：查找所有角色")
    @TestBusinessException(ManagerExceptionCodes.ROLE_REPEAT_NAME)
    public void validateBusinessTestRepeatName() {
        int roleId0 = getFirstData(Role.class).getId();
        String roleName = getData(Role.class, 1).getName();

        RoleCommandModel model = new RoleCommandModel();
        model.setName(roleName);
        this.service.validateBusiness(roleId0, model);
        Assert.fail();
    }

    @Test
    @Caption("测试：添加角色")
    public void addTest() {
        int[] managerIds = {getData(Manager.class, 1).getId(), getData(Manager.class, 2).getId()};

        RoleCommandModel model = new RoleCommandModel();
        model.setName("NewRole");
        model.setManagerIds(managerIds);
        model.setPermissions(new String[]{"a", "b", "c"});
        model.setRemark("role remark1");
        int roleId = this.service.add(model).getId();

        Role role = this.service.find(roleId);
        Assert.assertEquals(model.getName(), role.getName());
        Assert.assertTrue(CollectionUtil.equals(role.getPermissions(), model.getPermissions()));
        Assert.assertArrayEquals(managerIds, model.getManagerIds());
        Assert.assertEquals(model.getRemark(), role.getRemark());
    }

    @Test
    @Caption("测试：修改角色")
    public void updateTest() {
        int roleId1 = getData(Role.class, 1).getId();
        int[] managerIds = {getData(Manager.class, 1).getId(), getData(Manager.class, 2).getId()};

        RoleCommandModel model = new RoleCommandModel();
        model.setName("UpdatedRole");
        model.setManagerIds(managerIds);
        model.setPermissions(new String[]{"a", "c", "d"});
        model.setRemark("role remark1");
        this.service.update(roleId1, model);

        Role role = this.service.find(roleId1);
        Assert.assertEquals(model.getName(), role.getName());
        Assert.assertTrue(CollectionUtil.equals(role.getPermissions(), model.getPermissions()));
        Assert.assertArrayEquals(managerIds, model.getManagerIds());
        Assert.assertEquals(model.getRemark(), role.getRemark());
    }

    @Test
    @Caption("测试：删除角色")
    public void deleteTest() {
        Role role = getData(Role.class, 1);
        int roleId1 = role.getId();
        Collection<Manager> managers = role.getManagers();

        this.service.delete(roleId1);

        Assert.assertNull(this.service.find(roleId1));
        managers.forEach(manager -> {
            Set<Integer> roleIds = UnityUtil.getIdSet(manager.getRoles());
            Assert.assertFalse(roleIds.contains(roleId1));
        });
    }

}
