package org.truenewx.tnxsample.admin.web.view.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.truenewx.tnxjee.web.view.security.config.WebViewSecurityConfigurerSupport;
import org.truenewx.tnxjeex.cas.client.config.CasClientProperties;
import org.truenewx.tnxsample.admin.web.view.security.ManagerCasAssertionUserDetailsService;

@Configuration
public class WebSecurityConfig extends WebViewSecurityConfigurerSupport {

    @Autowired
    private CasClientProperties casClientProperties;

    @Bean
    public ManagerCasAssertionUserDetailsService authenticationUserDetailsService() {
        return new ManagerCasAssertionUserDetailsService();
    }

    @Override
    protected String getLoginFormUrl() {
        return this.casClientProperties.getLoginFormUrl();
    }

}
