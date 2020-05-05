package org.turenewx.tnxsample.cas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.truenewx.tnxjee.web.security.config.SecurityLoginConfigurerSupport;
import org.truenewx.tnxjee.web.security.web.authentication.BusinessExceptionAuthenticationFailureHandler;
import org.turenewx.tnxsample.cas.service.ServiceManager;

/**
 * 管理员登录安全配置器
 */
@Component
// 指定AuthenticationProvider实现类
public class ManagerLoginSecurityConfigurer
        extends SecurityLoginConfigurerSupport<ManagerAuthenticationProvider> {

    @Autowired
    private ServerProperties serverProperties;
    @Autowired
    private ServiceManager serviceManager;

    public CasAuthenticationSuccessHandler authenticationSuccessHandler() {
        CasAuthenticationSuccessHandler successHandler = new CasAuthenticationSuccessHandler();
        successHandler.setServerProperties(this.serverProperties);
        successHandler.setServiceManager(this.serviceManager);
        return successHandler;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        CasUsernamePasswordAuthenticationFilter filter = new CasUsernamePasswordAuthenticationFilter();
        filter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class)); // 固定必须
        filter.setAuthenticationSuccessHandler(authenticationSuccessHandler()); // 指定登录成功时的处理器
        filter.setAuthenticationFailureHandler(authenticationFailureHandler()); // 指定登录失败时的处理器
        http.addFilterAt(filter, UsernamePasswordAuthenticationFilter.class);
    }

    private AuthenticationFailureHandler authenticationFailureHandler() {
        BusinessExceptionAuthenticationFailureHandler failureHandler = new BusinessExceptionAuthenticationFailureHandler();
        failureHandler.setApplicationContext(getApplicationContext());
        return failureHandler;
    }

}
