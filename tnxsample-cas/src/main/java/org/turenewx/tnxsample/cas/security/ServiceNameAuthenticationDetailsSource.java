package org.turenewx.tnxsample.cas.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.stereotype.Component;

@Component
public class ServiceNameAuthenticationDetailsSource implements
        AuthenticationDetailsSource<HttpServletRequest, ServiceNameAuthenticationDetails> {

    @Override
    public ServiceNameAuthenticationDetails buildDetails(HttpServletRequest context) {
        String service = context.getParameter("service");
        return new ServiceNameAuthenticationDetails(service);
    }

}
