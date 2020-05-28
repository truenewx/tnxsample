package org.truenewx.tnxsample.admin.service.model;

import lombok.Getter;
import lombok.Setter;
import org.truenewx.tnxjee.model.CommandModel;
import org.truenewx.tnxsample.admin.model.entity.Manager;

/**
 * 管理员自身的命令模型
 */
@Getter
@Setter
public class CommandManagerSelf implements CommandModel<Manager> {
    private String headImageUrl;
    private String fullName;
}
