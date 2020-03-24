package org.truenewx.tnxsample.facade.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.truenewx.tnxjee.web.http.annotation.ResultFilter;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAnonymous;
import org.truenewx.tnxsample.facade.api.UserAdminApi;
import org.truenewx.tnxsample.facade.model.entity.User;
import org.truenewx.tnxsample.facade.service.UserService;

@Api("用户管理")
@RestController
public class UserAdminController implements UserAdminApi {

    @Autowired
    private UserService userService;

    @Override
    @ApiOperation("根据手机号码加载用户")
    @ConfigAnonymous
    @ResultFilter(type = User.class, excluded = {"accountNonExpired", "accountNonLocked",
            "credentialsNonExpired", "enabled", "password"}, pureEnum = "type")
    public User loadByMobilePhone(String mobilePhone) {
        return this.userService.loadByMobilePhone(mobilePhone);
    }

}
