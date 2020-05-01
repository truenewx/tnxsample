package org.turenewx.tnxsample.cas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.truenewx.tnxjee.model.spec.user.DefaultUserIdentity;
import org.truenewx.tnxjee.service.exception.BusinessException;
import org.truenewx.tnxjee.web.security.authentication.UserIdentityAuthenticationToken;
import org.truenewx.tnxsample.common.CommonConstants;
import org.turenewx.tnxsample.cas.client.ManagerOpenClient;

/**
 * 管理员认证提供器
 */
@Component
public class ManagerAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private ManagerOpenClient managerOpenClient;

    @Override
    public boolean supports(Class<?> authentication) {
        return TypedUsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        TypedUsernamePasswordAuthenticationToken token = (TypedUsernamePasswordAuthenticationToken) authentication;
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        try {
            DefaultUserIdentity userIdentity = null;
            String userType = token.getUserType();
            if (CommonConstants.USER_TYPE_MANAGER.equals(userType)) {
                userIdentity = this.managerOpenClient.validateLogin(username, password);
            }
            if (userIdentity != null) {
                return new UserIdentityAuthenticationToken(userIdentity);
            }
        } catch (BusinessException e) {
            throw new BadCredentialsException(e.getLocalizedMessage(), e);
        }
        return null;
    }

}
