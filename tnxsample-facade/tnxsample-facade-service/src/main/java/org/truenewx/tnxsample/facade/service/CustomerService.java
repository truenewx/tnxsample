package org.truenewx.tnxsample.facade.service;

import org.truenewx.tnxjee.service.unity.UnityService;
import org.truenewx.tnxsample.facade.model.entity.Customer;

/**
 * 用户服务
 *
 * @author jianglei
 */
public interface CustomerService extends UnityService<Customer, Integer> {

    Customer loadByMobilePhone(String mobilePhone);

    Customer updateDisabled(int userId, boolean disabled);

}
