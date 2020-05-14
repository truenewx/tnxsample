package org.truenewx.tnxsample.admin.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.truenewx.tnxjee.model.spec.user.security.DefaultUserSpecificDetails;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAnonymous;
import org.truenewx.tnxsample.admin.api.ManagerAdminApi;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.service.ManagerService;

@RestController
@ConfigAnonymous // TODO 暂时匿名
public class ManagerAdminController implements ManagerAdminApi {
    @Autowired
    private ManagerService managerService;

    @Override
    public DefaultUserSpecificDetails getSpecificDetails(int id) {
        Manager manager = this.managerService.findWithRoles(id);
        if (manager != null) {
            return manager.getSpecificDetails();
        }
        return null;
    }

}
