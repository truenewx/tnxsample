package org.turenewx.tnxsample.cas.server.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.truenewx.tnxsample.facade.api.CustomerOpenApi;

/**
 * 客户开放客户端
 *
 * @author jianglei
 */
@FeignClient(name = "customer-open", url = "localhost:8886")
public interface CustomerOpenClient extends CustomerOpenApi {
}
