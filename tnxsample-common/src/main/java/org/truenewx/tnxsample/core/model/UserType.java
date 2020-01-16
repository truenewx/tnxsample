package org.truenewx.tnxsample.core.model;

import org.truenewx.tnxjee.core.caption.Caption;

/**
 * 用户类型
 *
 * @author jianglei
 */
public enum UserType {

    @Caption("普通用户")
    GENERAL,

    @Caption("管理员")
    MANAGER;

}
