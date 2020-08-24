package org.truenewx.tnxsample.admin.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.truenewx.tnxjee.model.query.QueryResult;
import org.truenewx.tnxjee.web.http.annotation.ResultFilter;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAuthority;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.model.entity.Role;
import org.truenewx.tnxsample.admin.service.ManagerService;
import org.truenewx.tnxsample.admin.service.RoleService;
import org.truenewx.tnxsample.admin.service.model.ManagerCommand;
import org.truenewx.tnxsample.admin.web.api.model.ToUpdateManager;
import org.truenewx.tnxsample.common.CommonConstants;

/**
 * 管理员管理
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    @ConfigAuthority(type = CommonConstants.USER_TYPE_MANAGER,
            rank = CommonConstants.MANAGER_RANK_TOP)
    @ResultFilter(type = Role.class, included = { "id", "name" })
    public QueryResult<Manager> list(
            @RequestParam(name = "keyword", required = false) String keyword,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(name = "pageNo", defaultValue = "1") int pageNo) {
        return this.managerService.queryGeneral(keyword, pageSize, pageNo);
    }

    @PostMapping("/add")
    @ConfigAuthority(type = CommonConstants.USER_TYPE_MANAGER,
            rank = CommonConstants.MANAGER_RANK_TOP)
    public void add(@RequestBody ManagerCommand command) {
        this.managerService.add(command);
    }

    @GetMapping("/{id}")
    @ConfigAuthority(type = CommonConstants.USER_TYPE_MANAGER,
            rank = CommonConstants.MANAGER_RANK_TOP)
    @ResultFilter(type = Role.class, included = { "id", "name" })
    public Manager detail(@PathVariable("id") int id) {
        return this.managerService.load(id);
    }

    @GetMapping("/{id}/update")
    @ConfigAuthority(type = CommonConstants.USER_TYPE_MANAGER,
            rank = CommonConstants.MANAGER_RANK_TOP)
    @ResultFilter(type = Role.class, included = { "id", "name" })
    public ToUpdateManager toUpdate(@PathVariable("id") int id) {
        Manager manager = this.managerService.load(id);
        ToUpdateManager tum = new ToUpdateManager(manager);
        tum.setSelectableRoles(this.roleService.findAll());
        return tum;
    }

    @PostMapping("/{id}/update")
    @ConfigAuthority(type = CommonConstants.USER_TYPE_MANAGER,
            rank = CommonConstants.MANAGER_RANK_TOP)
    public void update(@PathVariable("id") int id, @RequestBody ManagerCommand command) {
        this.managerService.update(id, command);
    }

    @PostMapping("/{id}/update-disabled")
    @ConfigAuthority(type = CommonConstants.USER_TYPE_MANAGER,
            rank = CommonConstants.MANAGER_RANK_TOP)
    public void updateDisabled(@PathVariable("id") int id,
            @RequestParam("disabled") boolean disabled) {
        this.managerService.updateDisabled(id, disabled);
    }

    @PostMapping("/{id}/reset-password")
    @ConfigAuthority(type = CommonConstants.USER_TYPE_MANAGER,
            rank = CommonConstants.MANAGER_RANK_TOP)
    public void resetPassword(@PathVariable("id") int id,
            @RequestParam("password") String password) {
        this.managerService.resetPassword(id, password);
    }

}
