package org.truenewx.tnxsample.admin.web.config;

import org.springframework.context.annotation.Configuration;
import org.truenewx.tnxjee.web.view.security.config.WebViewSecurityConfigurerSupport;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class WebSecurityConfig extends WebViewSecurityConfigurerSupport {

    @Override
    protected Collection<String> getAnonymousAntPatterns() {
        Collection<String> patterns = super.getAnonymousAntPatterns();
        Collections.addAll(patterns, "/swagger-resources/**", "/images/**", "/v2/api-docs",
                "/configuration/ui", "/configuration/security");
        return patterns;
    }

}
