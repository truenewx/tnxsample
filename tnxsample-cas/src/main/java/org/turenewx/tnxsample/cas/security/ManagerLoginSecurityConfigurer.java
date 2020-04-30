package org.turenewx.tnxsample.cas.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.truenewx.tnxjee.web.security.config.SecurityLoginConfigurerSupport;
import org.truenewx.tnxjee.web.security.web.authentication.BusinessExceptionAuthenticationFailureHandler;

/**
 * 管理员登录安全配置器
 */
@Component
// 指定AuthenticationProvider实现类
public class ManagerLoginSecurityConfigurer
        extends SecurityLoginConfigurerSupport<ManagerAuthenticationProvider> {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        TypedUsernamePasswordAuthenticationFilter filter = new TypedUsernamePasswordAuthenticationFilter();
        filter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class)); // 固定必须
        filter.setAuthenticationFailureHandler(authenticationFailureHandler()); // 指定登录失败时的处理器
        http.addFilterAt(filter, UsernamePasswordAuthenticationFilter.class);
    }

    private AuthenticationFailureHandler authenticationFailureHandler() {
        BusinessExceptionAuthenticationFailureHandler failureHandler = new BusinessExceptionAuthenticationFailureHandler();
        failureHandler.setApplicationContext(getApplicationContext());
        return failureHandler;
    }

}
