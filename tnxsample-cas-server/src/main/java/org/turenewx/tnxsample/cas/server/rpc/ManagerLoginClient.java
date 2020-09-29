package org.turenewx.tnxsample.cas.server.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.truenewx.tnxsample.admin.api.ManagerLoginApi;

/**
 * 管理员登录客户端
 *
 * @author jianglei
 */
@FeignClient(name = "manager-login", url = "${tnxjee.common.apps.admin.uri}${tnxjee.common.apps.admin.context-path}")
public interface ManagerLoginClient extends ManagerLoginApi {
}
