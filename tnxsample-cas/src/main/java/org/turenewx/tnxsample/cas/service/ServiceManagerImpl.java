package org.turenewx.tnxsample.cas.service;

import org.springframework.stereotype.Component;
import org.truenewx.tnxjee.service.exception.BusinessException;
import org.truenewx.tnxsample.core.model.UserType;

/**
 * 服务管理器实现
 *
 * @author jianglei
 */
@Component
public class ServiceManagerImpl implements ServiceManager {

    @Override
    public UserType resolveUserType(String service) {
        if ("admin".equals(service)) {
            return UserType.MANAGER;
        }
        throw new BusinessException("error.user.invalid_service");
    }

    @Override
    public String getAuthenticatedRedirectUrl(String service) {
        if ("admin".equals(service)) {
            return "localhost:8887/admin/login/cas";
        }
        return null;
    }

}
