package org.turenewx.tnxsample.cas.server.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.truenewx.tnxsample.facade.api.CustomerLoginApi;

/**
 * 客户登录客户端
 *
 * @author jianglei
 */
@FeignClient(name = "customer-login", url = "${host.ms.customer-api}")
public interface CustomerLoginClient extends CustomerLoginApi {
}
