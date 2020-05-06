package org.turenewx.tnxsample.cas.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Component;
import org.truenewx.tnxjee.core.Strings;
import org.truenewx.tnxjee.core.util.EncryptUtil;
import org.turenewx.tnxsample.cas.model.Ticket;

/**
 * 票据管理器实现
 */
@Component
public class TicketManagerImpl implements TicketManager {

    private static final String SESSION_SERVICE_TICKETS = TicketManagerImpl.class.getName()
            + ".ServiceTickets";

    @Autowired
    private ServerProperties serverProperties;

    @Override
    public String getTicketGrantingTicket(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        return TICKET_GRANTING_TICKET_PREFIX + EncryptUtil.encryptByMd5_16(sessionId);
    }

    @Override
    public String getServiceTicket(HttpServletRequest request, String service) {
        Map<String, Ticket> tickets = getServiceTickets(request, true);
        Ticket ticket = tickets.get(service);
        long now = System.currentTimeMillis();
        if (ticket == null || ticket.getExpiredTime() <= now) {
            String sessionId = request.getSession().getId();
            String text = sessionId + Strings.MINUS + service + Strings.MINUS + now;
            String ticketId = SERVICE_TICKET_PREFIX + EncryptUtil.encryptByMd5_16(text);
            long timeout = this.serverProperties.getServlet().getSession().getTimeout().toMillis();
            ticket = new Ticket(ticketId, now, now + timeout);
        }
        return ticket.getId();
    }

    @SuppressWarnings("unchecked")
    private Map<String, Ticket> getServiceTickets(HttpServletRequest request, boolean create) {
        HttpSession session = request.getSession();
        Map<String, Ticket> tickets = (Map<String, Ticket>) session
                .getAttribute(SESSION_SERVICE_TICKETS);
        if (tickets == null && create) {
            tickets = new HashMap<>();
            session.setAttribute(SESSION_SERVICE_TICKETS, tickets);
        }
        return tickets;
    }

    @Override
    public boolean isValidServiceTicket(HttpServletRequest request, String service,
            String ticketId) {
        Map<String, Ticket> tickets = getServiceTickets(request, false);
        if (tickets != null) {
            Ticket ticket = tickets.get(service);
            return ticket != null && ticket.getId().equals(ticketId)
                    && ticket.getExpiredTime() > System.currentTimeMillis();
        }
        return false;
    }

    @Override
    public void removeServiceTicket(HttpServletRequest request, String service) {
        Map<String, Ticket> tickets = getServiceTickets(request, false);
        if (tickets != null) {
            tickets.remove(service);
        }
    }

}
