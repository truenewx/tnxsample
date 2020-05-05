package org.turenewx.tnxsample.cas.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.truenewx.tnxjee.core.util.BeanUtil;
import org.turenewx.tnxsample.cas.service.ServiceManager;

/**
 * CAS用户名密码授权过滤器
 */
public class CasUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private ServerProperties serverProperties;
    private ServiceManager serviceManager;

    public void setServerProperties(ServerProperties serverProperties) {
        this.serverProperties = serverProperties;
    }

    public void setServiceManager(ServiceManager serviceManager) {
        this.serviceManager = serviceManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {
        boolean postOnly = BeanUtil.getFieldValue(this, "postOnly");
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }

        String username = obtainUsername(request);
        String password = obtainPassword(request);

        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }

        username = username.trim();

        String service = request.getParameter("service");
        CasUsernamePasswordAuthenticationToken authRequest = new CasUsernamePasswordAuthenticationToken(service,
                username, password);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return getAuthenticationManager().authenticate(authRequest);
    }

}
