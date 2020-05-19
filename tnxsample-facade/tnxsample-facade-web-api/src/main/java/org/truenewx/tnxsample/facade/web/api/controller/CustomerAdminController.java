package org.truenewx.tnxsample.facade.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.truenewx.tnxjee.model.spec.user.security.DefaultUserSpecificDetails;
import org.truenewx.tnxjee.web.http.annotation.ResultFilter;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAnonymous;
import org.truenewx.tnxsample.facade.api.CustomerAdminApi;
import org.truenewx.tnxsample.facade.model.entity.Customer;
import org.truenewx.tnxsample.facade.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("客户管理")
@RestController
@ConfigAnonymous // TODO 暂时匿名
public class CustomerAdminController implements CustomerAdminApi {

    @Autowired
    private CustomerService customerService;

    @Override
    @ApiOperation("根据id获取客户的用户特性细节")
    public DefaultUserSpecificDetails getSpecificDetails(int id) {
        Customer customer = this.customerService.find(id);
        if (customer != null) {
            return customer.getSpecificDetails();
        }
        return null;
    }

    @Override
    @ApiOperation("根据手机号码加载客户")
    @ResultFilter(type = Customer.class, excluded = { "accountNonExpired", "accountNonLocked",
            "credentialsNonExpired", "enabled", "password" }, pureEnum = "type")
    public Customer loadByMobilePhone(String mobilePhone) {
        return this.customerService.loadByMobilePhone(mobilePhone);
    }

}
