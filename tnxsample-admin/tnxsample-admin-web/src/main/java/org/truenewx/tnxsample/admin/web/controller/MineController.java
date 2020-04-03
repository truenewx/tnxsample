package org.truenewx.tnxsample.admin.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAuthority;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.service.ManagerService;
import org.truenewx.tnxsample.admin.service.model.CommandManagerSelf;
import org.truenewx.tnxsample.admin.web.util.ProjectWebUtil;

import javax.validation.Valid;

@Api("个人管理")
@Controller
@RequestMapping("/mine")
public class MineController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/info")
    @ConfigAuthority
    public String toUpdateInfo() {
        return "/mine/info";
    }

    @GetMapping("/info/detail")
    @ResponseBody
    @ConfigAuthority
    public Manager infoDetail() {
        return ProjectWebUtil.getManager();
    }

    @ApiOperation("修改个人信息")
    @PostMapping("/info")
    @ConfigAuthority
    @ResponseBody
    public void updateInfo(@Valid @RequestBody CommandManagerSelf command) {
        int managerId = ProjectWebUtil.getManagerId();
        this.managerService.updateSelf(managerId, command);
    }

}
