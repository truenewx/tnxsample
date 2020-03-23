package org.truenewx.tnxsample.facade.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.truenewx.tnxsample.facade.model.entity.User;

/**
 * 用户API
 *
 * @author jianglei
 */
@RequestMapping("/user/admin")
public interface UserAdminApi {

    @GetMapping("/payload/mobile-phone/{mobilePhone}")
    User loadByMobilePhone(@PathVariable String mobilePhone);

}
