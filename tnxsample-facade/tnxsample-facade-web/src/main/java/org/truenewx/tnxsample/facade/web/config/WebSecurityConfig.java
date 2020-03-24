package org.truenewx.tnxsample.facade.web.config;

import org.springframework.context.annotation.Configuration;
import org.truenewx.tnxjee.web.security.config.WebSecurityConfigurerSupport;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerSupport {

    @Override
    protected Collection<String> getAnonymousAntPatterns() {
        Collection<String> patterns = super.getAnonymousAntPatterns();
        Collections.addAll(patterns, "/swagger-ui.html", "/webjars/**", "/swagger-resources/**", "/images/**",
                "/v2/api-docs", "/configuration/ui", "/configuration/security");
        return patterns;
    }

}
