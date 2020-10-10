package org.truenewx.tnxsample.root.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.truenewx.tnxjee.core.api.RpcApi;
import org.truenewx.tnxjee.model.spec.user.security.DefaultUserSpecificDetails;

/**
 * 客户登录API
 *
 * @author jianglei
 */
@RpcApi
@RequestMapping("/login/customer")
public interface CustomerLoginApi {

    @GetMapping("/validate")
    DefaultUserSpecificDetails validate(@RequestParam("username") String username,
            @RequestParam("password") String password);

}
