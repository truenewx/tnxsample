package org.truenewx.tnxsample.facade.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.truenewx.tnxjee.model.spec.user.security.DefaultUserSpecificDetails;

/**
 * 客户开放API
 *
 * @author jianglei
 */
@RequestMapping("/open/customer")
public interface CustomerOpenApi {

    @GetMapping("/validate-login")
    DefaultUserSpecificDetails validateLogin(@RequestParam("username") String username,
            @RequestParam("password") String password);

}
