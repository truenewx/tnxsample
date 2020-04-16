package org.truenewx.tnxsample.admin.web.router;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAnonymous;
import org.truenewx.tnxsample.admin.web.util.ProjectWebUtil;

/**
 * 页面头部
 */
@Controller
public class HeaderRouter {

    @RequestMapping("/header")
    @ConfigAnonymous
    public ModelAndView execute() {
        ModelAndView mav = new ModelAndView("/header");
        mav.addObject("manager", ProjectWebUtil.getManagerDetails());
        return mav;
    }

}
