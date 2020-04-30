package org.truenewx.tnxsample.admin.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.truenewx.tnxjee.model.spec.user.security.UserSpecificDetails;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAnonymous;
import org.truenewx.tnxsample.admin.api.ManagerOpenApi;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.service.ManagerService;
import org.truenewx.tnxsample.core.model.TypedUserIdentity;

/**
 * 管理员开放控制器
 *
 * @author jianglei
 */
@RestController
@ConfigAnonymous(intranet = true)
public class ManagerOpenController implements ManagerOpenApi {

    @Autowired
    private ManagerService managerService;

    @Override
    public UserSpecificDetails<TypedUserIdentity> validateLogin(String username, String password) {
        Manager manager = this.managerService.validateLogin(username, password);
        return manager.getSpecificDetails();
    }

}
