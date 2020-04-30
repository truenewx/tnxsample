package org.turenewx.tnxsample.cas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.truenewx.tnxsample.core.model.UserType;
import org.turenewx.tnxsample.cas.service.ServiceManager;

/**
 * 登录控制器
 *
 * @author jianglei
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ServiceManager serviceManager;

    @GetMapping
    public ModelAndView get(@RequestParam("service") String service) {
        UserType userType = this.serviceManager.resolveUserType(service);
        String type = userType.name().toLowerCase();
        ModelAndView mav = new ModelAndView("/login/" + type);
        mav.addObject("type", type);
        return mav;
    }

}
