package org.truenewx.tnxsample.admin.service.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.truenewx.tnxsample.facade.api.ManagerCustomerApi;

@FeignClient(name = "manager-customer", url = "localhost:8886")
public interface ManagerCustomerClient extends ManagerCustomerApi {
}
