package org.truenewx.tnxsample.facade.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.truenewx.tnxjee.core.caption.Caption;
import org.truenewx.tnxjee.model.entity.unity.Unity;
import org.truenewx.tnxjee.model.spec.user.UserSpecific;
import org.truenewx.tnxjee.model.spec.user.security.SimpleUserSpecificDetails;
import org.truenewx.tnxjee.model.spec.user.security.UserSpecificDetails;
import org.truenewx.tnxjee.model.validation.constraint.NotContainsSpecialChars;
import org.truenewx.tnxsample.core.model.TypedUserIdentity;
import org.truenewx.tnxsample.core.model.UserType;

import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.Collection;

/**
 * 用户
 *
 * @author jianglei
 */
@Getter
@Setter
@Caption("用户")
public class User implements Unity<Integer>, UserSpecific<TypedUserIdentity> {

    private static final long serialVersionUID = -2252729000555360355L;

    private Integer id;
    @NotBlank
    @Caption("手机号码")
    private String mobilePhone;
    @Caption("密码")
    private String password;
    @NotContainsSpecialChars
    @Caption("昵称")
    private String nickname;
    @Caption("性别")
    private Gender gender;
    @Caption("是否禁用")
    private boolean disabled;
    @Caption("注册时间")
    private Instant createTime;

    protected void setId(Integer id) {
        this.id = id;
    }

    public UserType getType() {
        return UserType.GENERAL;
    }

    @Override
    @JsonIgnore
    public TypedUserIdentity getIdentity() {
        return new TypedUserIdentity(getType(), getId());
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return getMobilePhone();
    }

    @Override
    @JsonIgnore
    public String getCaption() {
        return getNickname();
    }

    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @JsonIgnore
    public UserSpecificDetails<TypedUserIdentity> getSpecificDetails() {
        SimpleUserSpecificDetails<TypedUserIdentity> details = new SimpleUserSpecificDetails<>();
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
