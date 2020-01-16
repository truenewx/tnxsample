package org.truenewx.tnxsample.admin.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.truenewx.tnxjee.service.api.exception.BusinessException;
import org.truenewx.tnxjee.web.controller.security.authentication.UserSpecificDetailsAuthenticationToken;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.service.ManagerService;

/**
 * 管理员认证提供器
 */
@Component
public class ManagerAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private ManagerService managerService;

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String md5Password = (String) authentication.getCredentials();
        try {
            Manager manager = this.managerService.validateLogin(username, md5Password);
            return new UserSpecificDetailsAuthenticationToken(manager);
        } catch (BusinessException e) {
            throw new BadCredentialsException(e.getLocalizedMessage(), e);
        }
    }

}
