package org.truenewx.tnxsample.admin.web.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.truenewx.tnxjee.web.http.annotation.ResultFilter;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAuthority;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.service.ManagerService;
import org.truenewx.tnxsample.admin.service.model.CommandManagerSelf;
import org.truenewx.tnxsample.admin.web.util.ProjectWebUtil;

import javax.validation.Valid;

@Api("个人管理")
@RestController
@RequestMapping("/api/mine")
public class MineApi {
    @Autowired
    private ManagerService managerService;

    @ApiOperation("获取个人信息")
    @GetMapping("/info")
    @ConfigAuthority
    @ResultFilter(included = { "username", "top", "headImageUrl", "fullName" })
    public Manager info() {
        return ProjectWebUtil.getManager();
    }

    @ApiOperation("修改个人信息")
    @PostMapping("/info")
    @ConfigAuthority
    public void updateInfo(@Valid @RequestBody CommandManagerSelf command) {
        int managerId = ProjectWebUtil.getManagerId();
        this.managerService.updateSelf(managerId, command);
    }

}
