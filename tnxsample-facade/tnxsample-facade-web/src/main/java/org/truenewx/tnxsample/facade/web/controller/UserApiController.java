package org.truenewx.tnxsample.facade.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.truenewx.tnxjee.web.controller.security.config.annotation.ConfigAnonymous;
import org.truenewx.tnxsample.facade.api.UserApi;
import org.truenewx.tnxsample.facade.model.entity.User;
import org.truenewx.tnxsample.facade.service.UserService;

/**
 * 用户控制器
 *
 * @author jianglei
 */
@RestController
public class UserApiController implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    @ConfigAnonymous
    public User loadByMobilePhone(String mobilePhone) {
        return this.userService.loadByMobilePhone(mobilePhone);
    }

}
