package org.truenewx.tnxsample.fss.web.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.truenewx.tnxsample.admin.api.ManagerAdminApi;

/**
 * 管理员管理客户端
 */
@FeignClient(name = "manager-admin", url = "localhost:8888")
public interface ManagerAdminClient extends ManagerAdminApi {
}
