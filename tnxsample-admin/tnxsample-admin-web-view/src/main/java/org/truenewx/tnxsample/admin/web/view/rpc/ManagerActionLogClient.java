package org.truenewx.tnxsample.admin.web.view.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.truenewx.tnxsample.admin.api.ManagerActionLogApi;

/**
 * 管理员操作日志客户端
 *
 * @author jianglei
 */
@FeignClient(name = "manager-action-log", url = "localhost:8888")
public interface ManagerActionLogClient extends ManagerActionLogApi {

}
