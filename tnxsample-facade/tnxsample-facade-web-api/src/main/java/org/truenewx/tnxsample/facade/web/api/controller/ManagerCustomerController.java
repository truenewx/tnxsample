package org.truenewx.tnxsample.facade.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.truenewx.tnxjee.core.caption.Caption;
import org.truenewx.tnxjee.web.http.annotation.ResultFilter;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAuthority;
import org.truenewx.tnxsample.common.CommonConstants;
import org.truenewx.tnxsample.facade.api.ManagerCustomerApi;
import org.truenewx.tnxsample.facade.model.entity.Customer;
import org.truenewx.tnxsample.facade.service.CustomerService;

@Caption("客户管理")
@RestController
public class ManagerCustomerController implements ManagerCustomerApi {

    @Autowired
    private CustomerService customerService;

    @Override
    @Caption("根据手机号码加载客户")
    @ConfigAuthority(type = CommonConstants.USER_TYPE_MANAGER)
    @ResultFilter(type = Customer.class, excluded = { "accountNonExpired", "accountNonLocked",
            "credentialsNonExpired", "enabled", "password" }, pureEnum = "type")
    public Customer loadByMobilePhone(String mobilePhone) {
        return this.customerService.loadByMobilePhone(mobilePhone);
    }

}
