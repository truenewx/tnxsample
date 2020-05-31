package org.truenewx.tnxsample.admin.service.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.truenewx.tnxsample.facade.api.ManagerCustomerApi;

/**
 * 客户管理客户端
 *
 * @author jianglei
 */
@FeignClient(name = "customer-admin", url = "localhost:8886")
public interface ManagerCustomerClient extends ManagerCustomerApi {
}
