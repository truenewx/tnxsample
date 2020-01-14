package org.truenewx.tnxsample.admin.model.domain;

import java.time.Instant;

import org.truenewx.tnxjee.model.core.unity.Unity;
import org.truenewx.tnxjeex.log.model.Action;

import lombok.Getter;
import lombok.Setter;

/**
 * 操作日志
 *
 * @author jianglei
 */
@Getter
@Setter
public class ActionLog implements Unity<String> {

    private String id;
    private int managerId;
    private Instant createTime;
    private Action action;

    protected void setId(String id) {
        this.id = id;
    }

}
