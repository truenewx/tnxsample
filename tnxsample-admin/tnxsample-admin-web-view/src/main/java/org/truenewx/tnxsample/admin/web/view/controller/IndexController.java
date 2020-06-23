package org.truenewx.tnxsample.admin.web.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAuthority;
import org.truenewx.tnxjee.web.view.menu.UserMenuResolver;

/**
 * 首页
 *
 * @author jianglei
 */
@Controller
public class IndexController {

    @Autowired
    private UserMenuResolver menuResolver;

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
