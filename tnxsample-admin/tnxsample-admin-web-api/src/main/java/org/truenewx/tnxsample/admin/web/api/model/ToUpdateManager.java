package org.truenewx.tnxsample.admin.web.api.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.model.entity.Role;

public class ToUpdateManager {

    private Manager unity;
    private List<Role> selectableRoles;

    public ToUpdateManager(Manager unity) {
        this.unity = unity;
    }

    public Integer getId() {
        return this.unity.getId();
    }

    public String getJobNo() {
        return this.unity.getJobNo();
    }

    @NotBlank
    public String getUsername() {
        return this.unity.getUsername();
    }

    @NotBlank
    public String getFullName() {
        return this.unity.getFullName();
    }

    public List<Integer> getRoleIds() {
        return this.unity.getRoles().stream().map(Role::getId).collect(Collectors.toList());
    }

    public List<Role> getSelectableRoles() {
        return this.selectableRoles;
    }

    public void setSelectableRoles(
            List<Role> selectableRoles) {
        this.selectableRoles = selectableRoles;
    }
}
