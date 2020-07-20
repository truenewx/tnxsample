package org.truenewx.tnxsample.admin.web.api.controller;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.truenewx.tnxjee.core.caption.Caption;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAuthority;
import org.truenewx.tnxjeex.fss.model.FssFileMeta;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.service.ManagerService;
import org.truenewx.tnxsample.admin.service.model.CommandManagerSelf;
import org.truenewx.tnxsample.admin.web.api.model.BasicManager;
import org.truenewx.tnxsample.admin.web.api.rpc.FssMetaClient;
import org.truenewx.tnxsample.admin.web.api.util.ProjectWebUtil;

@Caption("当前个人管理")
@RestController
@RequestMapping("/manager/self")
public class ManagerSelfController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private FssMetaClient fssMetaClient;

    @Caption("获取个人显示名称")
    @GetMapping("/caption")
    @ConfigAuthority
    public String caption() {
        return loadManager().getCaption();
    }

    private Manager loadManager() {
        int managerId = ProjectWebUtil.getManagerId();
        return this.managerService.load(managerId);
    }

    @Caption("获取个人信息")
    @GetMapping("/info")
    @ConfigAuthority
    public BasicManager info() {
        Manager manager = loadManager();
        BasicManager bm = new BasicManager(manager);
        String headImageUrl = bm.getHeadImageUrl();
        if (StringUtils.isNotBlank(headImageUrl)) {
            String[] storageUrls = { headImageUrl };
            FssFileMeta[] metas = this.fssMetaClient.resolveMetas(storageUrls);
            if (metas.length > 0) {
                bm.setHeadImageFile(metas[0]);
            }
        }
        return bm;
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
