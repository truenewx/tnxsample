package org.truenewx.tnxsample.admin.web.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.truenewx.tnxjee.core.caption.Caption;
import org.truenewx.tnxjee.webmvc.security.config.annotation.ConfigAuthority;
import org.truenewx.tnxjeex.fss.model.FssFileMeta;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.service.ManagerService;
import org.truenewx.tnxsample.admin.service.model.ManagerSelfCommand;
import org.truenewx.tnxsample.admin.web.model.BasicManager;
import org.truenewx.tnxsample.admin.web.rpc.FssMetaClient;
import org.truenewx.tnxsample.admin.web.util.ProjectWebUtil;

@Caption("当前个人管理")
@RestController
@RequestMapping("/manager/self")
public class ManagerSelfController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private FssMetaClient fssMetaClient;

    @Caption("获取个人已获权限集")
    @GetMapping("/authorities")
    @ConfigAuthority
    public Collection<? extends GrantedAuthority> authorities() {
        return loadManager().getAuthorities();
    }

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
    public void updateInfo(@Valid @RequestBody ManagerSelfCommand command) {
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
