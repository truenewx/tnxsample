package com.hrzh.admin.service.model;

import org.truenewx.tnxjee.model.CommandModel;
import org.truenewx.tnxsample.admin.model.entity.Manager;

import lombok.Getter;
import lombok.Setter;

/**
 * 管理员命令模型
 *
 * @author jianglei
 */
@Getter
@Setter
public class ManagerCommand implements CommandModel<Manager> {

    private String jobNo;
    private String username;
    private String password;
    private String fullName;
    private int[] roleIds;

}
