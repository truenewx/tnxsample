package org.turenewx.tnxsample.cas.security;

import java.io.Serializable;

public class ServiceNameAuthenticationDetails implements Serializable {

    private static final long serialVersionUID = -8966249391535990582L;
    private String service;

    public ServiceNameAuthenticationDetails(String service) {
        this.service = service;
    }

    public String getService() {
        return this.service;
    }

}
