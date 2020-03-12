package org.truenewx.tnxsample.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.truenewx.tnxjee.web.controller.security.config.annotation.ConfigAnonymous;
import org.truenewx.tnxjee.web.controller.security.util.SecurityUtil;
import org.truenewx.tnxjee.web.view.menu.model.Menu;
import org.truenewx.tnxjee.web.view.menu.provider.MenuProvider;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.web.util.ProjectWebUtil;

/**
 * 页面头部
 */
@Controller
public class HeaderController {
    @Autowired
    private MenuProvider menuProvider;

    @RequestMapping("/header")
    @ConfigAnonymous
    public ModelAndView execute() {
        ModelAndView mav = new ModelAndView("/header");
        Menu grantedMenu = this.menuProvider.getGrantedMenu(SecurityUtil.getGrantedAuthorities());
        Manager manager = ProjectWebUtil.getManager();
        if (manager != null) {
            Menu menu = this.menuProvider.getGrantedMenu(manager.getAuthorities());
            mav.addObject("menu", menu);
        }
        return mav;
    }

}
