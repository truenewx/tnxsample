package org.truenewx.tnxsample.admin.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAuthority;
import org.truenewx.tnxsample.admin.api.ManagerActionLogApi;
import org.truenewx.tnxsample.admin.model.entity.Action;
import org.truenewx.tnxsample.admin.service.ActionLogService;
import org.truenewx.tnxsample.admin.web.api.util.ProjectWebUtil;
import org.truenewx.tnxsample.common.CommonConstants;

/**
 * 管理员操作日志控制器
 *
 * @author jianglei
 */
@RestController
@ConfigAuthority(type = CommonConstants.USER_TYPE_MANAGER)
public class ManagerActionLogController implements ManagerActionLogApi {

    @Autowired
    private ActionLogService actionLogService;

    @Override
    public void add(Action action) {
        int managerId = ProjectWebUtil.getManagerId();
        this.actionLogService.add(managerId, action);
    }

}
