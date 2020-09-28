package org.truenewx.tnxsample.admin.service.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.truenewx.tnxsample.facade.api.ManagerCustomerApi;

@FeignClient(name = "manager-customer", url = "${tnxjee.common.apps.facade.host}${tnxjee.common.apps.facade.context-path}")
public interface ManagerCustomerClient extends ManagerCustomerApi {
}
