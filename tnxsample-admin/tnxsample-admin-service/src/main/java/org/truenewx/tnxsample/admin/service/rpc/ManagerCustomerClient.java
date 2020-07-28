package org.truenewx.tnxsample.admin.service.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.truenewx.tnxsample.facade.api.ManagerCustomerApi;

@FeignClient(name = "manager-customer", url = "${host.facade-api}")
public interface ManagerCustomerClient extends ManagerCustomerApi {
}
