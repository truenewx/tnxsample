package org.truenewx.tnxsample.fss.web.security;

import org.jasig.cas.client.validation.Assertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.cas.userdetails.AbstractCasAssertionUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.truenewx.tnxjee.core.util.LogUtil;
import org.truenewx.tnxjee.model.spec.user.DefaultUserIdentity;
import org.truenewx.tnxjee.web.security.core.AuthenticationFailureException;
import org.truenewx.tnxsample.common.CommonConstants;
import org.truenewx.tnxsample.fss.web.rpc.CustomerAdminClient;
import org.truenewx.tnxsample.fss.web.rpc.ManagerAdminClient;

@Component
public class UserCasAssertionUserDetailsService extends AbstractCasAssertionUserDetailsService {

    @Autowired
    private ManagerAdminClient managerAdminClient;
    @Autowired
    private CustomerAdminClient customerAdminClient;

    @Override
    protected UserDetails loadUserDetails(Assertion assertion) {
        if (assertion != null && assertion.isValid()) {
            String principal = assertion.getPrincipal().getName();
            DefaultUserIdentity userIdentity = DefaultUserIdentity.of(principal);
            if (userIdentity != null) {
                try {
                    switch (userIdentity.getType()) {
                        case CommonConstants.USER_TYPE_MANAGER:
                            return this.managerAdminClient.getSpecificDetails(userIdentity.getId());
                        case CommonConstants.USER_TYPE_CUSTOMER:
                            return this.customerAdminClient.getSpecificDetails(userIdentity.getId());
                    }
                } catch (Exception e) {
                    LogUtil.error(getClass(), e);
                }
            }
        }
        throw new AuthenticationFailureException();
    }

}
