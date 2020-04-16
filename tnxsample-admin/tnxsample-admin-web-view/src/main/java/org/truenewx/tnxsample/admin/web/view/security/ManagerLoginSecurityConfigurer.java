package org.truenewx.tnxsample.admin.web.view.security;

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
public class ManagerLoginSecurityConfigurer extends SecurityLoginConfigurerSupport<ManagerAuthenticationProvider> {

    @Override
    // 指定登录授权过滤器实例，如果框架中现有的不满足需要，需自定义一个
    public void configure(HttpSecurity http) throws Exception {
        UsernamePasswordAuthenticationFilter filter = new UsernamePasswordAuthenticationFilter();
        filter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class)); // 固定必须
        filter.setAuthenticationFailureHandler(authenticationFailureHandler()); // 指定登录失败时的处理器
        http.addFilterAt(filter, filter.getClass());
    }

    // 自定义登录失败处理器
    private AuthenticationFailureHandler authenticationFailureHandler() {
        BusinessExceptionAuthenticationFailureHandler failureHandler = new BusinessExceptionAuthenticationFailureHandler();
        failureHandler.setApplicationContext(getApplicationContext());
        failureHandler.setDefaultFailureUrl("/login");
        failureHandler.setUseForward(true);
        return failureHandler;
    }

}
