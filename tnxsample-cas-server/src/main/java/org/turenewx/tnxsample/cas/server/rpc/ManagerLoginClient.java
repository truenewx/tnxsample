package org.turenewx.tnxsample.cas.server.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.truenewx.tnxsample.admin.api.ManagerLoginApi;

/**
 * 管理员登录客户端
 *
 * @author jianglei
 */
@FeignClient(name = "manager-login", url = "localhost:8888")
public interface ManagerLoginClient extends ManagerLoginApi {
}
