package org.truenewx.tnxsample.admin.web.api.util;

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
        UserSpecificDetails<IntegerUserIdentity> details = getManagerDetails();
        return details == null ? null : details.getIdentity().getId();
    }

}
