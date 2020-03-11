package org.truenewx.tnxsample.admin.repo;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.truenewx.tnxjee.core.caption.Caption;
import org.truenewx.tnxjee.core.util.StringUtil;
import org.truenewx.tnxjee.model.query.QueryResult;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.model.entity.Role;
import org.truenewx.tnxsample.admin.repo.test.RepoTestSupport;

import java.util.List;

/**
 * ManagerRepoTest
 *
 * @author jianglei
 */
public class ManagerRepoTest extends RepoTestSupport {
    @Autowired
    private ManagerRepo repo;

    @Test
    @Caption("测试：根据用户名查找首个管理员")
    public void findFirstByUsernameTest() {
        String username = getFirstData(Manager.class).getUsername();
        Manager manager = this.repo.findFirstByUsername(username);
        Assert.assertEquals(username, manager.getUsername());
    }

    @Test
    @Caption("测试：根据用户名计数管理员")
    public void countByUsernameTest() {
        String username = getFirstData(Manager.class).getUsername();
        long count = this.repo.countByUsername(username);
        Assert.assertEquals(1, count);
        count = this.repo.countByUsername(StringUtil.uuid32());
        Assert.assertEquals(0, count);
    }

    @Test
    @Caption("测试：根据角色id计数管理员")
    public void countByRoleIdTest() {
        int roleId = getFirstData(Role.class).getId();
        long count = this.repo.countByRoleId(roleId);
        Assert.assertEquals(1, count);
    }

    @Test
    @Caption("测试：根据用户名或姓名获取id集合")
    public void getIdsByUsernameOrFullNameTest() {
        String keyword = "l";
        List<Integer> ids = this.repo.getIdsByUsernameOrFullName(keyword);
        Assert.assertEquals(2, ids.size());
    }

    @Test
    @Caption("测试：根据关键字和是否顶级分页查询管理员")
    public void queryByKeywordAndTopTest() {
        String keyword = "l";
        QueryResult<Manager> qr = this.repo.queryByKeywordAndTop(keyword, false, 10, 1);
        List<Manager> records = qr.getRecords();
        Assert.assertEquals(2, records.size());
        Assert.assertTrue(
                records.get(0).getFullName().contains(keyword) || records.get(0).getUsername().contains(keyword));
        Assert.assertFalse(records.get(0).isTop());
        Assert.assertTrue(
                records.get(1).getFullName().contains(keyword) || records.get(1).getUsername().contains(keyword));
        Assert.assertFalse(records.get(1).isTop());
    }

    @Test
    @Caption("测试：根据排除的角色id和是否顶级分页查询管理员")
    public void queryByRoleIdNotAndTopTest() {
        int roleIdNot = getFirstData(Role.class).getId();
        QueryResult<Manager> qr = this.repo.queryByRoleIdNotAndTop(roleIdNot, false, 10, 1);
        List<Manager> records = qr.getRecords();
        Assert.assertEquals(2, records.size());
        Assert.assertFalse(records.get(0).isTop());
        records.get(0).getRoles().forEach(role -> {
            Assert.assertNotEquals(roleIdNot, role.getId().intValue());
        });
        Assert.assertFalse(records.get(1).isTop());
        records.get(1).getRoles().forEach(role -> {
            Assert.assertNotEquals(roleIdNot, role.getId().intValue());
        });
    }

}
