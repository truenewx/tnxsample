package org.truenewx.tnxsample.facade.web.api.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAnonymous;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

@ApiIgnore
@Controller
public class IndexController {

    private CsrfTokenRepository csrfTokenRepository = new HttpSessionCsrfTokenRepository();

    @GetMapping("/")
    @ConfigAnonymous(intranet = true)
    public String root() {
        return "redirect:/swagger-ui.html";
    }

    /**
     * 解决swagger-ui的/csrf的404问题
     */
    @GetMapping("/csrf")
    @ResponseBody
    @ConfigAnonymous
    public CsrfToken csrf(HttpServletRequest request) {
        return this.csrfTokenRepository.generateToken(request);
    }

}
