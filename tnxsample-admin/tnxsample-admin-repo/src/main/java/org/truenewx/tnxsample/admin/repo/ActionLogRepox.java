package org.truenewx.tnxsample.admin.repo;

import org.truenewx.tnxjee.model.query.Queried;
import org.truenewx.tnxsample.admin.model.entity.ActionLog;
import org.truenewx.tnxsample.admin.model.query.ActionLogQuerying;

/**
 * 操作日志Repo扩展
 *
 * @author jianglei
 */
public interface ActionLogRepox {

    Queried<ActionLog> query(ActionLogQuerying querying);

}
