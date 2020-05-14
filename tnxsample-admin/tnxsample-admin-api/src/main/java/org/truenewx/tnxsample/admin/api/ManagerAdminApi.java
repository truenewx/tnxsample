package org.truenewx.tnxsample.admin.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.truenewx.tnxjee.model.spec.user.security.DefaultUserSpecificDetails;

/**
 * 管理员管理API
 *
 * @author jianglei
 */
@RequestMapping("/admin/manager")
public interface ManagerAdminApi {

    @GetMapping("/{id}/specific-details")
    DefaultUserSpecificDetails getSpecificDetails(@PathVariable("id") int id);

}
