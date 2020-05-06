package org.truenewx.tnxsample.admin.web.view.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;
import org.truenewx.tnxjee.web.security.config.SecurityLoginConfigurerSupport;

/**
 * 管理员登录安全配置器
 */
@Component
// 指定AuthenticationProvider实现类
public class ManagerLoginSecurityConfigurer
        extends SecurityLoginConfigurerSupport<CasAuthenticationProvider> {

    @Override
    // 指定登录授权过滤器实例，如果框架中现有的不满足需要，需自定义一个
    public void configure(HttpSecurity http) throws Exception {
        CasAuthenticationFilter filter = new CasAuthenticationFilter();
        filter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class)); // 固定必须
        http.addFilterAt(filter, filter.getClass());
    }

}
