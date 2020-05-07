package org.turenewx.tnxsample.cas.service;

/**
 * CAS服务器异常错误码集
 */
public class CasServerExceptionCodes {

    private CasServerExceptionCodes() {
    }

    /**
     * 无效的service参数
     */
    public static final String INVALID_SERVICE = "error.cas.server.invalid_service";

    /**
     * 不存在的票据
     */
    public static final String NO_SUCH_SERVICE_TICKET = "error.cas.server.no_such_service_ticket";

    /**
     * 票据过期
     */
    public static final String EXPIRED_SERVICE_TICKET = "error.cas.server.expired_service_ticket";

}
