package org.turenewx.tnxsample.cas.service;

import org.apache.catalina.Manager;
import org.springframework.stereotype.Component;
import org.truenewx.tnxjee.service.exception.BusinessException;

/**
 * 服务管理器实现
 *
 * @author jianglei
 */
@Component
public class ServiceManagerImpl implements ServiceManager {

    @Override
    public String resolveUserType(String service) {
        if ("admin".equals(service)) {
            return Manager.class.getSimpleName().toLowerCase();
        }
        throw new BusinessException("error.user.invalid_service");
    }

    @Override
    public String getAuthenticatedRedirectUrl(String service) {
        if ("admin".equals(service)) {
            return "localhost:8887/admin/login";
        }
        return null;
    }

}
