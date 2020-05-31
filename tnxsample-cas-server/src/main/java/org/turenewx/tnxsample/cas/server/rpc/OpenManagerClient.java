package org.turenewx.tnxsample.cas.server.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.truenewx.tnxsample.admin.api.OpenManagerApi;

/**
 * 管理员开放客户端
 *
 * @author jianglei
 */
@FeignClient(name = "open-manager", url = "localhost:8888")
public interface OpenManagerClient extends OpenManagerApi {
}
