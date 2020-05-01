package org.turenewx.tnxsample.cas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
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
        String userType = this.serviceManager.resolveUserType(service);
        ModelAndView mav = new ModelAndView("/login/" + userType.toLowerCase());
        mav.addObject("userType", userType);
        return mav;
    }

}
