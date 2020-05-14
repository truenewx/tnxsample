package org.truenewx.tnxsample.admin.web.api.security;

import org.jasig.cas.client.validation.Assertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.cas.userdetails.AbstractCasAssertionUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.truenewx.tnxjee.model.spec.user.DefaultUserIdentity;
import org.truenewx.tnxjee.service.exception.AuthenticationFailureException;
import org.truenewx.tnxsample.admin.api.ManagerAdminApi;
import org.truenewx.tnxsample.common.CommonConstants;

@Component
public class ManagerCasAssertionUserDetailsService extends AbstractCasAssertionUserDetailsService {

    @Autowired
    private ManagerAdminApi managerAdminApi;

    @Override
    protected UserDetails loadUserDetails(Assertion assertion) {
        if (assertion != null && assertion.isValid()) {
            DefaultUserIdentity userIdentity = DefaultUserIdentity
                    .of(assertion.getPrincipal().getName());
            if (userIdentity != null
                    && CommonConstants.USER_TYPE_MANAGER.equals(userIdentity.getType())) {
                return this.managerAdminApi.getSpecificDetails(userIdentity.getId());
            }
        }
        throw new AuthenticationFailureException();
    }

}
