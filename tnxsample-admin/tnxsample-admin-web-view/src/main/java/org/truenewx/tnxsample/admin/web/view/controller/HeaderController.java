package org.truenewx.tnxsample.admin.web.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAnonymous;
import org.truenewx.tnxsample.admin.web.view.rpc.ManagerAdminClient;
import org.truenewx.tnxsample.admin.web.view.util.ProjectWebUtil;

/**
 * 页面头部
 */
@Controller
public class HeaderController {
    @Autowired
    private ManagerAdminClient managerAdminClient;

    @RequestMapping("/header")
    @ConfigAnonymous
    public ModelAndView execute() {
        ModelAndView mav = new ModelAndView("/header");
        Integer managerId = ProjectWebUtil.getManagerId();
        if (managerId != null) {
            mav.addObject("manager", this.managerAdminClient.getSpecificDetails(managerId));
        }
        return mav;
    }

}
