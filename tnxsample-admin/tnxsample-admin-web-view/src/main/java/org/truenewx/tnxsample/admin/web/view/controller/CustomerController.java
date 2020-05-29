package org.truenewx.tnxsample.admin.web.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.truenewx.tnxjee.core.caption.Caption;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAuthority;
import org.truenewx.tnxsample.common.CommonConstants;

/**
 * 客户管理
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/list")
    @Caption("查询客户清单")
    @ConfigAuthority(type = CommonConstants.USER_TYPE_MANAGER, permission = "CUSTOMER_LIST")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("/customer/list");
        return mav;
    }

}
