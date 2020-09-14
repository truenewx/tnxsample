package org.truenewx.tnxsample.facade.web.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.truenewx.tnxjee.web.security.config.WebSecurityConfigurerSupport;
import org.truenewx.tnxjeex.cas.client.config.CasClientProperties;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerSupport {

    @Autowired
    private CasClientProperties casClientProperties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.formLogin().defaultSuccessUrl("/");
    }

    @Override
    public String getLoginFormUrl() {
        return this.casClientProperties.getLoginFormUrl();
    }

    @Override
    public String getLoginAjaxUrl() {
        return this.casClientProperties.getLoginAjaxUrl();
    }

    @Override
    protected String getLogoutSuccessUrl() {
        return this.casClientProperties.getLogoutUrl();
    }
}
