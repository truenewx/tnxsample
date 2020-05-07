package org.turenewx.tnxsample.cas.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Component;
import org.truenewx.tnxjee.core.Strings;
import org.truenewx.tnxjee.core.util.EncryptUtil;
import org.truenewx.tnxjee.core.util.LogUtil;
import org.truenewx.tnxjee.service.exception.BusinessException;
import org.turenewx.tnxsample.cas.model.ServiceTicket;

/**
 * 票据管理器实现
 */
@Component
public class TicketManagerImpl implements TicketManager, HttpSessionListener {

    private static final String SESSION_SERVICE_TICKETS = TicketManagerImpl.class.getName()
            + ".ServiceTickets";

    @Autowired
    private ServerProperties serverProperties;
    private Map<String, ServiceTicket> serviceTickets = new HashMap<>();

    @Override
    public String getTicketGrantingTicket(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        return TICKET_GRANTING_TICKET_PREFIX + EncryptUtil.encryptByMd5_16(sessionId);
    }

    // 用户从浏览器访问cas服务器时调用，以获取目标服务的票据
    @Override
    public String getServiceTicket(HttpServletRequest request, String service) {
        String sessionId = request.getSession().getId();
        Map.Entry<String, ServiceTicket> entry = this.serviceTickets.entrySet().stream()
                .filter(e -> e.getKey().equals(sessionId)).findAny().orElse(null);
        ServiceTicket ticket = entry == null ? null : entry.getValue();
        long now = System.currentTimeMillis();
        if (ticket == null || ticket.getExpiredTime() <= now) {
            String text = sessionId + Strings.MINUS + service + Strings.MINUS + now;
            String ticketId = SERVICE_TICKET_PREFIX + EncryptUtil.encryptByMd5_16(text);
            long timeout = this.serverProperties.getServlet().getSession().getTimeout().toMillis();
            ticket = new ServiceTicket(sessionId, service, ticketId, now, now + timeout);
            this.serviceTickets.put(sessionId, ticket);
        }
        return ticket.getId();
    }

    // 用户访问业务服务，由业务服务校验票据有效性时调用
    @Override
    public void validateServiceTicket(String service, String ticketId) {
        ServiceTicket ticket = this.serviceTickets.values().stream().filter(t -> {
            return t.getId().equals(ticketId) && t.getService().equals(service);
        }).findAny().orElse(null);
        if (ticket == null || !ticket.getId().equals(ticketId)) {
            throw new BusinessException(CasServerExceptionCodes.NO_SUCH_SERVICE_TICKET, ticketId);
        }
        if (ticket.getExpiredTime() > System.currentTimeMillis()) {
            throw new BusinessException(CasServerExceptionCodes.EXPIRED_SERVICE_TICKET, ticketId);
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        String sessionId = event.getSession().getId();
        ServiceTicket ticket = this.serviceTickets.remove(sessionId);
        if (ticket != null) {
            LogUtil.info(getClass(), "The service ticket({}) has been removed because session destroyed.", ticket.getId());
        }
    }

}
