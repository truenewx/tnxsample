package org.truenewx.tnxsample.facade.web.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAnonymous;
import org.truenewx.tnxsample.facade.service.CustomerService;
import org.truenewx.tnxsample.facade.web.view.util.ProjectWebUtil;

/**
 * 页面头部
 */
@Controller
public class HeaderController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/header")
    @ConfigAnonymous
    public ModelAndView execute() {
        ModelAndView mav = new ModelAndView("/header");
        Integer customerId = ProjectWebUtil.getCustomerId();
        if (customerId != null) {
            mav.addObject("customer", this.customerService.load(customerId));
        }
        return mav;
    }

}
