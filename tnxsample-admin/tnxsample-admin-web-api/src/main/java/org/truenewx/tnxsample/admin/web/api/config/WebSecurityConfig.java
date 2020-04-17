package org.truenewx.tnxsample.admin.web.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.truenewx.tnxjee.web.security.config.WebSecurityConfigurerSupport;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerSupport {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.formLogin().defaultSuccessUrl("/", true);
    }

}
