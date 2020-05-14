package org.truenewx.tnxsample.admin.web.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Component;
import org.truenewx.tnxjee.web.api.meta.model.ApiMetaProperties;
import org.truenewx.tnxjee.web.security.config.SecurityLoginConfigurerSupport;
import org.truenewx.tnxjeex.cas.client.filter.CasClientAuthenticationFilter;

/**
 * 管理员登录安全配置器
 */
@Component
// 指定AuthenticationProvider实现类
public class ManagerLoginConfigurer
        extends SecurityLoginConfigurerSupport<CasAuthenticationProvider> {

    @Autowired(required = false)
    private ApiMetaProperties apiMetaProperties;
    @Autowired
    private RedirectStrategy redirectStrategy;

    @Override
    // 指定登录授权过滤器实例，如果框架中现有的不满足需要，需自定义一个
    public void configure(HttpSecurity http) throws Exception {
        CasClientAuthenticationFilter filter = new CasClientAuthenticationFilter();
        filter.setRedirectStrategy(this.redirectStrategy);
        filter.setSuccessTargetUrlParameter(this.apiMetaProperties.getLoginSuccessRedirectParameter());
        filter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class)); // 固定必须
        http.addFilterAt(filter, filter.getClass());
    }

}
