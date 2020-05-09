package org.turenewx.tnxsample.cas.service;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.authentication.AttributePrincipalImpl;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.AssertionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Component;
import org.truenewx.tnxjee.core.Strings;
import org.truenewx.tnxjee.core.util.EncryptUtil;
import org.truenewx.tnxjee.core.util.LogUtil;
import org.truenewx.tnxjee.model.spec.user.UserIdentity;
import org.truenewx.tnxjee.web.security.util.SecurityUtil;
import org.turenewx.tnxsample.cas.model.ServiceTicket;

/**
 * 票据管理器实现
 */
@Component
public class TicketManagerImpl implements TicketManager, HttpSessionListener {

    @Autowired
    private ServerProperties serverProperties;
    private Map<String, ServiceTicket> serviceTickets = new HashMap<>();

    @Override
    public String getTicketGrantingTicket(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        return TICKET_GRANTING_TICKET_PREFIX + EncryptUtil.encryptByMd5_16(sessionId);
    }

    // 用户从浏览器登录CAS服务器成功后调用，以获取目标服务的票据
    @Override
    public String getServiceTicket(HttpServletRequest request, String service) {
        String sessionId = request.getSession().getId();
        Map.Entry<String, ServiceTicket> entry = this.serviceTickets.entrySet().stream()
                .filter(e -> e.getKey().equals(sessionId)).findAny().orElse(null);
        ServiceTicket ticket = entry == null ? null : entry.getValue();
        Date now = new Date();
        if (ticket == null || ticket.getExpiredTime().before(now)) { // 不存在或已过期，则创建新的
            String text = sessionId + Strings.MINUS + service + Strings.MINUS + now.getTime();
            String ticketId = SERVICE_TICKET_PREFIX + EncryptUtil.encryptByMd5_16(text);
            UserIdentity<?> userIdentity = SecurityUtil.getAuthorizedUserIdentity();
            long timeout = this.serverProperties.getServlet().getSession().getTimeout().toMillis();
            Date expiredTime = new Date(now.getTime() + timeout);
            ticket = new ServiceTicket(sessionId, userIdentity, service, ticketId, now,
                    expiredTime);
            this.serviceTickets.put(sessionId, ticket);
        }
        return ticket.getId();
    }

    // 用户访问业务服务，由业务服务校验票据有效性时调用
    @Override
    public Assertion validateServiceTicket(String service, String ticketId) {
        ServiceTicket ticket = this.serviceTickets.values().stream().filter(t -> {
            return t.getId().equals(ticketId) && t.getService().equals(service);
        }).findAny().orElse(null);
        if (ticket == null) {
            return null;
        }
        String userIdentity = ticket.getUserIdentity().toString();
        AttributePrincipal principal = new AttributePrincipalImpl(userIdentity);
        return new AssertionImpl(principal, ticket.getCreateTime(), ticket.getExpiredTime(),
                ticket.getCreateTime(), Collections.emptyMap());
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        String sessionId = event.getSession().getId();
        ServiceTicket ticket = this.serviceTickets.remove(sessionId);
        if (ticket != null) {
            LogUtil.info(getClass(),
                    "The service ticket({}) has been removed because session destroyed.",
                    ticket.getId());
        }
    }

}
