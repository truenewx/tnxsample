package org.truenewx.tnxsample.fss.web.controller;

import org.springframework.stereotype.Controller;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAnonymous;
import org.truenewx.tnxjee.web.security.util.SecurityUtil;
import org.truenewx.tnxjeex.fss.web.controller.FssControllerTemplate;
import org.truenewx.tnxsample.core.model.TypedUserIdentity;
import org.truenewx.tnxsample.fss.service.model.FssType;

@Controller
@ConfigAnonymous
public class FssController extends FssControllerTemplate<FssType, TypedUserIdentity> {
    @Override
    protected TypedUserIdentity getUserIdentity() {
        return SecurityUtil.getAuthorizedUserIdentity();
    }
}
