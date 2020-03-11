package org.truenewx.tnxsample.admin.model.submit;

import lombok.Getter;
import lombok.Setter;
import org.truenewx.tnxjee.model.CommandModel;
import org.truenewx.tnxsample.admin.model.entity.Manager;

/**
 * 管理员命令模型
 *
 * @author jianglei
 */
@Getter
@Setter
public class ManagerCommandModel implements CommandModel<Manager> {

    private String username;
    private String password;
    private String fullName;
    private int[] roleIds;

}
