package org.truenewx.tnxsample.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.truenewx.tnxjee.web.http.annotation.ResultFilter;
import org.truenewx.tnxjee.web.security.config.annotation.ConfigAnonymous;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.model.entity.Role;
import org.truenewx.tnxsample.admin.service.RoleService;

import java.util.Collection;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/role/{id}")
    @ConfigAnonymous
    @ResultFilter(excluded = "managers")
    public Role detail(@PathVariable("id") int id) {
        Role role = this.roleService.load(id);
        Collection<Manager> managers = role.getManagers();
        System.out.println(managers.size());
        return role;
    }

}
