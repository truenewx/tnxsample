package org.truenewx.tnxsample.facade.model.entity;

import java.time.Instant;
import java.util.Collection;
import java.util.Collections;

import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.truenewx.tnxjee.core.caption.Caption;
import org.truenewx.tnxjee.model.entity.unity.Unity;
import org.truenewx.tnxjee.model.spec.user.DefaultUserIdentity;
import org.truenewx.tnxjee.model.spec.user.IntegerUserIdentity;
import org.truenewx.tnxjee.model.spec.user.UserSpecific;
import org.truenewx.tnxjee.model.spec.user.security.DefaultUserSpecificDetails;
import org.truenewx.tnxjee.model.spec.user.security.KindGrantedAuthorityImpl;
import org.truenewx.tnxjee.model.validation.constraint.NotContainsSpecialChars;
import org.truenewx.tnxsample.common.CommonConstants;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * 客户
 *
 * @author jianglei
 */
@Getter
@Setter
@Caption("客户")
public class Customer implements Unity<Integer>, UserSpecific<IntegerUserIdentity> {

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

    public String getType() {
        return CommonConstants.USER_TYPE_CUSTOMER;
    }

    @Override
    @JsonIgnore
    public DefaultUserIdentity getIdentity() {
        return new DefaultUserIdentity(getType(), getId());
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
        return Collections.singletonList(KindGrantedAuthorityImpl.ofType(getType()));
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
