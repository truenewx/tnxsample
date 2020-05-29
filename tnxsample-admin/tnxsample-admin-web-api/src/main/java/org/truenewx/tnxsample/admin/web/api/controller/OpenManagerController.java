package org.truenewx.tnxsample.admin.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.truenewx.tnxjee.model.spec.user.security.DefaultUserSpecificDetails;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAnonymous;
import org.truenewx.tnxsample.admin.api.OpenManagerApi;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.service.ManagerService;

/**
 * 管理员开放控制器
 *
 * @author jianglei
 */
@RestController
@ConfigAnonymous
public class OpenManagerController implements OpenManagerApi {

    @Autowired
    private ManagerService managerService;

    @Override
    public DefaultUserSpecificDetails validateLogin(String username, String password) {
        Manager manager = this.managerService.validateLogin(username, password);
        return manager.getSpecificDetails();
    }

}
