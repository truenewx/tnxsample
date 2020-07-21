package org.truenewx.tnxsample.facade.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.truenewx.tnxjee.model.spec.user.security.DefaultUserSpecificDetails;

/**
 * 客户登录API
 *
 * @author jianglei
 */
@RequestMapping("/customer/login")
public interface CustomerLoginApi {

    @GetMapping("/validate")
    DefaultUserSpecificDetails validate(@RequestParam("username") String username,
            @RequestParam("password") String password);

}
