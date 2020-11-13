package org.truenewx.tnxsample.cas.web.controller;

import org.springframework.stereotype.Controller;
import org.truenewx.tnxjeex.cas.server.controller.CasLoginControllerSupport;

@Controller
public class LoginController extends CasLoginControllerSupport {

    @Override
    protected String getDefaultService() {
        return "admin";
    }

}
