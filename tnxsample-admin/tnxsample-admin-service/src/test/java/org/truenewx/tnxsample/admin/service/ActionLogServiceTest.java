package org.truenewx.tnxsample.admin.service;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.truenewx.tnxjee.core.caption.Caption;
import org.truenewx.tnxjee.model.query.Queried;
import org.truenewx.tnxjeex.log.model.Action;
import org.truenewx.tnxsample.admin.model.entity.ActionLog;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.service.test.ServiceTestSupport;

/**
 * ActionLogServiceTest
 *
 * @author jianglei
 */
public class ActionLogServiceTest extends ServiceTestSupport {
    @Autowired
    private ActionLogService service;

    @Test
    @Caption("测试：添加和分页查询操作日志")
    public void addAndQueryTest() {
        Manager manager = getFirstData(Manager.class);
        int managerId = manager.getId();
        Action action = new Action("roleCongroller", "/list", "GET", null);
        LocalDate today = LocalDate.now();

        Queried<ActionLog> queried = this.service.query(manager.getUsername(), null, today, 10, 1);
        Assert.assertEquals(2, queried.getPaged().getTotal().intValue());
        this.service.add(managerId, action);
        queried = this.service.query(manager.getUsername(), today, null, 10, 1);
        Assert.assertEquals(3, queried.getPaged().getTotal().intValue());
    }

}
