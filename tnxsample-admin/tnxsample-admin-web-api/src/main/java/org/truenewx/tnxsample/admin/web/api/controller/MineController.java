package org.truenewx.tnxsample.admin.web.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.truenewx.tnxjee.web.http.annotation.ResultFilter;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAuthority;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.service.ManagerService;
import org.truenewx.tnxsample.admin.service.model.CommandManagerSelf;
import org.truenewx.tnxsample.admin.web.api.util.ProjectWebUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("个人管理")
@RestController
@ConfigAuthority
@RequestMapping("/mine")
public class MineController {
    @Autowired
    private ManagerService managerService;

    @ApiOperation("获取个人信息")
    @GetMapping("/info")
    @ResultFilter(included = { "username", "top", "headImageUrl", "fullName" })
    public Manager info() {
        int managerId = ProjectWebUtil.getManagerId();
        return this.managerService.load(managerId);
    }

    @ApiOperation("修改个人信息")
    @PostMapping("/info")
    public void updateInfo(@Valid @RequestBody CommandManagerSelf command) {
        int managerId = ProjectWebUtil.getManagerId();
        this.managerService.updateSelf(managerId, command);
    }

    @ApiOperation("修改密码")
    @PostMapping("/password")
    public void updatePassword(@RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword) {
        int managerId = ProjectWebUtil.getManagerId();
        this.managerService.updatePassword(managerId, oldPassword, newPassword);
    }

}
