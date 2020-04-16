package org.truenewx.tnxsample.admin.web.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.truenewx.tnxjee.core.util.EncryptUtil;
import org.truenewx.tnxjee.service.exception.BusinessException;
import org.truenewx.tnxjee.web.security.authentication.UserSpecificDetailsAuthenticationToken;
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
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        if (password != null && password.length() < 32) { // 长度小于32位的密码为原文
            password = EncryptUtil.encryptByMd5(password);
        }
        try {
            Manager manager = this.managerService.validateLogin(username, password);
            return new UserSpecificDetailsAuthenticationToken(manager.getSpecificDetails());
        } catch (BusinessException e) {
            throw new BadCredentialsException(e.getLocalizedMessage(), e);
        }
    }

}
