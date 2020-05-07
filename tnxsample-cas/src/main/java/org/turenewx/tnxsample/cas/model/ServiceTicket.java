package org.turenewx.tnxsample.cas.model;

/**
 * 服务票据
 */
public class ServiceTicket {

    private static final long serialVersionUID = 1230199044754886426L;

    private String sessionId;
    private String service;
    private String id;
    private long createTime;
    private long expiredTime;

    public ServiceTicket(String sessionId, String service, String id, long createTime,
            long expiredTime) {
        this.sessionId = sessionId;
        this.service = service;
        this.id = id;
        this.createTime = createTime;
        this.expiredTime = expiredTime;
    }


    public String getSessionId() {
        return this.sessionId;
    }

    public String getService() {
        return this.service;
    }

    public String getId() {
        return this.id;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getExpiredTime() {
        return this.expiredTime;
    }
}
