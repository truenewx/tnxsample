package org.truenewx.tnxsample.admin.service;

import org.truenewx.tnxjee.model.query.QueryResult;
import org.truenewx.tnxjee.service.api.unity.UnityService;
import org.truenewx.tnxjeex.log.service.ActionLogWriter;
import org.truenewx.tnxsample.admin.model.entity.ActionLog;

import java.time.LocalDate;

/**
 * 操作日志服务
 *
 * @author jianglei
 */
public interface ActionLogService extends UnityService<ActionLog, String>, ActionLogWriter<Integer> {

    QueryResult<ActionLog> query(String managerKeyword, LocalDate beginDate, LocalDate endDate, int pageSize,
            int pageNo);

}
