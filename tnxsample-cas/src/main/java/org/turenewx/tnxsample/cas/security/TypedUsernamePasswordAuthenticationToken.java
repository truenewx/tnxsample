package org.turenewx.tnxsample.cas.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.truenewx.tnxsample.core.model.UserType;

/**
 * 基于类型的用户名密码鉴权令牌
 *
 * @author jianglei
 */
public class TypedUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private static final long serialVersionUID = 3929984908596471646L;

    private UserType type;

    public TypedUsernamePasswordAuthenticationToken(UserType type, String username,
            String password) {
        super(username, password);
        this.type = type;
    }

    public UserType getType() {
        return this.type;
    }

}
