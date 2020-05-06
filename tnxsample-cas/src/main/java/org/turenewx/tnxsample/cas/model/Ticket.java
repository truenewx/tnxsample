package org.turenewx.tnxsample.cas.model;

import java.io.Serializable;

/**
 * 票据
 */
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1849802173357172260L;

    private String id;
    private long createTime;
    private long expiredTime;

    public Ticket(String id, long createTime, long expiredTime) {
        this.id = id;
        this.createTime = createTime;
        this.expiredTime = expiredTime;
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
