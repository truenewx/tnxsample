package org.truenewx.tnxsample.admin.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.truenewx.tnxjee.model.query.QueryResult;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAuthority;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.service.ManagerService;
import org.truenewx.tnxsample.common.CommonConstants;

/**
 * 管理员管理
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/list")
    @ConfigAuthority(type = CommonConstants.USER_TYPE_MANAGER, rank = CommonConstants.MANAGER_RANK_TOP)
    public QueryResult<Manager> list(
            @RequestParam(name = "keyword", required = false) String keyword,
            @RequestParam(name = "pageSize", defaultValue = "20") int pageSize,
            @RequestParam(name = "pageNo", defaultValue = "1") int pageNo) {
        return this.managerService.queryGeneral(keyword, pageSize, pageNo);
    }

}
