package org.truenewx.tnxsample.admin.web.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAnonymous;
import org.truenewx.tnxsample.admin.service.ManagerService;
import org.truenewx.tnxsample.admin.web.view.util.ProjectWebUtil;

/**
 * 页面头部
 */
@Controller
public class HeaderController {
    @Autowired
    private ManagerService managerService;

    @RequestMapping("/header")
    @ConfigAnonymous
    public ModelAndView execute() {
        ModelAndView mav = new ModelAndView("/header");
        int managerId = ProjectWebUtil.getManagerId();
        mav.addObject("manager", this.managerService.load(managerId));
        return mav;
    }

}
