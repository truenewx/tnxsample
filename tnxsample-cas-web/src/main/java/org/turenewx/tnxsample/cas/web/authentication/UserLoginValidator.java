package org.turenewx.tnxsample.cas.web.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.truenewx.tnxjee.model.spec.user.security.UserSpecificDetails;
import org.truenewx.tnxjee.service.spec.user.UserPasswordLoginValidator;
import org.truenewx.tnxsample.common.CommonConstants;
import org.turenewx.tnxsample.cas.web.rpc.CustomerLoginClient;
import org.turenewx.tnxsample.cas.web.rpc.ManagerLoginClient;

@Service
public class UserLoginValidator implements UserPasswordLoginValidator {

    @Autowired
    private ManagerLoginClient managerLoginClient;
    @Autowired
    private CustomerLoginClient customerLoginClient;

    @Override
    public UserSpecificDetails<?> validatePasswordLogin(String userType, String scope, String username,
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
