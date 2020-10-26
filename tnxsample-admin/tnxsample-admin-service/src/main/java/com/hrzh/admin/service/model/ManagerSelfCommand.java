package com.hrzh.admin.service.model;

import org.truenewx.tnxjee.model.CommandModel;
import org.truenewx.tnxsample.admin.model.entity.Manager;

import lombok.Getter;
import lombok.Setter;

/**
 * 管理员自身的命令模型
 */
@Getter
@Setter
public class ManagerSelfCommand implements CommandModel<Manager> {
    private String headImageUrl;
    private String fullName;
}
