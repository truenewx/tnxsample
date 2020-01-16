package org.truenewx.tnxsample.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.truenewx.tnxjee.web.controller.security.config.annotation.ConfigAuthority;

/**
 * 首页
 *
 * @author jianglei
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    @ConfigAuthority
    public ModelAndView root() {
        return index();
    }

    @RequestMapping("/index")
    @ConfigAuthority
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("/index");
        mav.addObject("amount", 123.45);
        mav.addObject("mobilePhone", "13812345678");
        return mav;
    }

}
