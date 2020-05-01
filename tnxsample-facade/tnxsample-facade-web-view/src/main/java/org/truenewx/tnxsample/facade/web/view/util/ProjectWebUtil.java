package org.truenewx.tnxsample.facade.web.view.util;

import org.truenewx.tnxjee.model.spec.user.IntegerUserIdentity;
import org.truenewx.tnxjee.model.spec.user.security.UserSpecificDetails;
import org.truenewx.tnxjee.web.security.util.SecurityUtil;

/**
 * WEB工程级工具集
 */
public class ProjectWebUtil {

    private ProjectWebUtil() {
    }

    public static UserSpecificDetails<IntegerUserIdentity> getCustomerDetails() {
        return SecurityUtil.getAuthorizedUserDetails();
    }

    public static Integer getCustomerId() {
        UserSpecificDetails<IntegerUserIdentity> details = getCustomerDetails();
        return details == null ? null : details.getIdentity().getId();
    }

}
