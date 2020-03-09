package org.truenewx.tnxsample.facade.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.truenewx.tnxsample.facade.model.entity.User;

/**
 * 用户API
 *
 * @author jianglei
 */
@RequestMapping("/user")
public interface UserApi {

    @GetMapping("/loadByMobilePhone")
    User loadByMobilePhone(@RequestParam("mobilePhone") String mobilePhone);

}
