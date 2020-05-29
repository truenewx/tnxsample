package org.truenewx.tnxsample.admin.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.truenewx.tnxsample.admin.model.entity.Action;

/**
 * 管理员操作日志API
 *
 * @author jianglei
 */
@RequestMapping("/manager/action-log")
public interface ManagerActionLogApi {

    @PostMapping("/add")
    void add(@RequestBody Action action);

}
