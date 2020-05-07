package org.turenewx.tnxsample.cas.service;

import org.springframework.stereotype.Component;
import org.truenewx.tnxjee.service.exception.BusinessException;
import org.truenewx.tnxsample.common.CommonConstants;

/**
 * 服务管理器实现
 *
 * @author jianglei
 */
@Component
public class ServiceManagerImpl implements ServiceManager {

    @Override
    public String resolveUserType(String service) {
        switch (service) {
            case CommonConstants.APP_FACADE:
                return CommonConstants.USER_TYPE_CUSTOMER;
            case CommonConstants.APP_ADMIN:
                return CommonConstants.USER_TYPE_MANAGER;
        }
        throw new BusinessException(CasServerExceptionCodes.INVALID_SERVICE);
    }

    @Override
    public String getAuthenticatedTargetUrl(String service) {
        switch (service) {
            case CommonConstants.APP_FACADE:
                return "http://localhost:8885/login/cas";
            case CommonConstants.APP_ADMIN:
                return "http://localhost:8887/admin/login/cas";
        }
        return null;
    }

}
