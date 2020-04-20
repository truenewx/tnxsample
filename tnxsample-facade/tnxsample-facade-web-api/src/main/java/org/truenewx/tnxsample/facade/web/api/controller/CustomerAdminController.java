package org.truenewx.tnxsample.facade.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.truenewx.tnxjee.web.http.annotation.ResultFilter;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAuthority;
import org.truenewx.tnxsample.core.util.CommonConstants;
import org.truenewx.tnxsample.facade.api.CustomerAdminApi;
import org.truenewx.tnxsample.facade.model.entity.Customer;
import org.truenewx.tnxsample.facade.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("客户管理")
@RestController
@ConfigAuthority(role = CommonConstants.USER_ROLE_MANAGER)
public class CustomerAdminController implements CustomerAdminApi {

    @Autowired
    private CustomerService customerService;

    @Override
    @ApiOperation("根据手机号码加载用户")
    @ResultFilter(type = Customer.class, excluded = { "accountNonExpired", "accountNonLocked",
            "credentialsNonExpired", "enabled", "password" }, pureEnum = "type")
    public Customer loadByMobilePhone(String mobilePhone) {
        return this.customerService.loadByMobilePhone(mobilePhone);
    }

}
