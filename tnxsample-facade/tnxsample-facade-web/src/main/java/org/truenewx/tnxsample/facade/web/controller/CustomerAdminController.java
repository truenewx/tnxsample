package org.truenewx.tnxsample.facade.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.truenewx.tnxjee.web.http.annotation.ResultFilter;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAnonymous;
import org.truenewx.tnxsample.facade.api.CustomerAdminApi;
import org.truenewx.tnxsample.facade.model.entity.Customer;
import org.truenewx.tnxsample.facade.service.CustomerService;

@Api("客户管理")
@RestController
public class CustomerAdminController implements CustomerAdminApi {

    @Autowired
    private CustomerService customerService;

    @Override
    @ApiOperation("根据手机号码加载用户")
    @ConfigAnonymous
    @ResultFilter(type = Customer.class, excluded = { "accountNonExpired", "accountNonLocked",
            "credentialsNonExpired", "enabled", "password" }, pureEnum = "type")
    public Customer loadByMobilePhone(String mobilePhone) {
        return this.customerService.loadByMobilePhone(mobilePhone);
    }

}
