package org.truenewx.tnxsample.admin.repo.mongo;

import org.truenewx.tnxjee.model.query.Queried;
import org.truenewx.tnxjee.repo.UnityRepo;
import org.truenewx.tnxsample.admin.model.entity.ActionLog;
import org.truenewx.tnxsample.admin.model.query.ActionLogQuerying;

/**
 * 操作日志Repo
 *
 * @author jianglei
 */
public interface ActionLogRepo extends UnityRepo<ActionLog, String> {

    Queried<ActionLog> query(ActionLogQuerying querying);

}
