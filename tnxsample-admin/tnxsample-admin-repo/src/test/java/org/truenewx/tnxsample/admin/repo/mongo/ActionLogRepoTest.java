package org.truenewx.tnxsample.admin.repo.mongo;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.truenewx.tnxjee.core.caption.Caption;
import org.truenewx.tnxjee.model.query.Queried;
import org.truenewx.tnxsample.admin.model.ActionLog;
import org.truenewx.tnxsample.admin.model.Manager;
import org.truenewx.tnxsample.admin.model.query.ActionLogQuerying;
import org.truenewx.tnxsample.admin.repo.test.RepoTestSupport;

/**
 * ActionLogRepoTest
 *
 * @author jianglei
 */
public class ActionLogRepoTest extends RepoTestSupport {

    @Autowired
    private ActionLogRepo repo;

    @Override
    protected Class<?>[] getEntityClasses() {
        return new Class<?>[] { ActionLog.class };
    }

    @Test
    @Caption("测试：分页查询操作日志")
    public void queryTest() {
        List<Manager> managers = getDataList(Manager.class);

        ActionLogQuerying querying = new ActionLogQuerying();
        querying.setPageSize(10);
        querying.setPageNo(1);
        List<Integer> managerIds = new ArrayList<>();
        managerIds.add(managers.get(0).getId());
        managerIds.add(managers.get(2).getId());
        querying.setManagerIds(managerIds);
        Instant now = Instant.now();
        Instant beginTime = now.minusMillis(90 * 60 * 1000);
        querying.setBeginTime(beginTime);
        Instant endTime = now.plusMillis(1);
        querying.setEndTime(endTime);

        Queried<ActionLog> queried = this.repo.query(querying);
        Assert.assertEquals(1, queried.getPaged().getTotal().longValue());
        List<ActionLog> records = queried.getRecords();
        Assert.assertEquals(1, records.size());
        ActionLog log0 = records.get(0);
        Assert.assertTrue(managerIds.contains(log0.getManagerId()));
        Instant createTime0 = log0.getCreateTime();
        Assert.assertTrue(beginTime.isBefore(createTime0));
        Assert.assertTrue(createTime0.isBefore(endTime));
    }

}
