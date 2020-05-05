package org.turenewx.tnxsample.cas.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * CAS用户名密码鉴权令牌
 *
 * @author jianglei
 */
public class CasUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private static final long serialVersionUID = 3929984908596471646L;

    private String service;

    public CasUsernamePasswordAuthenticationToken(String service, String username,
            String password) {
        super(username, password);
        this.service = service;
    }

    public String getService() {
        return this.service;
    }

}
