package org.truenewx.tnxsample.admin.service;

import java.time.LocalDate;

import org.truenewx.tnxjee.model.query.Queried;
import org.truenewx.tnxjee.service.api.unity.UnityService;
import org.truenewx.tnxjeex.log.service.ActionLogWriter;
import org.truenewx.tnxsample.admin.model.entity.ActionLog;

/**
 * 操作日志服务
 *
 * @author jianglei
 */
public interface ActionLogService extends UnityService<ActionLog, String>, ActionLogWriter<Integer> {

    Queried<ActionLog> query(String managerKeyword, LocalDate beginDate, LocalDate endDate, int pageSize, int pageNo);

}
