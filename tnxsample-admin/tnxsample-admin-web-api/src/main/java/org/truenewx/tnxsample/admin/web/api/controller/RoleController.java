package org.truenewx.tnxsample.admin.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAuthority;
import org.truenewx.tnxsample.admin.model.entity.Role;
import org.truenewx.tnxsample.admin.service.RoleService;
import org.truenewx.tnxsample.admin.service.model.RoleCommand;
import org.truenewx.tnxsample.common.CommonConstants;

/**
 * 角色管理
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    @ConfigAuthority(type = CommonConstants.USER_TYPE_MANAGER, rank = CommonConstants.MANAGER_RANK_TOP)
    public List<Role> list(@RequestParam(name = "name", required = false) String name) {
        return this.roleService.findByName(name);
    }

    @PostMapping("/add")
    @ConfigAuthority(type = CommonConstants.USER_TYPE_MANAGER, rank = CommonConstants.MANAGER_RANK_TOP)
    public void add(@RequestBody RoleCommand command) {
        this.roleService.add(command);
    }

}
