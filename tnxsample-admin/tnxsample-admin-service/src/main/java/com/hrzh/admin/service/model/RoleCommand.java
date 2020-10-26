package com.hrzh.admin.service.model;

import org.truenewx.tnxjee.model.CommandModel;
import org.truenewx.tnxsample.admin.model.entity.Role;

import lombok.Getter;
import lombok.Setter;

/**
 * 角色命令模型
 *
 * @author jianglei
 */
@Getter
@Setter
public class RoleCommand implements CommandModel<Role> {

    private String name;
    private String remark;
    private String[] permissions;
    private int[] managerIds;

}
