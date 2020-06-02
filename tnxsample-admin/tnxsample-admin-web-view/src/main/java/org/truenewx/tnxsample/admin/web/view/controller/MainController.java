package org.truenewx.tnxsample.admin.web.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAnonymous;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAuthority;
import org.truenewx.tnxjee.web.view.menu.MenuManager;
import org.truenewx.tnxjee.web.view.menu.UserMenuResolver;
import org.truenewx.tnxsample.admin.web.view.util.ProjectWebUtil;

/**
 * 主页
 *
 * @author jianglei
 */
@Controller
public class MainController {
    @Autowired
    private MenuManager menuManager;
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

    @RequestMapping("/header")
    @ConfigAnonymous
    public ModelAndView header() {
        ModelAndView mav = new ModelAndView("/header");
        Integer managerId = ProjectWebUtil.getManagerId();
        if (managerId != null) {
            mav.addObject("manager", ProjectWebUtil.getManagerDetails());
        }
        return mav;
    }

    @RequestMapping("/menu")
    @ConfigAuthority
    public ModelAndView menu() {
        ModelAndView mav = new ModelAndView("/menu");
        mav.addObject("menu", this.menuManager.getFullMenu());
        return mav;
    }

}
