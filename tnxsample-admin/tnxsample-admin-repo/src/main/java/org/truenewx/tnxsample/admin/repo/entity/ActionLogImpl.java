package org.truenewx.tnxsample.admin.repo.entity;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.truenewx.tnxjeex.log.model.Action;
import org.truenewx.tnxsample.admin.model.entity.ActionLog;

import lombok.Getter;
import lombok.Setter;

/**
 * 操作日志实现
 *
 * @author jianglei
 */
@Setter
@Getter
@Document
public class ActionLogImpl implements ActionLog {

    @Id
    @Field("_id")
    private String id;
    private int managerId;
    private Instant createTime;
    private Action action;

    protected void setId(String id) {
        this.id = id;
    }

}
