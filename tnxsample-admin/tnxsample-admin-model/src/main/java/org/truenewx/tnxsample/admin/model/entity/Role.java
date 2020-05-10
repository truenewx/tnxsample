package org.truenewx.tnxsample.admin.model.entity;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import javax.validation.constraints.NotBlank;

import org.truenewx.tnxjee.core.caption.Caption;
import org.truenewx.tnxjee.model.entity.unity.Unity;
import org.truenewx.tnxjee.model.validation.constraint.NotContainsSpecialChars;

import lombok.Getter;
import lombok.Setter;

/**
 * 角色
 *
 * @author jianglei
 */
@Getter
@Setter
@Caption("角色")
public class Role implements Unity<Integer>, Comparable<Role> {

    private Integer id;

    @Caption("名称")
    @NotBlank
    @NotContainsSpecialChars
    private String name;

    @Caption("备注")
    @NotContainsSpecialChars
    private String remark;

    @Caption("序号")
    private long ordinal;

    @Caption("权限集")
    private Set<String> permissions;

    /**
     * 管理员集
     */
    private Collection<Manager> managers = new TreeSet<>();

    protected void setId(Integer id) {
        this.id = id;
    }

    protected void setManagers(Collection<Manager> managers) {
        this.managers = managers;
    }

    @Override
    public int compareTo(Role other) {
        return Long.valueOf(getOrdinal()).compareTo(other.getOrdinal());
    }

}
