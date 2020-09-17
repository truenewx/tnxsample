package org.turenewx.tnxsample.cas.server.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.truenewx.tnxjee.model.spec.user.security.UserSpecificDetails;
import org.truenewx.tnxjeex.cas.server.authentication.CasLoginValidator;
import org.truenewx.tnxsample.common.CommonConstants;
import org.turenewx.tnxsample.cas.server.rpc.CustomerLoginClient;
import org.turenewx.tnxsample.cas.server.rpc.ManagerLoginClient;

@Service
public class CasLoginValidatorImpl implements CasLoginValidator {

    @Autowired
    private ManagerLoginClient managerLoginClient;
    @Autowired
    private CustomerLoginClient customerLoginClient;

    @Override
    public UserSpecificDetails<?> validateLogin(String userType, String scope, String username,
            String password) {
        switch (userType) {
            case CommonConstants.USER_TYPE_MANAGER:
                return this.managerLoginClient.validate(username, password);
            case CommonConstants.USER_TYPE_CUSTOMER:
                return this.customerLoginClient.validate(username, password);
        }
        return null;
    }
}
