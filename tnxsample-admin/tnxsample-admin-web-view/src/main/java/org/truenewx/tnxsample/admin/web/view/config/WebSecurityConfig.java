package org.truenewx.tnxsample.admin.web.view.config;

import org.jasig.cas.client.validation.Cas20ServiceTicketValidator;
import org.jasig.cas.client.validation.TicketValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.truenewx.tnxjee.web.view.security.config.WebViewSecurityConfigurerSupport;
import org.truenewx.tnxsample.admin.web.view.security.CasAuthenticationUserDetailsService;

@Configuration
public class WebSecurityConfig extends WebViewSecurityConfigurerSupport {

    @Bean
    public CasAuthenticationUserDetailsService authenticationUserDetailsService() {
        return new CasAuthenticationUserDetailsService();
    }

    @Bean
    public TicketValidator ticketValidator() {
        return new Cas20ServiceTicketValidator("http://localhost:8883/cas/");
    }

    @Bean
    public CasAuthenticationProvider authenticationProvider() {
        CasAuthenticationProvider provider = new CasAuthenticationProvider();
        provider.setAuthenticationUserDetailsService(authenticationUserDetailsService());
        provider.setTicketValidator(ticketValidator());
        provider.setKey(getApplicationContext().getEnvironment().getProperty("spring.application.name", "app"));
        return provider;
    }

    @Override
    protected String getLoginFormUrl() {
        return "http://localhost:8883/cas/login?service=admin";
    }

}
