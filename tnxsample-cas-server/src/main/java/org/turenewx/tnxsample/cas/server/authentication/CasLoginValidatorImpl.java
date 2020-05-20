package org.turenewx.tnxsample.cas.server.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.truenewx.tnxjee.model.spec.user.security.UserSpecificDetails;
import org.truenewx.tnxjeex.cas.server.authentication.CasLoginValidator;
import org.truenewx.tnxsample.common.CommonConstants;
import org.turenewx.tnxsample.cas.server.rpc.CustomerOpenClient;
import org.turenewx.tnxsample.cas.server.rpc.ManagerOpenClient;

@Service
public class CasLoginValidatorImpl implements CasLoginValidator {

    @Autowired
    private ManagerOpenClient managerOpenClient;
    @Autowired
    private CustomerOpenClient customerOpenClient;

    @Override
    public UserSpecificDetails<?> validateLogin(String userType, String username, String password) {
        switch (userType) {
            case CommonConstants.USER_TYPE_MANAGER:
                return this.managerOpenClient.validateLogin(username, password);
            case CommonConstants.USER_TYPE_CUSTOMER:
                return this.customerOpenClient.validateLogin(username, password);
        }
        return null;
    }
}
