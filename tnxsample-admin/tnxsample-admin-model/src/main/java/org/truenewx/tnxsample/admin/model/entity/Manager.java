package org.truenewx.tnxsample.admin.model.entity;

import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.truenewx.tnxjee.core.caption.Caption;
import org.truenewx.tnxjee.model.entity.unity.Unity;
import org.truenewx.tnxjee.model.spec.user.DefaultUserIdentity;
import org.truenewx.tnxjee.model.spec.user.IntegerUserIdentity;
import org.truenewx.tnxjee.model.spec.user.UserSpecific;
import org.truenewx.tnxjee.model.spec.user.security.DefaultUserSpecificDetails;
import org.truenewx.tnxjee.model.spec.user.security.GrantedPermissionAuthority;
import org.truenewx.tnxjee.model.spec.user.security.GrantedScopeAuthority;
import org.truenewx.tnxjee.model.validation.constraint.NotContainsSpecialChars;
import org.truenewx.tnxsample.common.CommonConstants;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * 管理员
 *
 * @author jianglei
 */
@Getter
@Setter
@Caption("管理员")
public class Manager
        implements Unity<Integer>, Comparable<Manager>, UserSpecific<IntegerUserIdentity> {

    private Integer id;

    @Caption("用户名")
    @NotBlank
    @NotContainsSpecialChars
    private String username;

    @Caption("密码")
    private String password;

    @Caption("头像")
    private String headImageUrl;

    @Caption("姓名")
    @NotBlank
    @NotContainsSpecialChars
    private String fullName;

    @Caption("是否顶级管理员")
    private boolean top;

    @Caption("是否禁用")
    private boolean disabled;

    @Caption("创建时间")
    private Instant createTime;

    /**
     * 角色集
     */
    private Collection<Role> roles = new TreeSet<>();

    protected void setId(Integer id) {
        this.id = id;
    }

    protected void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public String getType() {
        return CommonConstants.USER_TYPE_MANAGER;
    }

    public String getRank() {
        return isTop() ? CommonConstants.MANAGER_RANK_TOP : CommonConstants.MANAGER_RANK_NORMAL;
    }

    @Override
    public int compareTo(Manager other) {
        return getUsername().compareTo(other.getUsername());
    }

    @Override
    @JsonIgnore
    public DefaultUserIdentity getIdentity() {
        return new DefaultUserIdentity(getType(), getId());
    }

    @Override
    @JsonIgnore
    public String getCaption() {
        return getFullName();
    }

    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new GrantedScopeAuthority(getType(), getRank()));
        getRoles().forEach(role -> {
            Set<String> permissions = role.getPermissions();
            if (permissions != null) {
                permissions.forEach(permission -> {
                    authorities.add(new GrantedPermissionAuthority(permission));
                });
            }
        });
        return authorities;
    }

    @JsonIgnore
    public DefaultUserSpecificDetails getSpecificDetails() {
        DefaultUserSpecificDetails details = new DefaultUserSpecificDetails();
        details.setIdentity(getIdentity());
        details.setUsername(getUsername());
        details.setCaption(getCaption());
        details.setAuthorities(getAuthorities());
        details.setEnabled(!isDisabled());
        details.setAccountNonExpired(details.isEnabled());
        details.setAccountNonLocked(details.isEnabled());
        details.setCredentialsNonExpired(details.isEnabled());
        return details;
    }

}
