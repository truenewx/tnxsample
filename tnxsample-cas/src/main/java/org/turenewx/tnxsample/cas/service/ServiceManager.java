package org.turenewx.tnxsample.cas.service;

import org.truenewx.tnxsample.core.model.UserType;

/**
 * 服务管理器
 *
 * @author jianglei
 */
public interface ServiceManager {

    UserType resolveUserType(String service);

    String getAuthenticatedRedirectUrl(String service);

}
