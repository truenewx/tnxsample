package org.truenewx.tnxsample.fss.web.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.truenewx.tnxsample.facade.api.CustomerAdminApi;

/**
 * 客户管理客户端
 *
 * @author jianglei
 */
@FeignClient(name = "customer-admin", url = "localhost:8886")
public interface CustomerAdminClient extends CustomerAdminApi {
}
