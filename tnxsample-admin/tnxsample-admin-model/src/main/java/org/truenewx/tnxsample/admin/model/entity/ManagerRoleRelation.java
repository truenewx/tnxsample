package org.truenewx.tnxsample.admin.model.entity;

import org.truenewx.tnxjee.core.caption.Caption;
import org.truenewx.tnxjee.model.entity.relation.AbstractRelation;
import org.truenewx.tnxjee.model.entity.relation.RelationKey;

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
    public static class Key implements RelationKey<Integer, Integer> {

        private static final long serialVersionUID = -7839201529321883683L;

        private int managerId;
        private int roleId;

        @Override
        public Integer getLeft() {
            return this.managerId;
        }

        @Override
        public Integer getRight() {
            return this.roleId;
        }

    }

    private Key id;
    private Manager manager;
    private Role role;

}
