package org.truenewx.tnxsample.admin.web.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAnonymous;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAuthority;
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
    private UserMenuResolver menuResolver;

    @RequestMapping("/")
    @ConfigAuthority
    public String root() {
        return "/main";
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
        mav.addObject("menu", this.menuResolver.getUserGrantedMenu());
        return mav;
    }

    @GetMapping("/menu/link/indexes")
    @ConfigAuthority
    @ResponseBody
    public List<Integer> menuLinkIndexes(@RequestParam("path") String path) {
        return this.menuResolver.indexesOf(path);
    }

}
