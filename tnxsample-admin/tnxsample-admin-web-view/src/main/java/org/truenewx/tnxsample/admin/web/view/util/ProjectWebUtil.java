package org.truenewx.tnxsample.admin.web.view.util;

import org.truenewx.tnxjee.model.spec.user.IntegerUserIdentity;
import org.truenewx.tnxjee.model.spec.user.security.UserSpecificDetails;
import org.truenewx.tnxjee.web.security.util.SecurityUtil;

/**
 * WEB工程级工具集
 */
public class ProjectWebUtil {

    private ProjectWebUtil() {
    }

    public static UserSpecificDetails<IntegerUserIdentity> getManagerDetails() {
        return SecurityUtil.getAuthorizedUserDetails();
    }

    public static Integer getManagerId() {
        IntegerUserIdentity userIdentity = SecurityUtil.getAuthorizedUserIdentity();
        return userIdentity == null ? null : userIdentity.getId();
    }

}
