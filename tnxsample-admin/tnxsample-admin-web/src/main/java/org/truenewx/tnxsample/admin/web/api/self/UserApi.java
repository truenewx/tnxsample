package org.truenewx.tnxsample.admin.web.api.self;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAnonymous;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAuthority;
import org.truenewx.tnxsample.facade.model.entity.User;

/**
 * 用户管理
 */
@Controller
@RequestMapping("/user")
public class UserApi {

    @GetMapping("/list")
    @ConfigAuthority(permission = "USER_LIST")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("/user/list");
        return mav;
    }

    @GetMapping("/{id}")
    @ConfigAnonymous(regex = "/user/\\d+")
    public ModelAndView detail(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView("/user/detail");
        return mav;
    }

    @GetMapping("/{id}/update")
    public ModelAndView toUpdate(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView("/user/update");
        return mav;
    }

    @PostMapping("/{id}/update")
    @ConfigAnonymous
    public ModelAndView update(@PathVariable("id") int id, User user) {
        ModelAndView mav = new ModelAndView("redirect:/user/list");
        return mav;
    }

}
