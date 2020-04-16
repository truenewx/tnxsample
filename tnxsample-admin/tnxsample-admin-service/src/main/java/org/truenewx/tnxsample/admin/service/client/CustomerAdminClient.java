package org.truenewx.tnxsample.admin.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.truenewx.tnxsample.facade.api.CustomerAdminApi;

/**
 * 客户管理API客户端
 *
 * @author jianglei
 */
@FeignClient(name = "user-admin", url = "localhost:8080")
public interface CustomerAdminClient extends CustomerAdminApi {
}
