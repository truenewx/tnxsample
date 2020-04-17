package org.truenewx.tnxsample.admin.web.view.config;

import org.springframework.context.annotation.Configuration;
import org.truenewx.tnxjee.web.view.security.config.WebViewSecurityConfigurerSupport;

@Configuration
public class WebSecurityConfig extends WebViewSecurityConfigurerSupport {
    @Override
    protected boolean allowedCrossDomainRequest() {
        return true;
    }
}
