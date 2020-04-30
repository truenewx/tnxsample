package org.turenewx.tnxsample.cas.service;

/**
 * 服务管理器
 *
 * @author jianglei
 */
public interface ServiceManager {

    String resolveUserType(String service);

    String getAuthenticatedRedirectUrl(String service);

}
