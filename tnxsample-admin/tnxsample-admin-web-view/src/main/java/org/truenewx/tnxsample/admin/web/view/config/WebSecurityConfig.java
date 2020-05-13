package org.truenewx.tnxsample.admin.web.view.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.truenewx.tnxjee.web.view.security.config.WebViewSecurityConfigurerSupport;
import org.truenewx.tnxjeex.cas.client.config.CasClientProperties;

@Configuration
public class WebSecurityConfig extends WebViewSecurityConfigurerSupport {

    @Autowired
    private CasClientProperties casClientProperties;

    @Override
    protected String getLoginFormUrl() {
        return this.casClientProperties.getLoginUrl();
    }

}
