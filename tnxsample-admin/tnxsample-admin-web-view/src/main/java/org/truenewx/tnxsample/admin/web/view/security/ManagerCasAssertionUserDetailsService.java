package org.truenewx.tnxsample.admin.web.view.security;

import org.jasig.cas.client.validation.Assertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.cas.userdetails.AbstractCasAssertionUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.truenewx.tnxjee.model.spec.user.DefaultUserIdentity;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.service.ManagerService;
import org.truenewx.tnxsample.common.CommonConstants;

public class ManagerCasAssertionUserDetailsService extends AbstractCasAssertionUserDetailsService {

    @Autowired
    private ManagerService managerService;

    @Override
    protected UserDetails loadUserDetails(Assertion assertion) {
        DefaultUserIdentity userIdentity = DefaultUserIdentity
                .of(assertion.getPrincipal().getName());
        if (userIdentity != null
                && CommonConstants.USER_TYPE_MANAGER.equals(userIdentity.getType())) {
            Manager manager = this.managerService.findWithRoles(userIdentity.getId());
            if (manager != null) {
                return manager.getSpecificDetails();
            }
        }
        return null;
    }

}
