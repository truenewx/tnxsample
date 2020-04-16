package org.truenewx.tnxsample.admin.web.view.util;

import org.truenewx.tnxjee.model.spec.user.security.UserSpecificDetails;
import org.truenewx.tnxjee.web.security.util.SecurityUtil;
import org.truenewx.tnxsample.core.model.TypedUserIdentity;

/**
 * WEB工程级工具集
 */
public class ProjectWebUtil {

    private ProjectWebUtil() {
    }

    public static UserSpecificDetails<TypedUserIdentity> getManagerDetails() {
        return SecurityUtil.getAuthorizedUserDetails();
    }

    public static Integer getManagerId() {
        UserSpecificDetails<TypedUserIdentity> details = getManagerDetails();
        return details == null ? null : details.getIdentity().getId();
    }

}
