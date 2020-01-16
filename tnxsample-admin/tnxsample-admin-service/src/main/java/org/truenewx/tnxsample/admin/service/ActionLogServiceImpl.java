package org.truenewx.tnxsample.admin.service;

import java.time.Instant;
import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.truenewx.tnxjee.core.util.TemporalUtil;
import org.truenewx.tnxjee.model.query.Queried;
import org.truenewx.tnxjee.service.impl.unity.AbstractUnityService;
import org.truenewx.tnxjeex.log.model.Action;
import org.truenewx.tnxsample.admin.model.entity.ActionLog;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.model.query.ActionLogQuerying;
import org.truenewx.tnxsample.admin.repo.ManagerRepo;
import org.truenewx.tnxsample.admin.repo.model.ActionLogImpl;
import org.truenewx.tnxsample.admin.repo.mongo.ActionLogRepo;

/**
 * 操作日志服务实现
 *
 * @author jianglei
 */
@Service
public class ActionLogServiceImpl extends AbstractUnityService<ActionLog, String> implements ActionLogService {

    @Autowired
    private ActionLogRepo repo;
    @Autowired
    private ManagerRepo managerRepo;

    @Override
    public void add(Integer managerId, Action action) {
        Manager manager = getService(ManagerService.class).find(managerId);
        if (manager != null) {
            ActionLog log = new ActionLogImpl();
            log.setManagerId(managerId);
            log.setAction(action);
            log.setCreateTime(Instant.now());
            this.repo.save(log);
        }
    }

    @Override
    public Queried<ActionLog> query(String managerKeyword, LocalDate beginDate, LocalDate endDate, int pageSize,
            int pageNo) {
        ActionLogQuerying querying = new ActionLogQuerying();
        if (StringUtils.isNotBlank(managerKeyword)) {
            querying.setManagerIds(this.managerRepo.getIdsByUsernameOrFullName(managerKeyword));
        }
        if (beginDate != null) {
            querying.setBeginTime(TemporalUtil.toInstant(beginDate));
        }
        if (endDate != null) {
            querying.setEndTime(TemporalUtil.toInstant(endDate.plusDays(1)));
        }
        querying.setPageSize(pageSize);
        querying.setPageNo(pageNo);
        querying.addOrder("createTime", true);
        return this.repo.query(querying);
    }

}
