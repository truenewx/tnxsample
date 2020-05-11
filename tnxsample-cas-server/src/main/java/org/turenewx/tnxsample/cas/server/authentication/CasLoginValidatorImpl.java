package org.turenewx.tnxsample.cas.server.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.truenewx.tnxjee.model.spec.user.UserIdentity;
import org.truenewx.tnxjeex.cas.server.authentication.CasLoginValidator;
import org.truenewx.tnxsample.common.CommonConstants;
import org.turenewx.tnxsample.cas.server.rpc.ManagerOpenClient;

@Service
public class CasLoginValidatorImpl implements CasLoginValidator {

    @Autowired
    private ManagerOpenClient managerOpenClient;

    @Override
    public UserIdentity<?> validateLogin(String userType, String username, String password) {
        if (CommonConstants.USER_TYPE_MANAGER.equals(userType)) {
            return this.managerOpenClient.validateLogin(username, password);
        }
        return null;
    }
}
