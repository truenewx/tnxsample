package org.turenewx.tnxsample.cas.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.truenewx.tnxjee.web.util.WebUtil;
import org.truenewx.tnxjee.web.view.util.WebViewUtil;
import org.turenewx.tnxsample.cas.service.ServiceManager;

/**
 * CAS鉴权成功处理器
 */
public class CasAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private ServerProperties serverProperties;
    private ServiceManager serviceManager;

    public void setServerProperties(ServerProperties serverProperties) {
        this.serverProperties = serverProperties;
    }

    public void setServiceManager(ServiceManager serviceManager) {
        this.serviceManager = serviceManager;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        String sessionId = request.getSession().getId();
        int maxAge = (int) this.serverProperties.getServlet().getSession().getTimeout().toSeconds();
        WebUtil.addCookie(request, response, "CASTGC", "TGT-" + sessionId, maxAge);
        CasUserIdentityAuthenticationToken token = (CasUserIdentityAuthenticationToken) authentication;
        String targetUrl = this.serviceManager.getAuthenticatedTargetUrl(token.getService());
        WebViewUtil.redirect(request, response, targetUrl);
    }

}
