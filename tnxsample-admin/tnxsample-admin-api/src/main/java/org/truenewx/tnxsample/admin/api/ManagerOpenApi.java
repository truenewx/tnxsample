package org.truenewx.tnxsample.admin.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.truenewx.tnxjee.model.spec.user.security.DefaultUserSpecificDetails;

/**
 * 管理员开放API
 *
 * @author jianglei
 */
@RequestMapping("/open/manager")
public interface ManagerOpenApi {

    @GetMapping("/validate-login")
    DefaultUserSpecificDetails validateLogin(@RequestParam("username") String username,
            @RequestParam("password") String password);

}
