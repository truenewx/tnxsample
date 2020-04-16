package org.truenewx.tnxsample.facade.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.truenewx.tnxsample.facade.model.entity.Customer;

/**
 * 客户管理API
 *
 * @author jianglei
 */
@RequestMapping("/api/admin/customer")
public interface CustomerAdminApi {

    @GetMapping("/payload/mobile-phone/{mobilePhone}")
    Customer loadByMobilePhone(@PathVariable String mobilePhone);

}
