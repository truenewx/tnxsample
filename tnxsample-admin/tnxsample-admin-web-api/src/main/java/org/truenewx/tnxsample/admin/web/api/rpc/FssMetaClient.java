package org.truenewx.tnxsample.admin.web.api.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.truenewx.tnxjeex.fss.api.FssMetaResolver;

@FeignClient(name = "fss-meta", url = "${host.fss}")
public interface FssMetaClient extends FssMetaResolver {
}
