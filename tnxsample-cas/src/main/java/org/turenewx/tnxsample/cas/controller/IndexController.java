package org.turenewx.tnxsample.cas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.truenewx.tnxjee.service.exception.BusinessException;
import org.truenewx.tnxjee.web.context.SpringWebContext;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAnonymous;
import org.turenewx.tnxsample.cas.service.ServiceManager;
import org.turenewx.tnxsample.cas.service.TicketManager;

/**
 * 登录控制器
 *
 * @author jianglei
 */
@Controller
public class IndexController {

    @Autowired
    private ServiceManager serviceManager;
    @Autowired
    private TicketManager ticketManager;
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/login")
    public ModelAndView toLoginForm(@RequestParam("service") String service) {
        String userType = this.serviceManager.resolveUserType(service);
        ModelAndView mav = new ModelAndView("/login/" + userType.toLowerCase());
        mav.addObject("service", service);
        return mav;
    }

    @GetMapping("/serviceValidate")
    @ConfigAnonymous
    @ResponseBody
    public String serviceValidate(@RequestParam("service") String service,
            @RequestParam("ticket") String ticket) {
        try {
            this.ticketManager.validateServiceTicket(service, ticket);
        } catch (BusinessException e) {
            String message = this.messageSource.getMessage(e.getCode(), e.getArgs(), SpringWebContext.getLocale());
            return "<authenticationFailure>" + message + "</authenticationFailure>";
        }
        return Boolean.TRUE.toString();
    }

}
