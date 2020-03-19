package org.truenewx.tnxsample.admin.web.util;

import org.truenewx.tnxjee.web.security.util.SecurityUtil;
import org.truenewx.tnxsample.admin.model.entity.Manager;

/**
 * WEB工程级工具集
 */
public class ProjectWebUtil {

    private ProjectWebUtil() {
    }

    public static Manager getManager() {
        return SecurityUtil.getAuthorizedUser();
    }

    public static Integer getManagerId() {
        Manager manager = getManager();
        return manager == null ? null : manager.getId();
    }

}
