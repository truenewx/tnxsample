package org.truenewx.tnxsample.admin.repo.mongo.data;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.truenewx.tnxjee.repo.data.AbstractDataProvider;
import org.truenewx.tnxjee.repo.data.DataPool;
import org.truenewx.tnxjeex.log.model.Action;
import org.truenewx.tnxsample.admin.model.entity.ActionLog;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.repo.model.ActionLogImpl;

/**
 * 操作日志数据提供者
 *
 * @author jianglei
 */
@Component
public class ActionLogDataProvider extends AbstractDataProvider<ActionLog> {

    @Override
    protected void init(DataPool pool) {
        List<Manager> managers = pool.getDataList(Manager.class);
        Instant now = Instant.now();

        ActionLog log0 = new ActionLogImpl();
        log0.setAction(new Action("loginController", "/login", "POST", null));
        log0.setManagerId(managers.get(0).getId());
        log0.setCreateTime(now.minusMillis(2 * 60 * 60 * 1000)); // 2小时前
        save(log0);

        ActionLog log1 = new ActionLogImpl();
        log1.setAction(new Action("loginController", "isValid", Arrays.asList("username")));
        log1.setManagerId(managers.get(0).getId());
        log1.setCreateTime(now.minusMillis(1 * 60 * 60 * 1000)); // 1小时前
        save(log1);

        ActionLog log2 = new ActionLogImpl();
        log2.setAction(new Action("loginController", "isValid", Arrays.asList("username")));
        log2.setManagerId(managers.get(1).getId());
        log2.setCreateTime(now);
        save(log2);
    }

}
