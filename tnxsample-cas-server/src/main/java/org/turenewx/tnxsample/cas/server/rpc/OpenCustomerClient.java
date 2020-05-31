package org.turenewx.tnxsample.cas.server.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.truenewx.tnxsample.facade.api.OpenCustomerApi;

/**
 * 客户开放客户端
 *
 * @author jianglei
 */
@FeignClient(name = "customer-open", url = "localhost:8886")
public interface OpenCustomerClient extends OpenCustomerApi {
}
