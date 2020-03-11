package org.truenewx.tnxsample.admin.model.submit;

import org.truenewx.tnxjee.model.CommandModel;
import org.truenewx.tnxsample.admin.model.entity.Role;

/**
 * 角色命令模型
 *
 * @author jianglei
 */
public class RoleCommandModel implements CommandModel<Role> {

    private String name;
    private String remark;
    private String[] permissions;
    private int[] managerIds;

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(final String remark) {
        this.remark = remark;
    }

    public String[] getPermissions() {
        return this.permissions;
    }

    public void setPermissions(final String[] permissions) {
        this.permissions = permissions;
    }

    public int[] getManagerIds() {
        return this.managerIds;
    }

    public void setManagerIds(final int[] managerIds) {
        this.managerIds = managerIds;
    }

}
