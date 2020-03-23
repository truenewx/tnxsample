package org.truenewx.tnxsample.facade.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.truenewx.tnxjee.model.spec.user.security.UserSpecificDetails;
import org.truenewx.tnxjee.web.http.annotation.ResultFilter;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAnonymous;
import org.truenewx.tnxsample.facade.api.UserAdminApi;
import org.truenewx.tnxsample.facade.model.entity.User;
import org.truenewx.tnxsample.facade.service.UserService;

/**
 * 用户控制器
 *
 * @author jianglei
 */
@RestController
public class UserAdminController implements UserAdminApi {

    @Autowired
    private UserService userService;

    @Override
    @ConfigAnonymous
    @ResultFilter(type = UserSpecificDetails.class, excluded = {"accountNonExpired", "accountNonLocked",
            "credentialsNonExpired", "enabled"})
    @ResultFilter(type = User.class, excluded = "password", captionEnum = "gender")
    public User loadByMobilePhone(String mobilePhone) {
        return this.userService.loadByMobilePhone(mobilePhone);
    }

}
