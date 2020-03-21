package org.truenewx.tnxsample.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAuthority;
import org.truenewx.tnxsample.admin.web.util.ProjectWebUtil;

/**
 * 个人资料
 */
@Controller
@RequestMapping("/mine")
public class MineController {

    @GetMapping("/info")
    @ConfigAuthority
    public ModelAndView toUpdateInfo() {
        ModelAndView mav = new ModelAndView("/mine/info");
        mav.addObject("manager", ProjectWebUtil.getManager());
        return mav;
    }

}
