package org.truenewx.tnxsample.cas.web.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.truenewx.tnxjee.model.spec.user.security.UserSpecificDetails;
import org.truenewx.tnxjeex.cas.server.security.authentication.CasServerLoginAuthenticator;
import org.truenewx.tnxsample.cas.web.rpc.CustomerLoginClient;
import org.truenewx.tnxsample.cas.web.rpc.ManagerLoginClient;
import org.truenewx.tnxsample.common.constant.UserTypes;

@Component
public class UserLoginAuthenticator implements CasServerLoginAuthenticator<UsernamePasswordAuthenticationToken> {

    @Autowired
    private ManagerLoginClient managerLoginClient;
    @Autowired
    private CustomerLoginClient customerLoginClient;

    @Override
    public UserSpecificDetails<?> authenticate(String userType, String scope,
            UsernamePasswordAuthenticationToken token) {
        String username = (String) token.getPrincipal();
        String password = (String) token.getCredentials();
        switch (userType) {
            case UserTypes.MANAGER:
                return this.managerLoginClient.validate(username, password);
            case UserTypes.CUSTOMER:
                return this.customerLoginClient.validate(username, password);
        }
        return null;
    }

}
