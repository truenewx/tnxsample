package org.truenewx.tnxsample.admin.repo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.truenewx.tnxjee.core.caption.Caption;
import org.truenewx.tnxjee.core.util.JsonUtil;
import org.truenewx.tnxsample.admin.model.entity.Role;
import org.truenewx.tnxsample.admin.repo.test.RepoTestSupport;

/**
 * RoleRepoTest
 *
 * @author jianglei
 */
public class RoleRepoTest extends RepoTestSupport {
    @Autowired
    private RoleRepo repo;

    @Test
    public void testJson() {
        Role role0 = getFirstData(Role.class);
        String json = JsonUtil.toJson(role0, "managers");
        System.out.println(json);
        Assert.assertTrue(json.length() > 0);
    }

    @Test
    @Caption("测试：根据名称查找角色")
    public void findByNameContainingOrderByOrdinalTest() {
        Role role0 = getFirstData(Role.class);
        String roleName = role0.getName().substring(0, 1);
        List<Role> list = this.repo.findByNameContainingOrderByOrdinal(roleName);
        Assert.assertEquals(1, list.size());
        Assert.assertTrue(list.get(0).getName().contains(roleName));
    }

    @Test
    @Caption("测试：根据名称计数")
    public void countByNameTest() {
        Role role0 = getFirstData(Role.class);
        long count = this.repo.countByName(role0.getName());
        Assert.assertEquals(1, count);
    }

    @Test
    @Caption("测试：根据名称和排除id计数")
    public void countByNameAndIdNotTest() {
        Role role0 = getFirstData(Role.class);
        long count = this.repo.countByNameAndIdNot(role0.getName(), role0.getId());
        Assert.assertEquals(0, count);
    }

    @Test
    @Caption("测试：根据最大序号获取首个角色")
    public void findFirstByOrdinalLessThanOrderByOrdinalDescTest() {
        Role role1 = getData(Role.class, 1);
        Role role = this.repo.findFirstByOrdinalLessThanOrderByOrdinalDesc(role1.getOrdinal());
        Assert.assertTrue(role.getOrdinal() < role1.getOrdinal());
    }

    @Test
    @Caption("测试：根据最小序号获取首个角色")
    public void findFirstByOrdinalGreaterThanOrderByOrdinalTest() {
        Role role0 = getFirstData(Role.class);
        Role role = this.repo.findFirstByOrdinalGreaterThanOrderByOrdinal(role0.getOrdinal());
        Assert.assertTrue(role.getOrdinal() > role0.getOrdinal());
    }

}
