package org.truenewx.tnxsample.admin.web.api.config;

import org.springframework.context.annotation.Configuration;
import org.truenewx.tnxjee.web.security.config.WebSecurityConfigurerSupport;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerSupport {

    @Override
    protected Collection<String> getIgnoringAntPatterns() {
        Collection<String> patterns = super.getIgnoringAntPatterns();
        Collections.addAll(patterns, "/swagger-ui.html", "/webjars/**", "/v2/api-docs",
                "/swagger-resources/**");
        return patterns;
    }

}
