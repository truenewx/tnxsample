package org.turenewx.tnxsample.cas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.truenewx.tnxjee.model.spec.user.DefaultUserIdentity;
import org.truenewx.tnxjee.service.exception.BusinessException;
import org.truenewx.tnxsample.common.CommonConstants;
import org.turenewx.tnxsample.cas.client.ManagerOpenClient;
import org.turenewx.tnxsample.cas.service.ServiceManager;

/**
 * 管理员认证提供器
 */
@Component
public class ManagerAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private ServiceManager serviceManager;
    @Autowired
    private ManagerOpenClient managerOpenClient;

    @Override
    public boolean supports(Class<?> authentication) {
        return CasUsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        CasUsernamePasswordAuthenticationToken token = (CasUsernamePasswordAuthenticationToken) authentication;
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        try {
            DefaultUserIdentity userIdentity = null;
            String service = token.getService();
            String userType = this.serviceManager.resolveUserType(service);
            if (CommonConstants.USER_TYPE_MANAGER.equals(userType)) {
                userIdentity = this.managerOpenClient.validateLogin(username, password);
            }
            if (userIdentity != null) {
                return new CasUserIdentityAuthenticationToken(service, userIdentity);
            }
        } catch (BusinessException e) {
            throw new BadCredentialsException(e.getLocalizedMessage(), e);
        }
        return null;
    }

}
