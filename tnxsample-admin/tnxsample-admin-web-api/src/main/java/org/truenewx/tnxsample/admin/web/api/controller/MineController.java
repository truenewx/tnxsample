package org.truenewx.tnxsample.admin.web.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.truenewx.tnxjee.core.caption.Caption;
import org.truenewx.tnxjee.web.http.annotation.ResultFilter;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAuthority;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.service.ManagerService;
import org.truenewx.tnxsample.admin.service.model.CommandManagerSelf;
import org.truenewx.tnxsample.admin.web.api.util.ProjectWebUtil;

@Caption("个人管理")
@RestController
@RequestMapping("/mine")
public class MineController {
    @Autowired
    private ManagerService managerService;

    @Caption("获取个人信息")
    @GetMapping("/info")
    @ConfigAuthority
    @ResultFilter(included = { "username", "top", "headImageUrl", "fullName" })
    public Manager info() {
        int managerId = ProjectWebUtil.getManagerId();
        return this.managerService.load(managerId);
    }

    @Caption("修改个人信息")
    @ConfigAuthority
    @PostMapping("/info")
    public void updateInfo(@Valid @RequestBody CommandManagerSelf command) {
        int managerId = ProjectWebUtil.getManagerId();
        this.managerService.updateSelf(managerId, command);
    }

    @Caption("修改密码")
    @ConfigAuthority
    @PostMapping("/password")
    public void updatePassword(@RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword) {
        int managerId = ProjectWebUtil.getManagerId();
        this.managerService.updatePassword(managerId, oldPassword, newPassword);
    }

}
