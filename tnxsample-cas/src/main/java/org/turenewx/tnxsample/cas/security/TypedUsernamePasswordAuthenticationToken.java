package org.turenewx.tnxsample.cas.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * 基于类型的用户名密码鉴权令牌
 *
 * @author jianglei
 */
public class TypedUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private static final long serialVersionUID = 3929984908596471646L;

    private String userType;

    public TypedUsernamePasswordAuthenticationToken(String userType, String username,
            String password) {
        super(username, password);
        this.userType = userType;
    }

    public String getUserType() {
        return this.userType;
    }
}
