package org.turenewx.tnxsample.cas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.truenewx.tnxjee.web.view.security.config.WebViewSecurityConfigurerSupport;
import org.turenewx.tnxsample.cas.security.CasAuthenticationSuccessHandler;

@Configuration
public class WebSecurityConfig extends WebViewSecurityConfigurerSupport {

    @Bean
    public CasAuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CasAuthenticationSuccessHandler();
    }

}
