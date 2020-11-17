package org.truenewx.tnxsample.cas.web.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.truenewx.tnxjee.model.spec.user.security.UserSpecificDetails;
import org.truenewx.tnxjee.service.spec.user.UserPasswordLoginValidator;
import org.truenewx.tnxsample.cas.web.rpc.CustomerLoginClient;
import org.truenewx.tnxsample.cas.web.rpc.ManagerLoginClient;
import org.truenewx.tnxsample.common.constant.UserTypes;

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
            case UserTypes.MANAGER:
                return this.managerLoginClient.validate(username, password);
            case UserTypes.CUSTOMER:
                return this.customerLoginClient.validate(username, password);
        }
        return null;
    }

}
