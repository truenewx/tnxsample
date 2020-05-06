package org.turenewx.tnxsample.cas.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 票据管理器
 */
public interface TicketManager {

    String TICKET_GRANTING_TICKET_PREFIX = "TGT-";

    String SERVICE_TICKET_PREFIX = "ST-";

    String getTicketGrantingTicket(HttpServletRequest request);

    String getServiceTicket(HttpServletRequest request, String service);

    boolean isValidServiceTicket(HttpServletRequest request, String service, String ticketId);

    void removeServiceTicket(HttpServletRequest request, String service);
}
