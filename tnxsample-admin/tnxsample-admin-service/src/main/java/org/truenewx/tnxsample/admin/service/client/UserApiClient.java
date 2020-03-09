package org.truenewx.tnxsample.admin.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.truenewx.tnxsample.facade.api.UserApi;

/**
 * 用户API客户端
 *
 * @author jianglei
 */
@FeignClient(name = "ms-facade", url = "localhost:8080")
public interface UserApiClient extends UserApi {
}
