package org.truenewx.tnxsample.admin.model;

import java.time.Instant;

import org.truenewx.tnxjee.model.core.unity.Unity;
import org.truenewx.tnxjeex.log.model.Action;

/**
 * 操作日志
 *
 * @author jianglei
 */
public interface ActionLog extends Unity<String> {

    void setManagerId(int managerId);

    int getManagerId();

    void setCreateTime(Instant createTime);

    Instant getCreateTime();

    void setAction(Action action);

    Action getAction();

}
