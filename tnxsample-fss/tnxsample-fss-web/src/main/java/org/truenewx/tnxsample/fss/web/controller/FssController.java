package org.truenewx.tnxsample.fss.web.controller;

import org.springframework.stereotype.Controller;
import org.truenewx.tnxjee.model.spec.user.IntegerUserIdentity;
import org.truenewx.tnxjee.web.security.util.SecurityUtil;
import org.truenewx.tnxjeex.fss.web.controller.FssControllerTemplate;
import org.truenewx.tnxsample.fss.service.model.FssType;

@Controller
public class FssController extends FssControllerTemplate<FssType, IntegerUserIdentity> {
    @Override
    protected IntegerUserIdentity getUserIdentity() {
        return SecurityUtil.getAuthorizedUserIdentity();
    }
}
