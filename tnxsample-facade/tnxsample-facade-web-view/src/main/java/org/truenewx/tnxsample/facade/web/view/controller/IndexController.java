package org.truenewx.tnxsample.facade.web.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAuthority;

/**
 * 首页
 *
 * @author jianglei
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    @ConfigAuthority
    public String root() {
        return index();
    }

    @RequestMapping("/index")
    @ConfigAuthority
    public String index() {
        return "/index";
    }

}
