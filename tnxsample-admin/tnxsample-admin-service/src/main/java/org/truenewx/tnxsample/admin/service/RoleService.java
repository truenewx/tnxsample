package org.truenewx.tnxsample.admin.service;

import java.util.List;

import org.truenewx.tnxjee.service.unity.ModelUnityBusinessValidator;
import org.truenewx.tnxjee.service.unity.ModelUnityService;
import org.truenewx.tnxsample.admin.model.entity.Role;

/**
 * 角色服务
 *
 * @author jianglei
 */
public interface RoleService extends ModelUnityService<Role, Integer>, ModelUnityBusinessValidator<Role, Integer> {

    Iterable<Role> findAll();

    List<Role> findByName(String name);

    Role move(int id, boolean down);

}
