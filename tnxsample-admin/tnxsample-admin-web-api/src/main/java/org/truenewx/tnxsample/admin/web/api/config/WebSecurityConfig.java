package org.truenewx.tnxsample.admin.web.api.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.truenewx.tnxjee.web.security.config.WebSecurityConfigurerSupport;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerSupport {

    @Override
    protected Collection<String> getIgnoringAntPatterns() {
        Collection<String> patterns = super.getIgnoringAntPatterns();
        Collections.addAll(patterns, "/swagger-ui.html", "/webjars/**", "/v2/api-docs",
                "/swagger-resources/**");
        return patterns;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.formLogin().defaultSuccessUrl("/", true);
    }

}
