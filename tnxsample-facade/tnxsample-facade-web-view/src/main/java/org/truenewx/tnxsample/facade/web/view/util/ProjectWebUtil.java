package org.truenewx.tnxsample.facade.web.view.util;

import org.truenewx.tnxjee.model.spec.user.security.UserSpecificDetails;
import org.truenewx.tnxjee.web.security.util.SecurityUtil;

/**
 * WEB工程级工具集
 */
public class ProjectWebUtil {

    private ProjectWebUtil() {
    }

    public static UserSpecificDetails<TypedUserIdentity> getCustomerDetails() {
        return SecurityUtil.getAuthorizedUserDetails();
    }

    public static Integer getCustomerId() {
        UserSpecificDetails<TypedUserIdentity> details = getCustomerDetails();
        return details == null ? null : details.getIdentity().getId();
    }

}
