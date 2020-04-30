package org.turenewx.tnxsample.cas.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.truenewx.tnxjee.core.util.BeanUtil;
import org.truenewx.tnxsample.core.model.UserType;

public class TypedUsernamePasswordAuthenticationFilter extends
        UsernamePasswordAuthenticationFilter {

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

        String type = request.getParameter("type");
        UserType userType = StringUtils.isNotBlank(type) ? UserType.valueOf(type.toUpperCase()) : null;

        TypedUsernamePasswordAuthenticationToken authRequest = new TypedUsernamePasswordAuthenticationToken(userType,
                username, password);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return getAuthenticationManager().authenticate(authRequest);
    }
}
