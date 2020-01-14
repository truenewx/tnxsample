package org.truenewx.tnxsample.admin.model.domain;

import java.io.Serializable;

import org.truenewx.tnxjee.core.caption.Caption;
import org.truenewx.tnxjee.model.core.relation.AbstractRelation;

import lombok.Getter;
import lombok.Setter;

/**
 * 管理员-角色的关系
 *
 * @author jianglei
 */
@Getter
@Setter
@Caption("管理员-角色的关系")
public class ManagerRoleRelation extends AbstractRelation<Integer, Integer> {

    @Getter
    @Setter
    public static class Key implements Serializable {
        private static final long serialVersionUID = -7839201529321883683L;

        private int roleId;
        private int managerId;
    }

    private Key key;
    private Manager manager;
    private Role role;

    @Override
    public Integer getLeftId() {
        Manager manager = getManager();
        return manager == null ? null : manager.getId();
    }

    @Override
    public Integer getRightId() {
        Role role = getRole();
        return role == null ? null : role.getId();
    }
}
