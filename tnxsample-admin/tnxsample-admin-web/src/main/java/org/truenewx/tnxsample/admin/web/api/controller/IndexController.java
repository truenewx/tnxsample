package org.truenewx.tnxsample.admin.web.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAnonymous;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class IndexController {

    @GetMapping("/")
    @ConfigAnonymous(intranet = true)
    public String root() {
        return "redirect:/swagger-ui.html";
    }

}
